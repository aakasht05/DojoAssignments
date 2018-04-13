

export class Listing{
    public img:string;
    public title:string;
    public description:string;
    public price:number;
    public location:string;
    public _id;
    public _user;

    constructor(){
        this.img         = "";
        this.title       = "";
        this.description = "";
        this.price       = 0;
        this.location    = "";
    }
}
