package com.jpm.banking.exceptions;

public class AccountException extends Exception {

	public AccountException(String message, Throwable cause) {
		super(message, cause);	
	}

	public AccountException(String message) {
		super(message);	
	}
	
}
