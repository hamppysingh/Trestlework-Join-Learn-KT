import { loadRemoteModule } from '@angular-architects/module-federation';
import { Component, ViewChild, ViewContainerRef } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {


  @ViewChild('placeholder',{read:ViewContainerRef})
  viewContainer!: ViewContainerRef;

  constructor(private http:HttpClient){}

async load():Promise<void> {
      const m=await loadRemoteModule({
      type:'module',
      remoteEntry:'http://localhost:4003/remoteEntry.js',
      exposedModule:'./Component'
    });

    this.viewContainer.createComponent(m.AppComponent);
}
onClick() {
     this.http.get("https://jsonplaceholder.typicode.com/todos/1").subscribe(response =>console.log(response));
}

}
