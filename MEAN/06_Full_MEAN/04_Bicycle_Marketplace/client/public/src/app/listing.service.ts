import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import {Listing} from "./listing"
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Injectable()
export class ListingService{
    private http:Http;
    private listings;  // All Listings
    private listings$; // Behavior Subject

    constructor(http:Http){
        this.http      = http;
        this.listings  = [];
        this.listings$ = new BehaviorSubject<Listing[]>([]);
    }

    public create(listing:Listing){
        return this.http.post("/api/listings/new",listing)
        .map(data=>data.json())
        .toPromise()
    }

    public update(id,listing:Listing){
        return this.http.post("/api/listings/edit/"+id,listing)
        .map(data=>data.json())
        .toPromise()
    }

    public delete(id){
        return this.http.post("/api/listings/delete/"+id,id)
        .map((data)=>data.json())
        .toPromise()
    }

    public deleteObs(id){
        this.http.post("/api/listings/delete/"+id,id)
        .map((data)=>data.json())
        .subscribe((data)=>{
            for(let i=0;i<this.listings.length;i++){
                if(this.listings[i]._id == data._id){
                    this.listings.splice(i,1);
                }
            }

            this.listings$.next(this.listings);
        })
    }

    public all(){
        this.http.get("/api/listings")
        .map(data=><Listing[]>data.json())
        .subscribe((data)=>{
            this.listings = data;
            this.listings$.next(this.listings);
        })
    }

    public onSubscribe(){
        return this.listings$.asObservable();
    }

    public query(q:string){
        this.http.get("/api/listings/"+q)
        .map(data=><Listing[]>data.json())
        .subscribe((data)=>{
            this.listings = data;
            this.listings$.next(this.listings);
        })
    }

    public lotd(){
        return this.http.get("/api/listings")
        .map(data=>data.json())
        .toPromise()
    }
}
