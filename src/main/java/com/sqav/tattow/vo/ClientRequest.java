package com.sqav.tattow.vo;

import java.time.LocalDate;

import com.sqav.tattow.enumerate.Sex;

public class ClientRequest {

	private Long clientId;
	private String name;
	private String email;
	private String cpf;
	private String cnpj;
	private String photo;
	private String phone;
	private LocalDate birthDate;
	private Sex sex = Sex.UNDEFINED;
	private String zipCode;
	private String fullAddres;
	
	public ClientRequest() {
		super();
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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