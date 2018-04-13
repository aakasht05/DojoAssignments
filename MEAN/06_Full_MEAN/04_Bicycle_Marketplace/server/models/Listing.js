let mongoose = require("mongoose");
let Schema   = mongoose.Schema;
let ObjectId = Schema.Types.ObjectId;

let Listing = mongoose.model("Listing",new Schema({
    title:{type:String,required:true},
    description:{type:String,required:true},
    price:{type:Number,required:true},
    location:{type:String,required:true},
    img:{type:String,required:false},
    _user:{type:ObjectId,ref:"User"}
},{timestamps:true}));
