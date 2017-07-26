package com.itrapp.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.itrapp.dao.PersonDao;
import com.itrapp.dbmanager.DatabaseConnectionManager;
import com.itrapp.entities.Person;
import com.itrapp.framework.Dependency;

public class JdbcPersonDao implements PersonDao {
	
	@Override
	public Person save(Person person) {
		System.out.println("*****Saving using the JdbcPersonDao*****");
		// TODO Auto-generated method stub
		Connection connection = DatabaseConnectionManager.getConnection();
		String query = "INSERT INTO PERSON (id, first_name, last_name) VALUES (?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			long id = findMaxId(connection)+1;
			statement.setLong(1, id);
			statement.setString(2, person.getFirstName());
			statement.setString(3, person.getLastName());
			statement.executeUpdate();
			statement.close();
			person.setId(id);
			return person;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	
	private long findMaxId(Connection connection){
		String query = "SELECT max(id) FROM PERSON";
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connection.createStatement();
			results = statement.executeQuery(query);
			if(results.next()){
				return results.getLong(1);
			}else{
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
			try{
				results.close();
				statement.close();
			}catch(Exception e){}
		}
	}

}
