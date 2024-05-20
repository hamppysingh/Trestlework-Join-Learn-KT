package com.StudentCrudAPI.restApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.StudentCrudAPI.restApi.entity.Student;
import com.StudentCrudAPI.restApi.repository.StudentRepository;

@RestController
public class StudentController {
	//localhost:8080/students
	@Autowired
	StudentRepository repo;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> stu=repo.findAll();
		return stu;
	}
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id)
	{
		return repo.findById(id).get();
	}
	@PostMapping("students/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student)
	{
		repo.save(student);
	}
	@PutMapping("students/update/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public void updateStudent(@PathVariable int id ,@RequestBody Student student)
	{	Student stu=repo.findById(id).get();
		stu.setName(student.getName());
		stu.setBranch(student.getBranch());
		repo.save(stu);
	}
	@DeleteMapping("students/delete/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void deleteStudent(@PathVariable int id)
	{
		repo.deleteById(id);
	}
}
