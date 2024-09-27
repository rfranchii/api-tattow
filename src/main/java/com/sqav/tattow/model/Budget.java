package com.sqav.tattow.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sqav.tattow.enumerate.Sex;

public class Budget implements Serializable {
	
	private static final long serialVersionUID = 3655634274794512849L;
	
	private Long budgetId;
	private Long collaboratorId;
//	private Long clientId;
	private String clientName;
	private String clientCpf;
	private Sex clientSex;
	private String clientMail;
	private String clientPhone;
	private Boolean approved;
	private Boolean reproved;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime appointmentDate;
//	private LocalDate appointmentDate;
	@JsonIgnore
	private LocalDateTime insertDate;
	
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
	
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientCpf() {
		return clientCpf;
	}

	public void setClientCpf(String clientCpf) {
		this.clientCpf = clientCpf;
	}

	public Sex getClientSex() {
		return clientSex;
	}

	public void setClientSex(Sex clientSex) {
		this.clientSex = clientSex;
	}

	public String getClientMail() {
		return clientMail;
	}

	public void setClientMail(String clientMail) {
		this.clientMail = clientMail;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public Boolean getApproved() {
		return approved;
	}
	
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	
	public Boolean getReproved() {
		return reproved;
	}

	public void setReproved(Boolean reproved) {
		this.reproved = reproved;
	}

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public LocalDateTime getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(LocalDateTime insertDate) {
		this.insertDate = insertDate;
	}

}