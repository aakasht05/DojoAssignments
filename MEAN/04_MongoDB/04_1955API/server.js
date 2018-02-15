var express = require("express");
var bodyParser = require("body-parser");
var mongoose = require("mongoose");
var app = express();
app.use(bodyParser.json());

mongoose.connect("mongodb://localhost/1955_api");

var Schema = mongoose.Schema;
var PersonSchema = new mongoose.Schema({
    name: {type: String, required: true}}
);

mongoose.model("Person", PersonSchema);
var Person = mongoose.model("Person");

app.get("/", function(request, response){
    Person.find({}, function(err,person){
        if(err){
            console.log("Returned error", err);
            response.json({message: "Error", error: err});
        }
        else{
            response.json(person);
        }
    });
});

app.get("/new/:name/", function(request, response){
    var person = new Person({name: (request.params.name)});
    person.save(function(err, person){
        if(err){
            console.log("There is a problem saving to the DB");
            response.redirect("/");
        }
        else{
            console.log("New person saved to DB");
            response.redirect("/");
        }
    })
});

app.get("/remove/:name", function(request, response){
    Person.findOneAndRemove(request.params.name, function(err){
        response.redirect("/");
    });
});

app.get("/:name", function(request, response){
    Person.findOne(request.params.name, function(err, person){
        response.json({message: "Your Human request", person: person});
    });
});

app.listen(8000, function(request, response){
    console.log("Listening on port 8000");
});