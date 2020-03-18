package com.hcl.bank.exception;

public class CustomerNotRegisteredException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	private static final String STATUS_CODE="6";

	public CustomerNotRegisteredException(String email) {
		super("Customer with emailId :"+email+" not registered.");
	}
	public String getStatusCode()
	{
		return STATUS_CODE;
	}

}
