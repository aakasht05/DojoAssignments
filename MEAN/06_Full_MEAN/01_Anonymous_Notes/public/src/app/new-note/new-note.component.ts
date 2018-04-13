import { Component, OnInit,Output,EventEmitter } from '@angular/core';
import { Note } from "../note";
import { NoteService } from "../note.service";

@Component({
    selector: 'app-new-note',
    templateUrl: './new-note.component.html',
    styleUrls: ['./new-note.component.css']
})

export class NewNoteComponent implements OnInit {
    private noteService:NoteService;
    private note:Note;
    @Output() private noteEmitter = new EventEmitter();

    constructor(noteService:NoteService){
        this.noteService=noteService;
    }

    ngOnInit(){
        this.note = new Note();
    }

    onSubmit(){
        this.noteEmitter.emit(this.note);
        this.note = new Note();
    }
}
