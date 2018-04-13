var express = require("express");
var bodyParser = require("body-parser");
var app = express();

app.use(express.static(__dirname + "/static"));
app.set("views", __dirname + "/views");
app.set("view engine", "ejs");

app.use(bodyParser.urlencoded({
    extended: true
}));

app.get("/", function(request, response){
    response.render("index");
});

app.post("/results", function(request, response){
    var results = {
        name: request.body.name,
        location: request.body.location,
        language: request.body.language,
        comment: request.body.comment,
    }
    response.render("results", {result: results});
});

app.get("/goback", function(request, response){
    response.redirect("/");
});

app.listen(8000, function(){
    console.log("Server is running on port: 8000");
});