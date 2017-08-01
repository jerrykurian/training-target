package com.itrapp.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.itrapp.dao.IncomeDao;
import com.itrapp.dbmanager.DatabaseConnectionManager;
import com.itrapp.entities.Income;
import com.itrapp.entities.Salary;

@Component
public class JdbcIncomeDao implements IncomeDao {
	
	@Override
	public Salary saveSalary(Salary salary) {
		// TODO Auto-generated method stub
		Connection conn = DatabaseConnectionManager.getConnection();
		try {
			conn.setAutoCommit(false);
			salary = (Salary) saveIncome(salary, conn);
			// Do the rest of the operation
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return salary;
	}
	
	private Income saveIncome(Income income, Connection conn) {
		// TODO Auto-generated method stub
		// Save to the DB
		// Get max ID
		return income;
	}


}
