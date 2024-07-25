package com.sqav.tattow.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZipCodeResponse implements Serializable {

	private static final long serialVersionUID = -5391263620008585755L;

	@JsonProperty(value = "logradouro")
	private String street;
	private String uf;
	@JsonProperty(value = "localidade")
	private String city;
	@JsonProperty(value = "bairro")
	private String neighborhood;
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
}