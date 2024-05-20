import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private http:HttpClient){}

  onClick() {
    this.http.get("https://jsonplaceholder.typicode.com/posts/1").subscribe(response =>console.log(response));
}
  title = 'mfe2';
}
