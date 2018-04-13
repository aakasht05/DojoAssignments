import { Component, OnInit,Input } from '@angular/core';
import {User} from "../user";
import {UserService} from "../user.service";
import {Router} from "@angular/router";
import {Observable} from "rxjs/Observable";

@Component({
    selector: 'app-battle',
    templateUrl: './battle.component.html',
    styleUrls: ['./battle.component.css']
})

export class BattleComponent implements OnInit{
    private router:Router;
    private userService:UserService;
    private playerOne$:Observable<User>;
    private playerTwo$:Observable<User>;

    constructor(router:Router,userService:UserService){
        this.router      = router;
        this.userService = userService;
        this.playerOne$  = new Observable<User>();
        this.playerTwo$  = new Observable<User>();
    }

    onSubmitPlayerOne(user:User){
        console.log(this.playerOne$);
        this.userService.getPlayerOne(user.name);
        console.log(this.playerOne$);
    }
    onSubmitPlayerTwo(user:User){
        this.userService.getPlayerTwo(user.name);
    }

    onBattle(){
        this.router.navigate(["/results"]);
    }

    ngOnInit(){
        this.playerOne$ = this.userService.subPlayerOne();
        this.playerTwo$ = this.userService.subPlayerTwo();
    }
}
