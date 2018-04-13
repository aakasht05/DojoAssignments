import { Component,OnInit} from '@angular/core';
import {Player} from "../player";
import {PlayerService} from "../player.service";
import {Observable} from "rxjs/Observable";

@Component({
    selector: 'app-player-list',
    templateUrl: './player-list.component.html',
    styleUrls: ['./player-list.component.css']
})

export class PlayerListComponent implements OnInit{
    private playerService:PlayerService;
    //private players:Player[];
    private players$:Observable<Player[]>;

    constructor(playerService:PlayerService){
        this.playerService=playerService;
    }

    // all(){ // Subscribe without Behavior Subject
    //     this.subscription = this.playerService
    //     .all()
    //     .subscribe(
    //         players=>this.players=players,
    //         err=>console.log(err)
    //     )
    // }

    ngOnInit(){
        this.playerService.all();
        this.players$ = this.playerService.doSubscribe();
    }

    onDelete(id){
        this.playerService.delete(id);
    }
}
