package com.trestle.tech.employeemanager.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trestle.tech.employeemanager.Pojo.Employee;
import com.trestle.tech.employeemanager.service.EmployeeService;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeService empservice;
	
	public EmployeeController(EmployeeService empservice) {
		this.empservice = empservice;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees=empservice.findAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	@GetMapping("/all/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws Throwable{
		Employee emp=empservice.findEmployeeById(id);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Employee> addemployee(@RequestBody Employee emp){
		Employee newemp=empservice.addEmployee(emp);
		return new ResponseEntity<>(newemp,HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<Employee> updateemployee(@RequestBody Employee emp){
		Employee newemp=empservice.updateEmployee(emp);
		return new ResponseEntity<>(newemp,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
		empservice.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/update/{id}")
	public ResponseEntity<Employee> updatedatasend(@PathVariable("id") Long id) throws Throwable{
		Employee emp=empservice.findEmployeeById(id);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
}