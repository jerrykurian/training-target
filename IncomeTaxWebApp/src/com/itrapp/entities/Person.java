package com.itrapp.entities;

import java.util.Set;

public class Person {
	private long id;
	private int age;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Address address;
	private Set<Income> incomes;
	
	public Person(){
		
	}
	public Person(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Set<Income> getIncomes() {
		return incomes;
	}
	public void setIncomes(Set<Income> incomes) {
		this.incomes = incomes;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Person(String firstName, String lastName, Gender gender){
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Income> getIncome(){
		return this.incomes;
	}
	public void setIncome(Set<Income> incomes){
		this.incomes = incomes;
	}
}
