var express = require("express");
var bodyParser = require("body-parser");
var mongoose = require("mongoose");
app = express();

app.use(express.static(__dirname + "/static"));
app.set("views", __dirname + "/views");
app.set("view engine", "ejs");

app.use(bodyParser.urlencoded({extended: true}));

mongoose.connect("mongodb://localhost/message_board");

var Schema = mongoose.Schema;
var PostSchema = new mongoose.Schema({
    name: {type: String, required: true},
    text: {type: String, required: true},
    comments: [{type: Schema.Types.ObjectId, ref: "Comment"}]}, 
    {timestamps: true}
);

var CommentSchema = new mongoose.Schema({
    _post: {type: Schema.Types.ObjectId, ref: 'Post'},
    name: {type: String, required: true},
    text: {type: String, required: true}}, 
    {timestamps: true}
);

mongoose.model("Post", PostSchema);
mongoose.model("Comment", CommentSchema);

var Post = mongoose.model("Post");
var Comment = mongoose.model("Comment");

app.get("/", function (request, response) {
    Post.find({}).populate("comments").exec(function(err,posts){
        response.render("index", {posts:posts});
    });
});

app.post("/add", function(request, response){
    var post = new Post(request.body);
    post.save(function(err){
        if(err){
            console.log("There was a problem saving to DB");
            redirect("/");
        }
        else{
            response.redirect("/");
        }
    });
});

app.post("/post/:id", function (request, response) {
    Post.findOne({
        _id: request.params.id
    }, function (err, post) {
        var comment = new Comment(request.body);
        comment._post = post._id;

        comment.save(function (err) {
            post.comments.push(comment);
            post.save(function (err) {
                if (err) {
                    console.log("Error");
                } else {
                    response.redirect("/");
                }
            });
        });
    });
});

app.listen(8000, function () {
    console.log("Listening on port 8000");
});