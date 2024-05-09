package com.trestle.tech.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trestle.tech.employeemanager.Pojo.Employee;
import com.trestle.tech.employeemanager.exception.UserNotFoundException;
import com.trestle.tech.employeemanager.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class EmployeeService {
	private final EmployeeRepository emprepo;
	
	@Autowired
	public EmployeeService(EmployeeRepository emprepo)
	{
		this.emprepo=emprepo;
	}
	public Employee addEmployee(Employee emp)
	{
		emp.setEmpcode(UUID.randomUUID().toString());
		return emprepo.save(emp);
	}
	public List<Employee> findAllEmployees(){
		return emprepo.findAll();
	}
	public Employee updateEmployee(Employee emp)
	{
		return emprepo.save(emp);
	}
	@SuppressWarnings("unchecked")
	public Employee findEmployeeById(Long id) throws Throwable
	{
		return (Employee)emprepo.findById(id).orElseThrow(()-> new UserNotFoundException("User by id "+id+" was not found!"));
	}
	public void deleteEmployee(Long id)
	{
		emprepo.deleteById(id);
	}
}
