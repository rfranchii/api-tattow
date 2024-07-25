package com.sqav.tattow.enumerate;

public enum Profile {
	
	COLLABORATOR("Collaborator"),
	CLIENT("Client");
	
	private String description;
	
	Profile(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}
