package com.itrapp.entities;

public class Sucharge {
	private TaxRate rate;

	public TaxRate getRate() {
		return rate;
	}

	public void setRate(TaxRate rate) {
		this.rate = rate;
	}

	public double calculate(long tax){
		return tax * rate.getRate();
	}
}
