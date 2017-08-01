package com.itrapp.entities;

public abstract class Cess {
	private TaxRate rate;

	public TaxRate getRate() {
		return rate;
	}

	public void setRate(TaxRate rate) {
		this.rate = rate;
	}
	
	public double calculate(double tax){
		return tax * rate.getRate();
	}
}
