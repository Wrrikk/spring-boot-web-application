package com.wtw.test.springbootwebapplication.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.wtw.test.springbootwebapplication.model.Employee;

@Component
public class EmployeeDAO {
	public static Connection con = getDBConnection();
	
	public static Employee updateEmployee(int id, Employee updatedEmployee) throws SQLException {
		
		String query1 = "UPDATE employee SET name = ?, address = ?, role = ?, salary = ? WHERE id = ?";
		try { 
				PreparedStatement ps = con.prepareStatement(query1);
				ps.setString(1, updatedEmployee.getName());
				ps.setString(2, updatedEmployee.getAddress());
				ps.setString(3, updatedEmployee.getRole());
				ps.setFloat(4, updatedEmployee.getSalary());
				ps.setInt(5, id);
				ps.executeUpdate();
				ps.close();
				
				System.out.println("Record updated successfully.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedEmployee;
	}
	
	public static void deleteEmployee(int id) throws SQLException {
		String query2 = "DELETE FROM employee WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query2);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			System.out.println("Record deleted successfully from database.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Connection getDBConnection() 
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
