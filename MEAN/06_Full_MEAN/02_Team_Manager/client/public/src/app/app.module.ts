import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from "@angular/http";
import { FormsModule } from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";

import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { NewPlayerComponent } from './new-player/new-player.component';
import { PlayerStatusComponent } from './player-status/player-status.component';
import { PlayerListComponent } from './player-list/player-list.component';

import {PlayerService} from "./player.service";

@NgModule({
    declarations: [
        AppComponent,
        MainComponent,
        NewPlayerComponent,
        PlayerStatusComponent,
        PlayerListComponent,
    ],

    imports: [
        BrowserModule,
        HttpModule,
        FormsModule,
        AppRoutingModule
    ],
    
    providers: [PlayerService],
    bootstrap: [AppComponent]
})
export class AppModule{}
