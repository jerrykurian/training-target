package com.itrapp.entities;

import java.util.Set;

public class Rent extends Income{
	Set<Property> properties;

	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}
	
	public IncomeType getType(){
		return IncomeType.RENT;
	}
}
