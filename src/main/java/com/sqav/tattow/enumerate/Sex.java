package com.sqav.tattow.enumerate;

public enum Sex {
	
	MALE("Male"),
	FEMALE("Female"),
	UNDEFINED("Undefined");
	
	private String description;
	
	Sex(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}
