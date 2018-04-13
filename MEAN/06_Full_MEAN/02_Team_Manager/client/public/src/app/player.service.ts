import { Injectable } from '@angular/core';
import {Http,Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Player} from "./player";
import "rxjs/add/operator/map";
import "rxjs";

@Injectable()
export class PlayerService{
    private http:Http;
    private players:Player[];
    private players$:BehaviorSubject<Player[]>; // Exists to update all subscribers on change.

    constructor(http:Http){
        this.http     = http;
        this.players  = [];
        this.players$ = new BehaviorSubject<Player[]>([]);
    }

    public doSubscribe():Observable<Player[]>{ // Let any component subscribe + get same data/changes.
        return this.players$.asObservable();
    }

    create(player:Player){
        this.http.post("/api/players/new",player)
        .map(res=>res.json())
        .subscribe(
            (player)=>{
                this.players.push(player);
                this.players$.next(this.players);
            }
        )
    }

    all(){
        this.http.get("/api/players")
        .map(res=><Player[]>res.json())
        .subscribe((players)=>{
            this.players=players;
            this.players$.next(players);
        })
    }
    // all():Observable<Player[]>{ // Without Behavior Subject to update all subscribers
    //     return this.http.get("/api/players")
    //     .map((res:Response)=><Player[]>res.json())
    // }

    get(id:string|number){
        return this.http.get("/api/players/${id}")
        .map(data=>data.json())
        .toPromise()
    }

    update(id,player:Player){
        this.http.post("/api/players/edit/"+id,player)
        .map(res=>res.json())
        .subscribe((player)=>{
            this.players.forEach((val,key)=>{
                if(val._id == player._id){
                    this.players[key] = player;
                }
            })

            this.players$.next(this.players);
        })
    }

    delete(id){
        this.http.post("/api/players/delete/"+id,id)
        .map(data=>data.json())
        .subscribe((player)=>{
            this.players.forEach((val,key)=>{
                if(val._id === player._id){
                    this.players.splice(key,1);
                }
            })

            this.players$.next(this.players);
        })
    }
}
