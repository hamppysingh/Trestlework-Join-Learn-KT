package com.trestle.tech.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.trestle.tech.employeemanager.Pojo.Employee;
import com.trestle.tech.employeemanager.exception.UserNotFoundException;
import com.trestle.tech.employeemanager.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository emprepo;
	
	public EmployeeServiceImpl(EmployeeRepository emprepo)
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
	public Employee findEmployeeById(Long id)
	{
		return (Employee)emprepo.findById(id).orElseThrow(()-> new UserNotFoundException("User by id "+id+" was not found!"));
	}
	public void deleteEmployee(Long id)
	{
		emprepo.deleteById(id);
	}
	public Page<Employee> getEmployees(String name,int page,int size){
		return emprepo.findByNameContaining(name, PageRequest.of(page, size).withSort(Sort.by(Sort.Direction.ASC,"JobTitle")));
	}
	public List<Employee> sortBasedUponSomeField(String field){
		return emprepo.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	public Page<Employee> paginationBasedData(int offset,int size){
		return emprepo.findAll(PageRequest.of(offset,size));
	}
}