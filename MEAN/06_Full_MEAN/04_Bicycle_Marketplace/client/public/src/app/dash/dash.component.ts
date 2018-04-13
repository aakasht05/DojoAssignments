import {Component,OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {LoginService} from "../login.service";
import {User} from "../user";
import {Observable} from "rxjs/Observable";

@Component({
    selector: 'app-dash',
    templateUrl: './dash.component.html',
    styleUrls: ['../app.component.css']
})

export class DashComponent implements OnInit{
    private loginService:LoginService;
    private router:Router;
    private user$:Observable<User>;

    constructor(loginService:LoginService,router:Router){
        this.loginService=loginService;
        this.router=router;
        this.user$ = new Observable<User>();
    }

    ngOnInit(){
        this.user$ = this.loginService.doSubscribe();
    }
}
