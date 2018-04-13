import {NgModule} from "@angular/core";
import {Routes,RouterModule} from "@angular/router";

import {MainComponent} from "./main/main.component";
import {PlayerListComponent} from "./player-list/player-list.component";
import {NewPlayerComponent} from "./new-player/new-player.component";
import {PlayerStatusComponent} from "./player-status/player-status.component";

const routes:Routes = [
    {path:"",pathMatch:"full",redirectTo:"/players/list"},
    {path:"players/list",component:PlayerListComponent},
    {path:"players/new",component:NewPlayerComponent},
    {path:"players/status",component:PlayerStatusComponent}
];

@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports:[RouterModule]
})
export class AppRoutingModule{}
