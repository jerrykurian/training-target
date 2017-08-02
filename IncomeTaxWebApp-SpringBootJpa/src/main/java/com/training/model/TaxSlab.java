package com.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tax_slab")
public class TaxSlab {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="lower_age")
	private int lowerAge;
	@Column(name="upper_age")
	private int upperAge;
	@Column
	private String gender;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getLowerAge() {
		return lowerAge;
	}
	public void setLowerAge(int lowerAge) {
		this.lowerAge = lowerAge;
	}
	public int getUpperAge() {
		return upperAge;
	}
	public void setUpperAge(int upperAge) {
		this.upperAge = upperAge;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
