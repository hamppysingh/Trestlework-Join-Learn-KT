import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { Employee } from '../Employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-get-all-employee',
  standalone: true,
  imports: [CommonModule,RouterModule],
  templateUrl: './get-all-employee.component.html',
  styleUrl: './get-all-employee.component.css'
})
export class GetAllEmployeeComponent {
    emp:Employee[]=[];
  error: any;
    constructor(public employeeservice:EmployeeService,private router: Router){    }
    update(id: number) {
      this.router.navigate(['/post/update', id]);
    }
    view(id: number) {
      this.router.navigate(['/post/all', id]);
    }
    del(id: number) {
      this.employeeservice.deleteEmployee(id)
        .subscribe({
          next: () => {
            console.log('Employee deleted successfully!');
            const employeeObservable = this.employeeservice.getAllEmployees(); // Fetch updated data
            employeeObservable.subscribe(data => this.emp = data);
          },
          error: (error) => {
            this.error = error.message;
            console.error('Error deleting employee:', error);
          }
        });
    }
    ngOnInit():void{
      const employeeObservable = this.employeeservice.getAllEmployees();

      employeeObservable.subscribe({
        next: (data: Employee[]) => {
          this.emp = data;
          console.log(data);
        },
        error: (error: { message: any; }) => {
          this.error = error.message;
          console.error(error);
        },
      });
    }
}
