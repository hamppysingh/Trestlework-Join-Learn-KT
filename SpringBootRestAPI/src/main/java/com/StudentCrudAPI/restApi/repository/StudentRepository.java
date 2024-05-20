package com.StudentCrudAPI.restApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentCrudAPI.restApi.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
