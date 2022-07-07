package com.wtw.test.springbootwebapplication.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wtw.test.springbootwebapplication.dao.EmployeeDAO;
import com.wtw.test.springbootwebapplication.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	public Employee updateEmployeeDetails(int id, Employee updatedEmployee) throws SQLException {
		
		return employeeDAO.updateEmployee(id, updatedEmployee);
		
	}

	public void deleteEmployeeEntry(int id) throws SQLException {
		
		employeeDAO.deleteEmployee(id);
		
	}
	
}
