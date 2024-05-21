package com.trestle.redis.Cashing.Controller;

import com.trestle.redis.Cashing.Model.Student;
import com.trestle.redis.Cashing.Service.StudentService;
import com.trestle.redis.Cashing.repo.StudentRepo;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    StudentService studentService;

    @GetMapping("/getallstudent")
    public List<Student> getAllStudent() {
        List<Student> actualList = new ArrayList<>();
        studentRepo.findAll().iterator().forEachRemaining(actualList::add);
        return actualList;
    }

    @PostMapping("/saveStudent")
    public Student saveStudentData(@RequestBody Student student) {

        studentRepo.save(student);
        return student;
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentRepo.deleteById(id);
    }

    @GetMapping("/getStudentById/{id}")
    public Student getStudent(@PathVariable("id") Integer id) {
        return studentService.getStudentById(id);
    }

    @PostConstruct
    public void saveStudent() {
        Student student = new Student();
        student.setId(1);
        student.setName("Nilesh");
        studentRepo.save(student);
    }
}
