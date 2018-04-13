let mongoose = require("mongoose");
let UserController = require("../controllers/UserController.js");

module.exports = function(app){
    app.post("/api/users/new",UserController.create);
    

    app.all("*",(req,res,next)=>{
        res.sendFile(path.resolve("./client/public/dist/index.html"))
    });
}
