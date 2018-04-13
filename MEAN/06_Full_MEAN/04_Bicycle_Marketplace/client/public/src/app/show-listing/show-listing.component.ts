import {Component,OnInit,OnDestroy,Input} from '@angular/core';
import {ListingService} from "../listing.service";
import {LoginService} from "../login.service";
import {Observable} from "rxjs/Observable";
import {User} from "../user";

@Component({
    selector: 'app-show-listing',
    templateUrl: './show-listing.component.html',
    styleUrls: ['../app.component.css']
})

export class ShowListingComponent implements OnInit,OnDestroy{
    @Input() private listing;
    private listingService:ListingService;
    private loginService:LoginService;
    private user$;

    constructor(listingService:ListingService,loginService:LoginService){
        this.listingService=listingService;
        this.loginService=loginService;
    }

    ngOnInit(){
        this.user$ = this.loginService.doSubscribe();
    }

    ngOnDestroy(){
    }

    isUserListing(){ // quickest way i could think of at the time.
        return this.listing._user._id == this.user$.source._value._id;
    }

    onDelete(){
        this.listingService.delete(this.listing._id)
        .then((data)=>{
            this.loginService.deleteListing(data.listing);
        })
        .catch(err=>console.log(err))
    }

    onContact(){
        console.log(this.listing._user);
    }
}
