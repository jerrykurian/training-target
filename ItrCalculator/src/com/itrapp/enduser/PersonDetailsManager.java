package com.itrapp.enduser;

import java.util.List;

import com.itrapp.entities.Gender;
import com.itrapp.entities.Income;
import com.itrapp.entities.Person;

public interface PersonDetailsManager {
	Person createPerson(String firstName, String lastName, 
			int age, Gender gender, List<Income> incomes);
}
