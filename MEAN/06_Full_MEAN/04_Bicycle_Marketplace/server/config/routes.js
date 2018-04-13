let mongoose          = require("mongoose");
let UserController    = require("../controllers/UserController.js");
let ListingController = require("../controllers/ListingController.js");

module.exports = function(app){
    app.post("/api/users/login",UserController.login);
    app.post("/api/users/new",UserController.register);

    app.get("/api/listings",ListingController.all);
    app.get("/api/listings/:query",ListingController.query)
    app.post("/api/listings/new",ListingController.create);
    app.post("/api/listings/edit/:id",ListingController.update);
    app.post("/api/listings/delete/:id",ListingController.delete);

    app.all("*",(req,res,next)=>{
        res.sendFile(path.resolve("./client/public/dist/index.html"))
    });
}
