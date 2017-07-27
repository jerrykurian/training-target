package com.itrapp.entities;

import java.util.List;

public class TaxSlab {
	List<Slab> slabs;
	private Gender gender;
	private int lowerAge;
	private int upperAge;
	public List<Slab> getSlabs() {
		return slabs;
	}
	public void setSlabs(List<Slab> slabs) {
		this.slabs = slabs;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
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
	public void addSlab(Slab slab){
		this.slabs.add(slab);
	}
}
