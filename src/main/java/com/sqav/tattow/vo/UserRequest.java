package com.sqav.tattow.vo;

public class UserRequest {
	
	private Long userId;
	private String login;
	private String password;
	private String passwordConfirmation;
	private CollaboratorRequest collaborator;
	private ClientRequest client;
	
	public UserRequest() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public CollaboratorRequest getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(CollaboratorRequest collaborator) {
		this.collaborator = collaborator;
	}

	public ClientRequest getClient() {
		return client;
	}

	public void setClient(ClientRequest client) {
		this.client = client;
	}
	
}