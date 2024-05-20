import { Component, OnInit } from '@angular/core';

interface Video {
  id: number;
  title: string;
  source: string; // Path to the video file
}

@Component({
  selector: 'app-video-carousel',
  templateUrl: './video-carousel.component.html',
  styleUrls: ['./video-carousel.component.css']
})
export class VideoCarouselComponent{

  constructor() { }

  imageObject = [{
    video: 'https://www.youtube.com/embed/mKaoPky64k0?si=UgKe4oTHBN6HMLyV',
    title: 'Youtube example one with title.',
    alt: 'youtube video'
}, {
    video: 'https://www.youtube.com/embed/zuNyi9YAtzg?si=bQxDBz5_Nux25yDn',
    alt: 'youtube video'
}, {
    video: 'https://www.youtube.com/embed/dyCyvkU4hAg?si=Darl24kiFpv6Xw1i',
    title: 'Youtube example one with title.'
},{
  video: 'https://www.youtube.com/embed/_Hv3pS8Wdd0?si=nXX5YcYKtq0tvd_f',
  title: 'Youtube example one with title.',
  alt: 'youtube video'
}, {
  video: 'https://www.youtube.com/embed/xqhdRrFzLFY?si=u6ScEfdNWx6S0lVR',
  alt: 'youtube video'
}, {
  video: 'https://www.youtube.com/embed/2aOmtbNqMZk?si=XFUKwNp5y3wVp5-g',
  title: 'Youtube example one with title.'
},{
  video: 'https://www.youtube.com/embed/hzpt3fQjY9U?si=G6uljsjkJ3HdxQJD',
  title: 'Youtube example one with title.',
  alt: 'youtube video'
}, {
  video: 'https://www.youtube.com/embed/o5JQIjab8Bo?si=I2nFw2ke229KL4Ts',
  alt: 'youtube video'
}, {
  video: 'https://www.youtube.com/embed/Hdr64lKQ3e4?si=fp1S1AZ5RY5TY1Xu',
  title: 'Youtube example one with title.'
}
];
}
