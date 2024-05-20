package com.trestle.tech.employeemanager.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.trestle.tech.employeemanager.Pojo.Employee;
import com.trestle.tech.employeemanager.repository.EmployeeRepository;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeRepositorytests {

   @Mock
   private EmployeeRepository employeeRepository;

   @Test
   public void testFindEmployeeById() {
       // Mock data
       long employeeId = 1L;
       Employee employee = new Employee();
       employee.setId(employeeId);
       employee.setName("John");
       employee.setEmail("john.doe@example.com");

       // Mock behavior of EmployeeRepository
       when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

       // Test the repository method
       Optional<Employee> foundEmployeeOptional = employeeRepository.findById(employeeId);

       // Verify that the repository method returns the expected result
       assertEquals(employee, foundEmployeeOptional.orElse(null));
   }

   // Similarly, write tests for other custom methods or queries if present in the EmployeeRepository interface
}