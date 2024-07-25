package com.sqav.tattow.exception;

public class ForbiddenException extends RuntimeException {

	private static final long serialVersionUID = 4085269599948476645L;
	
	private String level = "ERROR"; 

	public ForbiddenException(String message) {
		super(message);
	}
	
	public ForbiddenException(String message, Throwable cause) { 
		super(message, cause);
	}
	
	public ForbiddenException(String message, String level) {
		super(message);
		this.level = level;
	}

	public ForbiddenException(String message, Throwable cause, String level) {
		super(message, cause);
		this.level = level;
	}

	public String getLevel() {
		return level;
	}
	
}