package com.itrapp.entities;

import java.util.Date;

public abstract class Income {
	private Date incomeDate;
	private long amount;
		
	public Date getIncomeDate() {
		return incomeDate;
	}
	public void setIncomeDate(Date incomeDate) {
		this.incomeDate = incomeDate;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	public abstract IncomeType getType();
}
