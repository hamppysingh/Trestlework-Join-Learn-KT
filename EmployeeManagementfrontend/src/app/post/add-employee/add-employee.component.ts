import { Component, OnInit } from '@angular/core';
import { Employee } from '../Employee'; // Import your Employee interface
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-add-employee',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {
  newEmployee: Employee = {} as Employee; // Initialize empty Employee object
  error: string | null = null;

  constructor(
    private employeeService: EmployeeService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    this.employeeService.addEmployee(this.newEmployee)
      .subscribe({
        next: (data) => {
          // Handle successful addition
          console.log('Employee added successfully!');
          this.router.navigate(['/post/all']); // Navigate to all employees list
        },
        error: (error) => {
          this.error = error.message; // Handle errors
          console.error('Error adding employee:', error);
        }
      });
  }
}
