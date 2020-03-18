package com.hcl.bank.exception;

public class BenificiaryNotFoundException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	private static final String STATUS_CODE="2";

	public BenificiaryNotFoundException(Long benificiaryId) {
		super("Benificiary with id :"+benificiaryId+" does not exists.");
	}
	public String getStatusCode()
	{
		return STATUS_CODE;
	}


}
