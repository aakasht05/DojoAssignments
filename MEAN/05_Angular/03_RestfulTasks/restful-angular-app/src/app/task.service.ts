import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class TaskService {

  constructor(private _http: HttpClient) {
    this.getTasks();
  }

  getTasks() {
    const tempObservable = this._http.get('/tasks');
    tempObservable.subscribe(data => console.log('Got our tasks!', data));
  }

}
