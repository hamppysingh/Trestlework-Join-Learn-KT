package com.trestle.tech.employeemanager.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.trestle.tech.employeemanager.Pojo.Employee;
import com.trestle.tech.employeemanager.exception.UserNotFoundException;

public interface EmployeeService {
	public Employee addEmployee(Employee emp);
 	public List<Employee> findAllEmployees();
	public Employee updateEmployee(Employee emp);
	public Employee findEmployeeById(Long id);
	public void deleteEmployee(Long id);
	public Page<Employee> getEmployees(String name,int page,int size);
}
