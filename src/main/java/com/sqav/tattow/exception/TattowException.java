package com.sqav.tattow.exception;

public class TattowException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String level = "ERROR";
	
	private Object object;
	
	public TattowException(String message) {
		super(message);
	}

	public TattowException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public TattowException(String message, String level) {
		super(message);
		this.level = level;
	}
	
	public TattowException(String message, Throwable cause, String level) {
		super(message, cause);
		this.level = level;
	}
	
	public TattowException(String message, Object object) {
		super(message);
		this.object = object;
	}

	public String getLevel() {
		return level;
	}

	public Object getObject() {
		return object;
	}

}