let mongoose = require("mongoose");

let Player = mongoose.model("Player",new mongoose.Schema({
    name:{type:String,required:true,minlength:3,maxlength:255},
    position:{type:String,required:false,minlength:1,maxlength:255},
    status:{type:Number,required:false,enum:[0,1,2],default:0}
},{timestamps:true}));
