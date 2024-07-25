package com.sqav.tattow.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Budget implements Serializable {
	
	private static final long serialVersionUID = 3655634274794512849L;
	
	private Long budgetId;
	private Long collaboratorId;
	private Long clientId;
	private Boolean approved;
	private LocalDateTime appointmentDate;
	
	public Long getBudgetId() {
		return budgetId;
	}
	
	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
	}
	
	public Long getCollaboratorId() {
		return collaboratorId;
	}
	
	public void setCollaboratorId(Long collaboratorId) {
		this.collaboratorId = collaboratorId;
	}
	
	public Long getClientId() {
		return clientId;
	}
	
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	
	public Boolean getApproved() {
		return approved;
	}
	
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

}