package com.trestle.tech.employeemanager.repository;

import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trestle.tech.employeemanager.Pojo.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteById(Long id);

    Optional<Employee> findById(Long id);
    Page<Employee> findByNameContaining(String name,PageRequest pf);
}