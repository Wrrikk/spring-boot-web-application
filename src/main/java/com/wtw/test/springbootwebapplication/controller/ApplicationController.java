package com.wtw.test.springbootwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wtw.test.springbootwebapplication.model.Employee;
import com.wtw.test.springbootwebapplication.service.EmployeeService;

@RestController
public class ApplicationController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateDetails(@PathVariable(value = "id") Integer id, @RequestBody Employee updatedEmployee) throws Exception {
		try {
			Employee employee = employeeService.updateEmployeeDetails(id, updatedEmployee);
			
			return ResponseEntity.ok(employee);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Employee> deleteEmployeeByID(@PathVariable(value = "id") Integer id) throws Exception {
		try {
			employeeService.deleteEmployeeEntry(id);
			
			return ResponseEntity.noContent().build();
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}