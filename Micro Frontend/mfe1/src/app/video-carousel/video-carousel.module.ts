import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VideoCarouselComponent } from './video-carousel.component';
import { FormsModule } from '@angular/forms';
import { NgImageSliderModule } from 'ng-image-slider';



@NgModule({
  declarations: [VideoCarouselComponent],
  imports: [
    CommonModule, FormsModule, NgImageSliderModule,
  ],
  exports: [VideoCarouselComponent]
})
export class VideoCarouselModule { }
