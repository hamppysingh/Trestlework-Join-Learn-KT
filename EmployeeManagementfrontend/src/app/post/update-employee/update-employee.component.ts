import { Component, OnInit } from '@angular/core';
import { Employee } from '../Employee';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-update-employee',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './update-employee.component.html',
  styleUrl: './update-employee.component.css'
})
export class UpdateEmployeeComponent implements OnInit {
  emp: Employee = {} as Employee;
  error: any;

  constructor(
    private employeeservice: EmployeeService,
    private route: ActivatedRoute,private router:Router
  ) {}

  ngOnInit(): void { // Use ngOnInit for data fetching
    const id = this.route.snapshot.paramMap.get('id');

    if (id) { // Check if ID exists
      const idAsNumber = parseInt(id, 10); // Convert string ID to number

      this.employeeservice.updateEmployeeData(idAsNumber)
        .subscribe({
          next: (data: Employee) => {
            this.emp = data;
          },
          error: (error: { message: any }) => {
            this.error = error.message;
            console.error(error);
          }
        });
    } else {
      console.error('Employee ID not found in route parameters');
      // Handle the case where there's no ID
    }
  }onSubmit() {
    this.employeeservice.addEmployee(this.emp)
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
