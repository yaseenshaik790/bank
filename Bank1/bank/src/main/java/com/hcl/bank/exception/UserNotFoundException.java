package com.hcl.bank.exception;

public class UserNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	private static final String STATUS_CODE="5";

	public UserNotFoundException(Long customerId) {
		super("Customer with id :"+customerId+" mot found.");
	}
	public String getStatusCode()
	{
		return STATUS_CODE;
	}

}
