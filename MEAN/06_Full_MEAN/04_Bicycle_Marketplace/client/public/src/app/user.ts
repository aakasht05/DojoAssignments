export class User{
    public firstName:string;
    public lastName:string;
    public email:string;
    public password:string;
    public confirm:string;
    public listings;

    constructor(){
        this.firstName = "";
        this.lastName  = "";
        this.email     = "";
        this.password  = "";
        this.confirm   = "";
        this.listings  = [];
    }
}
