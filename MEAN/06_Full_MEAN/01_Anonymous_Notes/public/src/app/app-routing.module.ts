import { NgModule } from "@angular/core";
import { Routes,RouterModule } from "@angular/router";

import {MainComponent} from "./main/main.component";
import {NoteComponent} from "./note/note.component";

const routes:Routes = [
    {path:"",pathMatch:"full",component:MainComponent}
];

@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports:[RouterModule]
})
export class AppRoutingModule{}
