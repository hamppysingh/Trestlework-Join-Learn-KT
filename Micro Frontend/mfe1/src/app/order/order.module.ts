import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrderRoutingModule } from './order-routing.module';
import { OrderComponent } from './order.component';
import { VideoCarouselModule } from '../video-carousel/video-carousel.module';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    OrderComponent
  ],
  imports: [
    CommonModule,
    OrderRoutingModule,VideoCarouselModule,HttpClientModule
  ]
})
export class OrderModule { }
