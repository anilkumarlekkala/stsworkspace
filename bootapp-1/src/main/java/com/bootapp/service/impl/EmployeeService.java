package com.bootapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bootapp.exception.EmployeeAlredyExistException;
import com.bootapp.exception.EmployeeNotFoundException;
import com.bootapp.model.Employee;
import com.bootapp.repo.EmployeeRepository;

@Service
public class EmployeeService implements com.bootapp.service.EmployeeService {

	@Autowired
	EmployeeRepository repository;
	
	@Override
	public ResponseEntity<Object> save(Employee employee) {
		boolean b=repository.existsByEmail(employee.getEmail());
		
		if(b)
		{
			throw new EmployeeAlredyExistException("employye with email "+employee.getEmail()+" already exist");
		}
		return new ResponseEntity<Object>(repository.save(employee), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> update(Employee employee) {
	
		return new ResponseEntity<Object>(repository.save(employee), HttpStatus.OK);
		
	}

	@Override
	public void delete(Employee emp) {
		if(repository.existsById(emp.getEid()))
		{
			repository.delete(emp);
		}
		else
		{
			throw new EmployeeNotFoundException("employee with id "+emp.getEid()+" not exist");
		}
		
	}

	@Override
	public ResponseEntity<?> selectByEid(Integer eid) {
		if(repository.existsById(eid))
		{
			return new ResponseEntity<>(repository.findById(eid),HttpStatus.OK);
		}
		else
		{
		throw new EmployeeNotFoundException("employee with id "+eid+" not exist");
		}
	}

	@Override
	public ResponseEntity<?> SelectAllEmployee() throws EmployeeNotFoundException{
		List<Employee> list= repository.findAll();
		if(list.isEmpty())
		{
			throw new EmployeeNotFoundException("employee table is empty");
			
		}else {
		return new ResponseEntity<>(list,HttpStatus.OK);
		}
	}

	
}
