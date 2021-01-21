package com.bootapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.exceptions.ErrorResponse;
import com.bootapp.exceptions.RecordNotFoundException;
import com.bootapp.model.Employee;
import com.bootapp.service.EmployeeNotFoundException;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	com.bootapp.service.impl.EmployeeService service;

	@Autowired
	ErrorResponse response;

	@PostMapping("/save")
	public Employee saveEmployee(@Valid @RequestBody Employee emp) {
		return service.saveEmployee(emp);
	}

	@PutMapping("/update")
	public Employee updateEmployee(@Valid @RequestBody Employee emp) {
		return service.updateEmployee(emp);
	}

	@GetMapping("/selectAll")
	public ResponseEntity<?> getAllEmployee() throws RecordNotFoundException {
		List<Employee> emp = service.displayAllEmployee();
		if (emp == null) {
			throw new RecordNotFoundException("employee not found");
		} else {
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}
	}

	@GetMapping("/select")
	public ResponseEntity<?> getById(@RequestParam Integer eid) throws EmployeeNotFoundException{
		Employee emp = service.displayEmployee(eid);

			return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public void deleteEmployee(@RequestBody Employee emp) {
		service.deleteEmployee(emp);
	}
}
