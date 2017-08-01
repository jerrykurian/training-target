package com.itrapp.calculator.impl;

import java.util.List;
import java.util.Set;

import com.itrapp.calculator.TaxCalculator;
import com.itrapp.entities.Gender;
import com.itrapp.entities.Income;
import com.itrapp.entities.Person;
import com.itrapp.entities.TaxSlab;
import com.itrapp.taxauthority.TaxDetailsManager;

public class ItrCalculator implements TaxCalculator {
	private TaxDetailsManager taxDetailsManager;
	
	public ItrCalculator(TaxDetailsManager taxDetailsManager) {
		// TODO Auto-generated constructor stub
		this.taxDetailsManager = taxDetailsManager;
	}
 
	@Override
	public double calculateTax(Person person) {
		// TODO Auto-generated method stub
		// 1. Find person's age, gender and income
		int age = person.getAge();
		Gender gender = person.getGender();
		Set<Income> incomes = person.getIncome();
		// 2. Find the tax slab that apply
		TaxSlab taxSlab = taxDetailsManager.findTaxSlabFor(age, gender);
		// 3. Apply the taxes on the income
		double taxAmount = applyTaxesToIncome(incomes, taxSlab);
		// 4. Find all the cess
		// 5. Apply the cess
		return 0;
	}

	private double applyTaxesToIncome(Set<Income> incomes, TaxSlab taxSlab) {
		// TODO Auto-generated method stub
		// Add the taxes
		return 0;
	}

}
