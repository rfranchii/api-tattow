package com.sqav.tattow.vo;

import java.time.LocalDate;

import com.sqav.tattow.enumerate.Sex;

public class CollaboratorRequest {
	
	private Long collaboratorId;
	private String name;
	private String mail;
	private String cpf;
	private String cnpj;
	private String photo;
	private String phone;
	private LocalDate birthDate;
	private String studioName;
	private Sex sex = Sex.UNDEFINED;
	private String zipCode;
	private String fullAddres;

	public CollaboratorRequest() {
		super();
	}

	public Long getCollaboratorId() {
		return collaboratorId;
	}

	public void setCollaboratorId(Long collaboratorId) {
		this.collaboratorId = collaboratorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getStudioName() {
		return studioName;
	}

	public void setStudioName(String studioName) {
		this.studioName = studioName;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getFullAddres() {
		return fullAddres;
	}

	public void setFullAddres(String fullAddres) {
		this.fullAddres = fullAddres;
	}
	
}