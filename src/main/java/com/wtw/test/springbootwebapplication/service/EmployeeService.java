package com.wtw.test.springbootwebapplication.service;

import java.sql.SQLException;
import org.springframework.stereotype.Service;

import com.wtw.test.springbootwebapplication.dao.EmployeeDAO;
import com.wtw.test.springbootwebapplication.model.Employee;

@Service
public class EmployeeService {
	
	public static Employee updateEmployeeDetails(int id, Employee updatedEmployee) throws SQLException {
		return EmployeeDAO.updateEmployee(id, updatedEmployee);
	}

	public static void deleteEmployeeEntry(int id) throws SQLException {
		
		EmployeeDAO.deleteEmployee(id);
		
	}
	
}
