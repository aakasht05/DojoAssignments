import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from "@angular/http";
import { FormsModule } from "@angular/forms";
import { AppRoutingModule } from "./app-routing.module";

import { AppComponent } from './app.component';
import { NoteComponent } from './note/note.component';
import { MainComponent } from './main/main.component';
import { NewNoteComponent } from './new-note/new-note.component';

import { NoteService } from "./note.service";

@NgModule({
  declarations: [
    AppComponent,
    NoteComponent,
    MainComponent,
    NewNoteComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [NoteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
