package com.jp.fin.exceptions;

public class FinException extends Exception {

	public FinException(String message, Throwable cause) {
		super(message, cause);
	}

	public FinException(String message) {
		super(message);
	}
	
}
