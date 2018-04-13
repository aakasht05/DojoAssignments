import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {AppRoutingModule} from "./app-routing.module";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";

import { AppComponent } from './app.component';
import { BrowseComponent } from './browse/browse.component';
import { LoginComponent } from './login/login.component';

import {LoginService} from "./login.service";
import {ListingService} from "./listing.service";

import { DashComponent } from './dash/dash.component';
import { NavComponent } from './nav/nav.component';
import { ListingComponent } from './listing/listing.component';
import { ListingsComponent } from './listings/listings.component';
import { ShowListingComponent } from './show-listing/show-listing.component';

@NgModule({
    declarations: [
        AppComponent,
        BrowseComponent,
        LoginComponent,
        DashComponent,
        NavComponent,
        ListingComponent,
        ListingsComponent,
        ShowListingComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpModule,
        FormsModule
    ],
    providers: [LoginService,ListingService],
    bootstrap: [AppComponent]
})
export class AppModule{}
