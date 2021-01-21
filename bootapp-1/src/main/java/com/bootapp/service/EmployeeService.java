package com.bootapp.service;

import org.springframework.http.ResponseEntity;

import com.bootapp.model.Employee;

public interface EmployeeService {

	public ResponseEntity<Object> save(Employee employee);
	public ResponseEntity<Object> update(Employee employee);
	public void delete(Employee emp);
	public ResponseEntity<?> selectByEid(Integer eid);
	public ResponseEntity<?> SelectAllEmployee();
}
