import { Component, OnInit,Input } from '@angular/core';
import {User} from "../user";
import {Observable} from "rxjs/Observable";
import {UserService} from '../user.service';

@Component({
    selector: 'app-player',
    templateUrl: './player.component.html',
    styleUrls: ['./player.component.css']
})

export class PlayerComponent implements OnInit{
    private userService:UserService;
    private playerOne$:Observable<User>;
    private playerTwo$:Observable<User>;
    @Input() private player:number;

    constructor(userService:UserService){
        this.userService = userService;
        this.playerOne$  = new Observable<User>();
        this.playerTwo$  = new Observable<User>();
        this.player      = 0;
    }

    ngOnInit(){
        this.playerOne$ = this.userService.subPlayerOne();
        this.playerTwo$ = this.userService.subPlayerTwo();
    }
}
