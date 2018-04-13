var express = require('express');
var session = require('express-session');
var bodyParser = require("body-parser");
var app = express();

app.use(express.static(__dirname + "/static"));
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

app.use(session({
    secret: 'codingdojorocks',
    resave: true,
    saveUninitialized: true,
    count: 1
}));

app.use(bodyParser.urlencoded({
    extended: true
}));

app.get('/', function (request, response) {

    if (request.session.count == null) {
        request.session.count = 1;
    } else {
        request.session.count += 1;
    }

    console.log(request.session.id);
    response.render("index", {
        count: request.session.count
    });
});

app.post('/two', function (request, response) {
    request.session.count += 2;
    console.log(request.session.id);
    response.redirect("/");
});

app.post('/reset', function (request, response) {
    request.session.count = 0;
    console.log(request.session.id);
    response.redirect("/");
});

app.listen(8000, function () {
    console.log("Server is now running on port: 8000");
});