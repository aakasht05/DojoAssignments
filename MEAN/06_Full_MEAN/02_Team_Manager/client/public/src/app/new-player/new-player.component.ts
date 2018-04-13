import { Component, OnInit } from '@angular/core';
import {PlayerService} from "../player.service";
import {Player} from "../player";

@Component({
    selector: 'app-new-player',
    templateUrl: './new-player.component.html',
    styleUrls: ['./new-player.component.css']
})

export class NewPlayerComponent implements OnInit{
    private playerService:PlayerService;
    private player:Player;

    constructor(playerService:PlayerService){
        this.playerService = playerService;
        this.player = new Player();
    }

    ngOnInit(){
        
    }

    onSubmit(){
        this.playerService.create(this.player);
        this.player = new Player();
    }
}
