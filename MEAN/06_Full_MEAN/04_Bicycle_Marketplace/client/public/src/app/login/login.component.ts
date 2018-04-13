import {Component,OnInit} from '@angular/core';
import {User} from "../user";
import {LoginService} from "../login.service";
import {Observable} from "rxjs/Observable";
import {ListingService} from "../listing.service";
import {Listing} from "../listing";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['../app.component.css']
})

export class LoginComponent implements OnInit{
    private loginService:LoginService;
    private listingService:ListingService;
    private userLogin:User;
    private userRegister:User;
    private user$:Observable<User>;
    private regErrs = [];

    constructor(loginService:LoginService,listingService:ListingService){
        this.loginService = loginService;
        this.listingService = listingService;
        this.userLogin    = new User();
        this.userRegister = new User();
        this.user$        = new Observable<User>();
    }

    ngOnInit(){
        this.user$     = this.loginService.doSubscribe();
    }

    onLogin(){
       this.loginService.login(this.userLogin)
    }

    onRegister(){
        this.loginService.register(this.userRegister)
        .then((data)=>{
            this.regErrs = data.errors;
        })
        .catch(err=>console.log(err))
        this.userRegister = new User();
    }
}
