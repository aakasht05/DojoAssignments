import {Component,OnInit} from '@angular/core';
import {ListingService} from "../listing.service";
import {Listing} from "../listing";
import {Observable} from "rxjs/Observable";

@Component({
    selector: 'app-browse',
    templateUrl: './browse.component.html',
    styleUrls: ['../app.component.css']
})

export class BrowseComponent implements OnInit{
    private listingService:ListingService;
    private listings$:Observable<Listing[]>;
    private query:{query:""}

    constructor(listingService:ListingService){
        this.listingService=listingService;
        this.query = {query:""};
    }

    ngOnInit(){
        this.listings$=this.listingService.onSubscribe();
        this.listingService.all();
    }

    onQuery(){
        this.listingService.query(this.query.query);
    }
}
