import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {User} from "../user";
import {UserService} from "../user.service";

@Component({
    selector: 'app-results',
    templateUrl: './results.component.html',
    styleUrls: ['./results.component.css']
})

export class ResultsComponent implements OnInit{
    private playerOne$:Observable<User>;
    private playerTwo$:Observable<User>;
    private userService:UserService;

    constructor(userService:UserService){
        this.playerOne$  = new Observable<User>();
        this.playerTwo$  = new Observable<User>();
        this.userService = userService;
    }

    ngOnInit(){
        this.playerOne$ = this.userService.subPlayerOne();
        this.playerTwo$ = this.userService.subPlayerTwo();
    }
}
