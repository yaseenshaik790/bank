package com.hcl.bank.exception;

public class InsuffiecientFundException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String STATUS_CODE = "4";

	public InsuffiecientFundException(String message) {
		super(message);
	}

	public String getStatusCode() {
		return STATUS_CODE;
	}

}
