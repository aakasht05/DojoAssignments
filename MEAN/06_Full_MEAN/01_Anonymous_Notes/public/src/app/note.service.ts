import { Injectable } from '@angular/core';
import { Http } from "@angular/http";
import { Note } from "./note";
import "rxjs";

@Injectable()
export class NoteService{
    private http:Http;

    constructor(http:Http){
        this.http=http;
    }

    create(note:Note){
        return this.http.post("/notes/new",note)
        .map(data=>data.json())
        .toPromise();
    }

    all(){
        return this.http.get("/notes")
        .map( data => data.json() )
        .toPromise()
    }

    // get(id){
    //     return this.http.get("/notes/${id}")
    //     .map(data=>data.json())
    //     .toPromise()
    // }

    // update(note:Note,id){
    //     return this.http.put("/notes/${id}",note)
    //     .map(data=>data.json())
    //     .toPromise()
    // }

    // delete(id){
    //     return this.http.put("/notes/${id}",id)
    //     .map(data=>data.json())
    //     .toPromise()
    // }
}
