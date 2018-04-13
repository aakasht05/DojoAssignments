import { Component, OnInit,Input } from '@angular/core';
import { NoteService } from "../note.service";
import { Note } from "../note";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
    private title:string = "Anonymous Notes";
    private noteService:NoteService;
    private notes:Array<Note> = [];
    @Input() private note:Note;

    constructor(noteService:NoteService){
        this.noteService=noteService;
    }

    public all(){
        this.noteService.all()
        .then(notes=>this.notes=notes)
        .catch(err=>console.log(err))
    }

    public create(note:Note){
        this.noteService.create(note)
        .then((newNote)=>{this.notes.push(newNote); console.log(newNote)})// Create + return note, so we can push to notes without requerying all? Hope it works, thatd be amazing.
        .catch(err=>console.log(err))
    }

    ngOnInit(){
        this.all();
    }

    onNoteCreated(note:Note){
        this.create(note);
    }
}
