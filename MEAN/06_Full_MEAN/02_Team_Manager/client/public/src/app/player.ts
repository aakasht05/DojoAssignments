import {Status} from "./status.enum";

export class Player{
    public _id:any         = 0; // Gets set when returned from db.
    public name:string     = "";
    public position:string = "";
    public status:Status   = Status.Undecided;

    constructor(){
        
    }
}
