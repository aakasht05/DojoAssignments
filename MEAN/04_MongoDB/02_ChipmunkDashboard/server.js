var express = require("express");
var bodyParser = require("body-parser");
var mongoose = require("mongoose");
app = express();

app.use(express.static(__dirname + "/static"));
app.set("views", __dirname + "/views");
app.set("view engine", "ejs");

app.use(bodyParser.urlencoded({extended: true}));

mongoose.connect("mongodb://localhost/mongoose_dashboard");

var Chipmunk = new mongoose.Schema({
    name: {type: String, required: true, minlength: 4},
    age: {type: Number, required: true},
    color: {type: String, required: true,minlength: 3}}
);

mongoose.model("Chipmunk", Chipmunk);
var Chipmunk = mongoose.model("Chipmunk");

app.get("/", function(request, response) {
    Chipmunk.find({}, function(err,chipmunk){
        response.render("dashboard", {chipmunk:chipmunk})
    });
});

app.get("/chipmunk/new", function(request, response){
    response.render("new");
});

app.get("/chipmunk", function(request, response){
    Chipmunk.find({}, function(err,chipmunk){
        response.render("dashboard", {chipmunk:chipmunk})
    });
});

app.get("/chipmunk/:id", function(request,response){
    Chipmunk.findById(request.params.id, function(err,chipmunk){
        response.render("show",{chipmunk:chipmunk})
    });
});

app.get("/chipmunk/destroy/:id", function(request,response){
    Chipmunk.findByIdAndRemove(request.params.id, function(err){
        response.redirect("/chipmunk");
    });
});

app.get("/chipmunk/edit/:id", function(request,response){
    Chipmunk.findById(request.params.id, function(err,chipmunk){
        response.render("edit",{chipmunk:chipmunk});
    });
});

app.post("/chipmunk/new", function(request, response) {
    console.log("POST DATA", request.body);
    var chipmunk = new Chipmunk(request.body);
    chipmunk.save(function(err){
        if(err){
            console.log("There is a problem!");
            response.render("dashboard", {errors: chipmunk.errors})
        }else{
            console.log("New Chipmunk saved to DB");
            response.redirect("/chipmunk")
        }
    });
});


app.post("/chipmunk/:id", function(request,response){
    Chipmunk.findByIdAndUpdate({_id: request.params.id},request.body,{upsert:false}, function(err, chipmunk){
        if(err){
            handleError(err);
        }else{
            response.redirect("/chipmunk/"+request.params.id);
        }
    });
});

app.listen(9000, function () {
    console.log("Listening on port 9000")
});