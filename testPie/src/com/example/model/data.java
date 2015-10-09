package com.example.model;

import java.io.Serializable;

public class data implements Serializable{

	private String country;
	private String litres;
	public data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public data(String country, String litres) {
		super();
		this.country = country;
		this.litres = litres;
	}
	@Override
	public String toString() {
		return "data [country=" + country + ", litres=" + litres + "]";
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLitres() {
		return litres;
	}
	public void setLitres(String litres) {
		this.litres = litres;
	}
	
	
}
