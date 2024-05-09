import { Routes } from '@angular/router';
import { GetAllEmployeeComponent } from './post/get-all-employee/get-all-employee.component';
import { AddEmployeeComponent } from './post/add-employee/add-employee.component';
import { UpdateEmployeeComponent } from './post/update-employee/update-employee.component';
import { Component } from '@angular/core';
import { ShowEmployeeComponent } from './post/show-employee/show-employee.component';

export const routes: Routes = [
  {path:'post/all',redirectTo:'post/all',pathMatch:'full'},
  {path:'post/all',component:GetAllEmployeeComponent},
  {path:'post/add',component:AddEmployeeComponent},
  {path:'post/update/:id',component:UpdateEmployeeComponent},
  {path:'post/all/:id',component:ShowEmployeeComponent}
];
