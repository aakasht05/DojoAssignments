import {NgModule} from "@angular/core";
import {Routes,RouterModule} from "@angular/router";

import {BattleComponent} from "./battle/battle.component";
import {RankingsComponent} from "./rankings/rankings.component";
import {ResultsComponent} from "./results/results.component";

const routes:Routes = [
    {path:"",pathMatch:"full",component:BattleComponent},
    {path:"rankings",component:RankingsComponent},
    {path:"results",component:ResultsComponent}
];

@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports:[RouterModule]
})
export class AppRoutingModule{}
