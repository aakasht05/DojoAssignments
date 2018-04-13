import { Component, OnInit,Output,EventEmitter } from '@angular/core';
import {User} from "../user";

@Component({
    selector: 'app-user',
    templateUrl: './user.component.html',
    styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {
    private user:User;
    @Output() private onUserEmit = new EventEmitter<User>();

    constructor(){
        this.user = new User();
    }

    public onSubmit(){
        this.onUserEmit.emit(this.user);
    }

    ngOnInit(){
    }
}
