let mongoose = require("mongoose");
let PlayerController = require("../controllers/PlayerController.js");

module.exports = function(app){
    app.post("/api/players/new",PlayerController.create);
    app.get("/api/players",PlayerController.all);
    app.post("/api/players/edit/:id",PlayerController.update);
    app.post("/api/players/delete/:id",PlayerController.delete);

    app.all("*",(req,res,next)=>{
        res.sendFile(path.resolve("./client/public/dist/index.html"))
    });
}
