package com.cg.anurag.pecunia.account.dto;
public class Address 
{
	long addId;
	String city;
	String state;
	String country;
	long zipCode;
	public Address() {	}
	public Address(long addId, String city, String state,String country, long zipCode) 
	{	
		this.addId = addId;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}
	public long getAddId() {
		return addId;
	}
	public void setAddId(long addId) {
		this.addId = addId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getZipCode() {
		return zipCode;
	}
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	}