package com.bootapp.exception;

public class EmployeeAlredyExistException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeAlredyExistException(String messege)
	{
		super(messege);
	}

}
