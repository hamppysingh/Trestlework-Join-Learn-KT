package com.trestle.tech.employeemanager.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.trestle.tech.employeemanager.Pojo.Employee;

class Hello {
	 @Test
	    public void testEmployeeCreation() {
	        // Create an employee object
	        Employee employee = new Employee();
	        employee.setId(1L);
	        employee.setName("John Doe");
	        employee.setEmail("john.doe@example.com");
	        employee.setJobTitle("Software Engineer");
	        employee.setPhone("+1234567890");
	        employee.setImageUrl("https://example.com/image.jpg");
	        employee.setEmpcode("EMP001");

	        // Assert values
	        assertEquals(1L, employee.getId());
	        assertEquals("John Doe", employee.getName());
	        assertEquals("john.doe@example.com", employee.getEmail());
	        assertEquals("Software Engineer", employee.getJobTitle());
	        assertEquals("+1234567890", employee.getPhone());
	        assertEquals("https://example.com/image.jpg", employee.getImageUrl());
	        assertEquals("EMP001", employee.getEmpcode());
	    }
	  @Test
	    public void testEmployeeToString() {
	        // Create an employee object
	        Employee employee = new Employee();
	        employee.setId(2L);
	        employee.setName("Jane Smith");
	        employee.setEmail("jane.smith@example.com");
	        employee.setJobTitle("Project Manager");
	        employee.setPhone("+9876543210");
	        employee.setImageUrl("https://example.com/profile.jpg");
	        employee.setEmpcode("EMP002");

	        // Assert toString output
	        String expectedString = "Employee [id=2, name=Jane Smith, email=jane.smith@example.com, jobTitle=Project Manager, phone=+9876543210, imageUrl=https://example.com/profile.jpg, empcode=EMP002]";
	        assertEquals(expectedString, employee.toString());
	  }
}