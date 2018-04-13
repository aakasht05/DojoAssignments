import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {PlayerService} from "../player.service";
import {Player} from "../player";

@Component({
    selector: 'app-player-status',
    templateUrl: './player-status.component.html',
    styleUrls: ['./player-status.component.css']
})

export class PlayerStatusComponent implements OnInit {
    private playerService:PlayerService;
    private players$:Observable<Player[]>;
    private player:Player;

    constructor(playerService:PlayerService){
        this.playerService=playerService;
    }

    ngOnInit(){
        this.players$ = this.playerService.doSubscribe();
        this.player = new Player();
    }

    onClick(player,status){
        player.status = status;
        this.playerService.update(player._id,player);
    }
}
