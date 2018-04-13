import {Component,OnInit} from '@angular/core';
import {LoginService} from "../login.service";
import {User} from "../user";
import {Observable} from "rxjs/Observable";

@Component({
    selector: 'app-listings',
    templateUrl: './listings.component.html',
    styleUrls: ['../app.component.css']
})

export class ListingsComponent implements OnInit{
    private loginService:LoginService;
    private user$:Observable<User>;

    constructor(loginService:LoginService){
        this.loginService=loginService;
    }

    ngOnInit(){
        this.user$ = this.loginService.doSubscribe();
    }
}
