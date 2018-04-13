import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import {User} from "./user";
import {Listing} from "./listing";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Router} from "@angular/router";

import "rxjs/add/operator/map";
import "rxjs/add/operator/toPromise";

@Injectable()
export class LoginService{
    private http:Http;
    private user$:BehaviorSubject<User>;
    private user:User;
    private router:Router;

    constructor(http:Http,router:Router){
        this.http   = http;
        this.router = router;
        this.user$  = new BehaviorSubject<User>(new User());
        this.user   = new User();
    }

    login(user:User){
        this.http.post("/api/users/login",user)
        .map(data=>data.json())
        .subscribe((data)=>{
            if(data.errors){
                this.user = data.errors;
                this.user$.next(this.user);
            }else{
                this.user = data.user; // Lets return all but password from server plz.
                this.user$.next(this.user);
                this.router.navigate(["/dashboard"]); // subscribe to login via dashboard too.
            }
        })
    }

    register(user:User){
        return this.http.post("/api/users/new",user)
        .map(data=>data.json())
        .toPromise()
    }

    addListing(listing:Listing){ // Gets called after listing Component onCreate(), returning a listing from ListingService.create
        this.user.listings.push(listing);
        this.user$.next(this.user);
    }

    updateListing(listing:Listing){
        this.user.listings.forEach((val,key)=>{
            if(val._id == listing._id){
                this.user.listings[key] = listing;
            }
            this.user$.next(this.user);
        })
    }

    deleteListing(listing:Listing){
        this.user.listings.forEach((val,key)=>{
            if(val._id == listing._id){
                this.user.listings.splice(key,1);
            }
            this.user$.next(this.user);
        })
    }

    doSubscribe(){
        return this.user$.asObservable();
    }
}
