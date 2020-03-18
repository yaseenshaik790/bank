package com.hcl.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionDetailsDto {

	@JsonProperty("errorMessage")
	private String errorMessage;
	
	@JsonProperty("statusCode")
	private Integer statusCode;

	public ExceptionDetailsDto(String errorMessage, Integer statusCode) {
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
	}

	public ExceptionDetailsDto(String message, String description) {
	}
	@JsonProperty("errorMessage")
	public String getErrorMessage() {
		return errorMessage;
	}
	@JsonProperty("errorMessage")
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@JsonProperty("statusCode")
	public Integer getStatusCode() {
		return statusCode;
	}
	@JsonProperty("statusCode")
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
}
