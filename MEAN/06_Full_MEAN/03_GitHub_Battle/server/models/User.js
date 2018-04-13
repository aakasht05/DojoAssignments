let mongoose = require("mongoose");

let User = mongoose.model("User",new mongoose.Schema({
    name:{type:String,required:true,minlength:1,maxlength:255},
    img:{type:String,requried:true},
    score:{type:Number,requried:true}
},{timestamps:true}));
