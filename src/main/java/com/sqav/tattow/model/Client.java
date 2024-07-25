package com.sqav.tattow.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import com.sqav.tattow.enumerate.Sex;

public class Client implements Serializable {

	private static final long serialVersionUID = 1964535288051138074L;
	
	private Long clientId;
	private Long userId;
	private String name;
	private String email;
	private String cpf;
	private String cnpj;
	private String photo;
	private String phone;
	private LocalDate birthDate;
	private Sex sex;
	private String zipCode;
	private String fullAddres;
	private LocalDateTime insertDate;
	
	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

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
	
	public LocalDateTime getInsertDate() {
		return insertDate;
	}
	
	public void setInsertDate(LocalDateTime insertDate) {
		this.insertDate = insertDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, cnpj, cpf, email, fullAddres, insertDate, name, phone, photo, sex, userId,
				zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(clientId, other.clientId) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email)
				&& Objects.equals(fullAddres, other.fullAddres) && Objects.equals(insertDate, other.insertDate)
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
				&& Objects.equals(photo, other.photo) && sex == other.sex && Objects.equals(userId, other.userId)
				&& Objects.equals(zipCode, other.zipCode);
	}

}