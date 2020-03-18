package com.hcl.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hcl.bank.dto.ExceptionDetailsDto;


@ControllerAdvice
public class GlobalException  {

	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<Object> accountNotFoundExceptionHandler(AccountNotFoundException accountNotFoundException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(accountNotFoundException.getMessage(), accountNotFoundException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BenificiaryNotFoundException.class)
	public ResponseEntity<Object> accountNotFoundExceptionHandler(BenificiaryNotFoundException benificiaryNotFoundException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(benificiaryNotFoundException.getMessage(), benificiaryNotFoundException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(CustomerNotLoggedInException.class)
	public ResponseEntity<Object> customerNotLoggedInExceptionHandler(CustomerNotLoggedInException customerNotLoggedInException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(customerNotLoggedInException.getMessage(), customerNotLoggedInException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(InsuffiecientFundException.class)
	public ResponseEntity<Object> insuffiecientFundExceptionHandler(InsuffiecientFundException insuffiecientFundException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(insuffiecientFundException.getMessage(), insuffiecientFundException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundExceptionHandler(UserNotFoundException userNotFoundException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(userNotFoundException.getMessage(), userNotFoundException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotRegisteredException.class)
	public ResponseEntity<Object> customerNotRegisteredExceptionHandler(CustomerNotRegisteredException customerNotRegisteredException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(customerNotRegisteredException.getMessage(), customerNotRegisteredException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	}
	
	

}

