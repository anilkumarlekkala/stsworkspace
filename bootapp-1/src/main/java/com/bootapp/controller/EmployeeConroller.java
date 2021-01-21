package com.bootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.model.Employee;
import com.bootapp.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeConroller {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("save")
	public ResponseEntity<?> save(@RequestBody Employee emp)
	{
		return service.save(emp);
	}
	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody Employee emp)
	{
		return service.save(emp);
	}
	@GetMapping("getall")
	public ResponseEntity<?> getAll()
	{
		return service.SelectAllEmployee();
	}

	@GetMapping("get")
	public ResponseEntity<?> getEmpByid(Integer eid)
	{
		return service.selectByEid(eid);
	}
	

}
