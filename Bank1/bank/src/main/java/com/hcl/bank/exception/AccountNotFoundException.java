package com.hcl.bank.exception;

public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String STATUS_CODE="1";

	public AccountNotFoundException(Long accountNumber) {
		super("Account with account number :"+accountNumber+"does not exists.");
	}
	public String getStatusCode()
	{
		return STATUS_CODE;
	}

}
