import {NgModule} from "@angular/core";
import {Routes,RouterModule} from  "@angular/router";
import {AppComponent} from "./app.component";
import {ListingsComponent} from "./listings/listings.component";
import {BrowseComponent} from "./browse/browse.component";
import {LoginComponent} from "./login/login.component";
import {DashComponent} from "./dash/dash.component";

const routes:Routes = [
    {path:"",pathMatch:"full",component:LoginComponent},
    {path:"browse",component:BrowseComponent},
    {path:"dashboard",component:DashComponent},
    {path:"listings",component:ListingsComponent},
    {path:"browse",component:BrowseComponent},
    {path:"logout",redirectTo:""}
];

@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports:[RouterModule]
})
export class AppRoutingModule{}
