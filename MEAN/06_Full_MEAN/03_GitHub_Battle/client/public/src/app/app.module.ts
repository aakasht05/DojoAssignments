import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from "@angular/http";
import { FormsModule } from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";

import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';

import {UserService} from "./user.service";
import { BattleComponent } from './battle/battle.component';
import { RankingsComponent } from './rankings/rankings.component';
import { ResultsComponent } from './results/results.component';
import { PlayerComponent } from './player/player.component';
import { UserComponent } from './user/user.component';

@NgModule({
    declarations: [
        AppComponent,
        MainComponent,
        BattleComponent,
        RankingsComponent,
        ResultsComponent,
        PlayerComponent,
        UserComponent,
    ],

    imports: [
        BrowserModule,
        HttpModule,
        FormsModule,
        AppRoutingModule
    ],

    providers: [UserService],
    bootstrap: [AppComponent]
})
export class AppModule{}
