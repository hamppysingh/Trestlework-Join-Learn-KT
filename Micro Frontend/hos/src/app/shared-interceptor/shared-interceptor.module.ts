import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DummyInterceptor } from './dummy.interceptor';
import { HTTP_INTERCEPTORS } from '@angular/common/http';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS,useClass:DummyInterceptor,multi:true}]

})
export class SharedInterceptorModule { }
