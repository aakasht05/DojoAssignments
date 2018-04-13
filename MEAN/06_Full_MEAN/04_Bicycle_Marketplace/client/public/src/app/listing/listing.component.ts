import {Component,OnInit,Input} from '@angular/core';
import {Listing} from "../listing";
import {ListingService} from "../listing.service";
import {User} from "../user";
import {LoginService} from "../login.service";
import {Observable} from "rxjs/Observable";

@Component({
    selector: 'app-listing',
    templateUrl: './listing.component.html',
    styleUrls: ['../app.component.css']
})

export class ListingComponent implements OnInit{
    private loginService:LoginService;
    private user$;
    private listingService:ListingService;
    @Input() private listing:Listing;
    @Input() private isListing:boolean;

    constructor(listingService:ListingService,loginService:LoginService){
        this.listingService=listingService;
        this.loginService=loginService;
        this.listing=new Listing();
    }

    ngOnInit(){
        this.user$ = this.loginService.doSubscribe();
    }

    onCreate(){
        if(this.user$.source._value._id){// Else not logged in
            this.listing._user = this.user$.source._value._id;

            if(this.isListing){
                this.listingService.update(this.listing._id,this.listing)
                .then((data)=>{
                    this.loginService.updateListing(data.listing);
                })
                .catch(err=>console.log(err))
            }else{
                this.listingService.create(this.listing)
                .then((data)=>{
                    this.loginService.addListing(data.listing); // keeps me from having to update anywhere else.
                    this.listing = new Listing();
                })
                .catch(err=>console.log(err))
            }
        }
    }

    onDelete(){
        this.listingService.delete(this.listing._id)
        .then((data)=>{
            this.loginService.deleteListing(data.listing);
        })
        .catch(err=>console.log(err))
    }
}
