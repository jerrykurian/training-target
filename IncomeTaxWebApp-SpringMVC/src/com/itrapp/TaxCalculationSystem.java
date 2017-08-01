package com.itrapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itrapp.calculator.TaxCalculator;
import com.itrapp.calculator.impl.ItrCalculator;
import com.itrapp.dbmanager.DatabaseConnectionManager;
import com.itrapp.enduser.PersonDetailsManager;
import com.itrapp.enduser.impl.PersonDetailsManagerImpl;
import com.itrapp.entities.Gender;
import com.itrapp.entities.Income;
import com.itrapp.entities.Person;
import com.itrapp.entities.Rent;
import com.itrapp.entities.Salary;
import com.itrapp.entities.Slab;
import com.itrapp.entities.TaxSlab;
import com.itrapp.framework.DependencyInjector;
import com.itrapp.taxauthority.TaxDetailsManager;
import com.itrapp.taxauthority.impl.TaxDetailsManagerImpl;

public class TaxCalculationSystem {
	private static PersonDetailsManager personDetailsManager;
	private static TaxDetailsManager taxDetailsManager;
	private static TaxCalculator taxCalculator;
	
	public static void main(String[] args) {
		testDependencyInjection();
	}

	private static void testDependencyInjection(){
		personDetailsManager = new PersonDetailsManagerImpl();
		try {
			DependencyInjector.injectDependency(personDetailsManager);
			Person person = createPerson();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void testMethods(){
		// TODO Auto-generated method stub
		Connection connection = DatabaseConnectionManager.getConnection();
		System.out.println("Got Connection " + connection);
		findPeople();
		findPeople("Dan");
		findPeopleUsingPreparedStatement("'; delete from person where first_nameDan");
		
		taxDetailsManager = new TaxDetailsManagerImpl();
		taxCalculator = new ItrCalculator(taxDetailsManager);
		setupTaxSlabs();
		Person person = createPerson();
		findPeople();
		double tax = calculateTaxAmount(person);
		System.out.println("The calculated taxes are " + tax);
	}
	private static double calculateTaxAmount(Person person) {
		// TODO Auto-generated method stub
		return taxCalculator.calculateTax(person);
	}

	private static List<TaxSlab> setupTaxSlabs() {
		// TODO Auto-generated method stub
		Slab slab1 = new Slab();
		slab1.setMinIncome(150000);
		slab1.setMaxIncome(300000);
		slab1.setRate(5);
		Slab slab2 = new Slab();
		slab2.setMinIncome(300001);
		slab2.setMaxIncome(1000000);
		slab2.setRate(10);
		List<Slab> slabs = new ArrayList<Slab>();
		slabs.add(slab1);
		slabs.add(slab2);
		List<TaxSlab> taxSlabs = new ArrayList();
		taxSlabs.add(taxDetailsManager.addTaxSlab(25, 58, Gender.MALE, slabs));
		
		return taxSlabs;
	}

	private static Person createPerson() {
		// TODO Auto-generated method stub
		Income salary = new Salary();
		salary.setAmount(200000);
		Income rent = new Rent();
		rent.setAmount(20000);
		List<Income> incomes = new ArrayList<Income>();
		incomes.add(salary);
		incomes.add(rent);
		return personDetailsManager.createPerson("UserF", "UserL",
				25, Gender.MALE, incomes);
	}

	public static void findPeople(){
		Connection connection = DatabaseConnectionManager.getConnection();
		try {
			Statement statement = connection.createStatement();
			System.out.println("Got Statement");
			String query = "SELECT * FROM person ";
			System.out.println("Executing query " + query);
			ResultSet results = statement.executeQuery(query);
			System.out.println("Got results");
			while(results.next()){
				Long id = results.getLong(1);
				String firstName = results.getString(2);
				String lastName = results.getString(3);
				System.out.println("Got id " + id + " firstName " 
				+ firstName + " lastName " + lastName);
			}
			System.out.println("Printed all results");
			results.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void findPeople(String firstName){
		Connection connection = DatabaseConnectionManager.getConnection();
		try {
			Statement statement = connection.createStatement();
			System.out.println("Got Statement");
			String query = "SELECT * FROM person where first_name='" + firstName + "'";
			System.out.println("Executing query " + query);
			ResultSet results = statement.executeQuery(query);
			System.out.println("Got results");
			while(results.next()){
				Long id = results.getLong(1);
				String fName = results.getString(2);
				String lastName = results.getString(3);
				System.out.println("Got id " + id + " firstName " 
				+ fName + " lastName " + lastName);
			}
			System.out.println("Printed all results");
			results.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void findPeopleUsingPreparedStatement(String firstName){
		Connection connection = DatabaseConnectionManager.getConnection();
		try {
			System.out.println("Got Statement");
			String query = "SELECT * FROM person where first_name=? and last_name=?";
			System.out.println("Executing query " + query);
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, firstName);
			statement.setString(2, firstName);
			ResultSet results = statement.executeQuery();
			System.out.println("Got results");
			while(results.next()){
				Long id = results.getLong(1);
				String fName = results.getString(2);
				String lastName = results.getString(3);
				System.out.println("Got id " + id + " firstName " 
				+ fName + " lastName " + lastName);
			}
			System.out.println("Printed all results");
			results.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
















