package com.itrapp.enduser.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.itrapp.dao.IncomeDao;
import com.itrapp.dao.PersonDao;
import com.itrapp.enduser.PersonDetailsManager;
import com.itrapp.enduser.UserNotFoundException;
import com.itrapp.entities.Gender;
import com.itrapp.entities.Income;
import com.itrapp.entities.Person;
import com.itrapp.entities.Salary;

@Component
public class PersonDetailsManagerImpl implements PersonDetailsManager {
	
	@Autowired
	private PersonDao personDao;
	@Autowired
	private IncomeDao incomeDao;
	
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
	
	@Transactional
	public Income createIncome(Salary income){
		income = incomeDao.saveSalary(income);
		incomeDao.saveSalary((Salary) income);
		return income;
	}
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	public void setIncomeDao(IncomeDao incomeDao) {
		this.incomeDao = incomeDao;
	}

	@Override
	public Person findPersonById(long id) {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setFirstName("Dan");
		person.setLastName("Danny");
		
		return person;
	}

	@Override
	public Person findByUserNameAndPassword(String userName, String password) 
		throws UserNotFoundException{
		// TODO Auto-generated method stub
		if(userName.equals("error")){
			throw new UserNotFoundException();
		}else{
			return new Person();
		}
	}
}
