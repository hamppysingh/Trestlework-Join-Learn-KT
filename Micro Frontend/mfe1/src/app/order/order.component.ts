import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent {
  constructor(private http: HttpClient){

  }
  onClick() {
    this.http.get("https://jsonplaceholder.typicode.com/comments/1").subscribe(response =>console.log(response));
}

  ngOnInit(): void {
  }
}
