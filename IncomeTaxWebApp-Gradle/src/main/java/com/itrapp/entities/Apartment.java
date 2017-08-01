package com.itrapp.entities;

public class Apartment extends Property {
	private String sqFt;
	private String value;
	public String getSqFt() {
		return sqFt;
	}
	public void setSqFt(String sqFt) {
		this.sqFt = sqFt;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
