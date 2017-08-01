package com.itrapp.entities;

public class Salary extends Income{
	private Company employer;

	public Company getEmployer() {
		return employer;
	}

	public void setEmployer(Company employer) {
		this.employer = employer;
	}
	public IncomeType getType(){
		return IncomeType.SALARY;
	}
}
