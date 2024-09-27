package com.sqav.tattow.model;

import com.sqav.tattow.enumerate.Profile;

public class UserResult {
	
	private Long userId;
	private String name;
	private Profile profile;
	private Boolean acceptTerm;
	private String photo;
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Profile getProfile() {
		return profile;
	}
	
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	public Boolean getAcceptTerm() {
		return acceptTerm;
	}
	
	public void setAcceptTerm(Boolean acceptTerm) {
		this.acceptTerm = acceptTerm;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}