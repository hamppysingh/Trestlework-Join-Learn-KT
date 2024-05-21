package com.trestle.redis.Cashing.Service;

import com.trestle.redis.Cashing.Model.Student;
import com.trestle.redis.Cashing.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Cacheable(value = "studentCache")
    public Student getStudentById(Integer id) {
        System.out.println("Calling repo for student");
        return studentRepo.findById(id).orElse(null
        );
    }

}
