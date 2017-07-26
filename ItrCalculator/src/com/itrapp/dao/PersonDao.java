package com.itrapp.dao;

import java.util.List;

import com.itrapp.entities.Person;

public interface PersonDao {
	
	public Person save(Person person);
	public List<Person> findAll();
	public Person findById(long id);
	public void delete(Person person);
}
