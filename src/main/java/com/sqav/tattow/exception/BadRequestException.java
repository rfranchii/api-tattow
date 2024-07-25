package com.sqav.tattow.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -7042895558899644098L;
	
	public BadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public BadRequestException(String message, Throwable cause) { 
		super(message, cause);
	}
	
	public BadRequestException(String message) {
		super(message);
	}
	
	public BadRequestException(Throwable cause) {
		super(cause);
	}

}