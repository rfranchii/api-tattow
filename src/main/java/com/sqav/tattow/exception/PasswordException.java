package com.sqav.tattow.exception;

public class PasswordException extends RuntimeException {

	private static final long serialVersionUID = 4085269599948476645L;
	
	private String level = "ERROR"; 

	public PasswordException(String message) {
		super(message);
	}
	
	public PasswordException(String message, Throwable cause) { 
		super(message, cause);
	}
	
	public PasswordException(String message, String level) {
		super(message);
		this.level = level;
	}

	public PasswordException(String message, Throwable cause, String level) {
		super(message, cause);
		this.level = level;
	}

	public String getLevel() {
		return level;
	}
	
}