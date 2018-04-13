import {Injectable} from '@angular/core';
import {Http,Response} from "@angular/http";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {User} from "./user";
import "rxjs/add/operator/map";
import "rxjs/add/operator/toPromise";

@Injectable()
export class UserService{
    private http:Http;
    private git:string = "https://api.github.com/users/";
    private key = "890e93c68c5735f2a5515248f071b0c4bd681e4d"; // :/
    private playerOne$:BehaviorSubject<User>;
    private playerTwo$:BehaviorSubject<User>;
    private playerOne:User;
    private playerTwo:User;

    constructor(http:Http){
        this.http = http;
        this.playerOne$ = new BehaviorSubject<User>(new User());
        this.playerTwo$ = new BehaviorSubject<User>(new User());
        this.playerOne  = new User();
        this.playerTwo  = new User();
    }

    get(username:string){
        return this.http.get("https://api.github.com/users/"+username)
        .map(data=>data.json())
        .toPromise()
    }

    getPlayerOne(username:string){
        this.http.get("https://api.github.com/users/"+username)
        .map(data=>data.json())
        .subscribe((data)=>{
            this.playerOne.name  = data.login;
            this.playerOne.img   = data.avatar_url;
            this.playerOne.score = data.followers+data.public_repos*12;
            this.playerOne$.next(this.playerOne);
        })
    }
    getPlayerTwo(username:string){
        this.http.get("https://api.github.com/users/"+username)
        .map(data=>data.json())
        .subscribe((data)=>{
            this.playerTwo.name  = data.login;
            this.playerTwo.img   = data.avatar_url;
            this.playerTwo.score = data.followers+data.public_repos*12;
            this.playerTwo$.next(this.playerTwo);
        })
    }
    subPlayerOne(){
        return this.playerOne$.asObservable();
    }
    subPlayerTwo(){
        return this.playerTwo$.asObservable();
    }
}
