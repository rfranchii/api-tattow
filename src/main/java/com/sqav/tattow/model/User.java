package com.sqav.tattow.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.sqav.tattow.enumerate.Profile;
import com.sqav.tattow.vo.UserRequest;

public class User implements Serializable {

	private static final long serialVersionUID = 5391335940010267849L;
	
	private Long userId;
	private String login;
	private String password;
	private Profile profile;
	private Boolean active;
	private LocalDateTime activationDate;
	private Boolean blocked;
	private LocalDateTime blockadeDate;
	private Boolean acceptTerm;
	private LocalDateTime termAcceptedDate;
	private LocalDateTime insertDate;
	
	public User() {
		super();
	}

	public User(UserRequest request, Profile profile) {
		super();
		this.login = request.getLogin();
		this.password = request.getPassword();
		this.profile = profile;
		this.active = Boolean.TRUE;
		this.activationDate = LocalDateTime.now();
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
	
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public LocalDateTime getActivationDate() {
		return activationDate;
	}
	
	public void setActivationDate(LocalDateTime activationDate) {
		this.activationDate = activationDate;
	}
	
	public Boolean getBlocked() {
		return blocked;
	}
	
	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}
	
	public LocalDateTime getBlockadeDate() {
		return blockadeDate;
	}
	
	public void setBlockadeDate(LocalDateTime blockadeDate) {
		this.blockadeDate = blockadeDate;
	}
	
	public Boolean getAcceptTerm() {
		return acceptTerm;
	}
	
	public void setAcceptTerm(Boolean acceptTerm) {
		this.acceptTerm = acceptTerm;
	}
	
	public LocalDateTime getTermAcceptedDate() {
		return termAcceptedDate;
	}
	
	public void setTermAcceptedDate(LocalDateTime termAcceptedDate) {
		this.termAcceptedDate = termAcceptedDate;
	}
	
	public LocalDateTime getInsertDate() {
		return insertDate;
	}
	
	public void setInsertDate(LocalDateTime insertDate) {
		this.insertDate = insertDate;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(acceptTerm, activationDate, active, blockadeDate, blocked, insertDate, login, password,
				profile, termAcceptedDate, userId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(acceptTerm, other.acceptTerm) && Objects.equals(activationDate, other.activationDate)
				&& Objects.equals(active, other.active) && Objects.equals(blockadeDate, other.blockadeDate)
				&& Objects.equals(blocked, other.blocked) && Objects.equals(insertDate, other.insertDate)
				&& Objects.equals(login, other.login) && Objects.equals(password, other.password)
				&& profile == other.profile && Objects.equals(termAcceptedDate, other.termAcceptedDate)
				&& Objects.equals(userId, other.userId);
	}
	
	
	
}