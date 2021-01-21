package com.bootapp.service;

public class EmployeeNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String messege)
	{
		super(messege);
	}
}
