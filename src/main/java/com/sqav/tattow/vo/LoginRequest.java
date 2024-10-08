package com.sqav.tattow.vo;

import java.io.Serializable;

import com.sqav.tattow.enumerate.Profile;

public class LoginRequest implements Serializable {
	
	private static final long serialVersionUID = -8770008032367191371L;
	
	private String login;
	private String password;
	private Profile profile;
	
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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
}
