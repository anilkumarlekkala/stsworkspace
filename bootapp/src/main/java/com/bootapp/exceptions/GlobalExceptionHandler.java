package com.bootapp.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.bootapp.service.EmployeeNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public final ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex,WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Employee Not Found", details);
        request.getDescription(false);
        return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
    }
}
