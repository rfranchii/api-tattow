package com.sqav.tattow.exception;

public class RequestLimitException extends RuntimeException {

	private static final long serialVersionUID = -6914575880739996975L;
	
	public RequestLimitException(String message) {
		super(message);
	}
	
	public RequestLimitException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
