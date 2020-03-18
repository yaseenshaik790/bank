package com.hcl.bank.exception;

public class CustomerNotLoggedInException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	private static final String STATUS_CODE="3";

	public CustomerNotLoggedInException(Long customerId) {
		super("Customer with id :"+customerId+" does not logged in.");
	}
	public String getStatusCode()
	{
		return STATUS_CODE;
	}
	
	

}
