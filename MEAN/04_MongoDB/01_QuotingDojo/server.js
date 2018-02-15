var express = require("express");
var bodyParser = require("body-parser");
var app = express();
var mongoose = require("mongoose");

app.use(express.static(__dirname + "/static"));
app.set("views", __dirname + "/views");
app.set("view engine", "ejs");

app.use(bodyParser.urlencoded({extended: true}));

mongoose.connect("mongodb://localhost/quoting_dojo");

var Quote = new mongoose.Schema({
    name: {type: String,required: true,minlength: 4},
    quote: {type: String,required: true,minlength: 10}}, 
    {timestamps: true}
);

mongoose.model("Quote", Quote);
var Quote = mongoose.model("Quote");

app.get("/", function (request, response) {
    response.render("index");
});

app.get("/quotes", function (request, response) {
    Quote.find({}, function (err, quotes) {
        response.render("quotes", {quote: quotes})
    });
});

app.post("/addQuote", function (request, response) {

    var quote = new Quote({
        name: request.body.name,
        quote: request.body.quote
    });
    quote.save(function (err) {
        if (err) {
            console.log("There is an error!");
        } else {
            console.log("There are no errors!!");
            response.redirect("/quotes");
        }
    });
});

app.listen(9001, function () {
    console.log("IT'S OVER 9000! (Listening on port 9001)");
});