package com.itrapp.enduser.impl;

import java.util.List;

import com.itrapp.dao.PersonDao;
import com.itrapp.enduser.PersonDetailsManager;
import com.itrapp.entities.Gender;
import com.itrapp.entities.Income;
import com.itrapp.entities.Person;
import com.itrapp.framework.InjectDependency;

public class PersonDetailsManagerImpl implements PersonDetailsManager {
	@InjectDependency(name="personDao")
	private PersonDao personDao;
	
	@Override
	public Person createPerson(String firstName, String lastName,
			int age, Gender gender, List<Income> incomes) {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAge(age);
		person.setGender(gender);
		personDao.save(person);
		return person;
	}
}
