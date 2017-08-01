package com.itrapp.dao.jpa;

import java.util.List;

import com.itrapp.dao.PersonDao;
import com.itrapp.entities.Person;
import com.itrapp.framework.Dependency;

@Dependency
public class JpaPersonDao implements PersonDao {

	@Override
	public Person save(Person person) {
		// TODO Auto-generated method stub
		System.out.println("*******Saving using JpaPersonDao******");
		return person;
	}

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Person person) {
		// TODO Auto-generated method stub

	}

}
