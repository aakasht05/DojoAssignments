let mongoose = require("mongoose");
let Schema   = mongoose.Schema;
let ObjectId = Schema.Types.ObjectId;

let User = mongoose.model("User",new Schema({
    firstName:{type:String},
    lastName:{type:String},
    email:{type:String},
    password:{type:String},
    confirm:{type:String},
    listings:[{type:ObjectId,ref:"Listing"}]
},{timestamps:true}));
