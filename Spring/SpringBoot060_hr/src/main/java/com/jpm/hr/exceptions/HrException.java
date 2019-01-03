package com.jpm.hr.exceptions;

public class HrException extends Exception {

	private static final long serialVersionUID = 1L;

	public HrException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public HrException(String message) {
		super(message);
		}
	
}
