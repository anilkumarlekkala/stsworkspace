package com.bootapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.model.Employee;
import com.bootapp.repo.EmployeeRepository;
import com.bootapp.service.EmployeeNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository emprepo;
	
	
	public Employee saveEmployee(Employee employee) {
		
		return emprepo.save(employee);
	}

	
	public Employee updateEmployee(Employee employee) {
		
		return emprepo.save(employee);
	}

	
	public void deleteEmployee(Employee employee) {
		emprepo.delete(employee);

	}


	public List<Employee> displayAllEmployee() {
		
		
		return emprepo.findAll();

	}


	public Employee displayEmployee(Integer eid) throws EmployeeNotFoundException {
		
		Optional<Employee> emp=emprepo.findById(eid);
		
		if(!emp.isPresent()) 
			{throw new EmployeeNotFoundException("emp not found with id:"+eid);}
		
		return emp.get();
	}

}
