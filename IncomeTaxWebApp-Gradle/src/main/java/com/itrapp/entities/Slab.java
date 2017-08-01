package com.itrapp.entities;

public class Slab {
	private double minIncome;
	private double maxIncome;
	private double rate;
	
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getMinIncome() {
		return minIncome;
	}
	public void setMinIncome(double minIncome) {
		this.minIncome = minIncome;
	}
	public double getMaxIncome() {
		return maxIncome;
	}
	public void setMaxIncome(double maxIncome) {
		this.maxIncome = maxIncome;
	}
	public boolean isApplicable(Person person, double income){
		if(this.getMinIncome()<=income &&
				this.getMaxIncome() >=income){
			return true;
		}else{
			return false;
		}
	}
	public double calculateTax(Person person, double income){
		// If the income is 4,00,000, and this slab is from 2-5,
		// In this case since the actual income is less than the max slab
		// The tax should be applicable only on 4,00,000 - 2,00,000 = 2,00,000
		double taxableIncome = this.getMaxIncome()-this.getMinIncome();
		if(income < this.getMaxIncome()){
			taxableIncome = income - this.getMinIncome();
		}
		return taxableIncome * rate;
	}
	
}
