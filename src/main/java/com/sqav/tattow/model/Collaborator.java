package com.sqav.tattow.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import com.sqav.tattow.enumerate.Sex;
import com.sqav.tattow.vo.CollaboratorRequest;

public class Collaborator implements Serializable {

	private static final long serialVersionUID = 1615127085584270467L;
	
	private Long collaboratorId;
	private Long userId;
	private String name;
	private String mail;
	private String cpf;
	private String cnpj;
	private String photo;
	private String phone;
	private LocalDate birthDate;
	private String studioName;
	private Sex sex;
	private String zipCode;
	private String fullAddress;
	private LocalDateTime insertDate;
	
	public Collaborator() {
		super();
	}
	
	public Collaborator(Long idUser, CollaboratorRequest collaborator) {
		super();
		this.userId = idUser;
		this.name = collaborator.getName();
		this.mail = collaborator.getMail();
		this.cpf = collaborator.getCpf();
		this.cnpj = collaborator.getCnpj();
		this.photo = collaborator.getPhoto();
		this.phone = collaborator.getPhone();
		this.birthDate = collaborator.getBirthDate();
		this.studioName = collaborator.getStudioName();
		this.sex = collaborator.getSex();
		this.zipCode = collaborator.getZipCode();
		this.fullAddress = collaborator.getFullAddress();
	}

	public Long getCollaboratorId() {
		return collaboratorId;
	}
	
	public void setCollaboratorId(Long collaboratorId) {
		this.collaboratorId = collaboratorId;
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
	
	public String getFullAddress() {
		return fullAddress;
	}
	
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	
	public LocalDateTime getInsertDate() {
		return insertDate;
	}
	
	public void setInsertDate(LocalDateTime insertDate) {
		this.insertDate = insertDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, collaboratorId, cpf, mail, fullAddress, insertDate, name, phone, photo, sex,
				studioName, userId, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Collaborator other = (Collaborator) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(collaboratorId, other.collaboratorId)
				&& Objects.equals(cpf, other.cpf) && Objects.equals(mail, other.mail)
				&& Objects.equals(fullAddress, other.fullAddress) && Objects.equals(insertDate, other.insertDate)
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
				&& Objects.equals(photo, other.photo) && sex == other.sex
				&& Objects.equals(studioName, other.studioName) && Objects.equals(userId, other.userId)
				&& Objects.equals(zipCode, other.zipCode);
	}

}