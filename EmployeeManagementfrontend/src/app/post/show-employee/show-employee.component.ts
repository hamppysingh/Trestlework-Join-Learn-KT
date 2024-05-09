import { Component, OnInit } from '@angular/core';
import { Employee } from '../Employee';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-show-employee',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './show-employee.component.html',
  styleUrl: './show-employee.component.css'
})
export class ShowEmployeeComponent implements OnInit {
  emp: Employee = {} as Employee;
  error: any;

  constructor(
    private employeeservice: EmployeeService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void { // Use ngOnInit for data fetching
    const id = this.route.snapshot.paramMap.get('id');

    if (id) { // Check if ID exists
      const idAsNumber = parseInt(id, 10); // Convert string ID to number

      this.employeeservice.getEmployeeById(idAsNumber)
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
  }
}
