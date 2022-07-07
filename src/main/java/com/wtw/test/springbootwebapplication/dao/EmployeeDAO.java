package com.wtw.test.springbootwebapplication.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.wtw.test.springbootwebapplication.model.Employee;

@Component
public class EmployeeDAO {
	public Connection con = getDBConnection();
	
	public Employee updateEmployee(int id, Employee updatedEmployee) throws SQLException {
		
		String query1 = "UPDATE employee SET name = ?, address = ?, role = ?, salary = ? WHERE id = ?";
		try { 
				PreparedStatement ps = con.prepareStatement(query1);
				ps.setString(1, updatedEmployee.getName());
				ps.setString(2, updatedEmployee.getAddress());
				ps.setString(3, updatedEmployee.getRole());
				ps.setFloat(4, updatedEmployee.getSalary());
				ps.setInt(5, id);
				int rowUpdated = ps.executeUpdate();
				
				System.out.println(rowUpdated);
				
				if (rowUpdated <= 0)
					throw new SQLException ("No entry found for the given id.");
				ps.close();
				
				System.out.println("Record updated successfully.");
		}
		catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		updatedEmployee.setId(id);
		
		return updatedEmployee;
	}
	
	public void deleteEmployee(int id) throws SQLException {
		String query2 = "DELETE FROM employee WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query2);
			ps.setInt(1, id);
			int rowUpdated = ps.executeUpdate();
			
			System.out.println(rowUpdated);
			
			if (rowUpdated <= 0)
				throw new SQLException ("No entry found for the given id.");
			ps.close();
			
			System.out.println("Record deleted successfully from database.");
		}
		catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
	}

	private Connection getDBConnection() 
	{
		Connection con = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return con;
	}
}
