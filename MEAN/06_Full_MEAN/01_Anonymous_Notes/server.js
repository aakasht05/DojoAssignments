let express = require("express");
let bParse = require("body-parser");
let mongoose = require("mongoose");
let path = require("path");
let app = express();
let port = 8080;
app.use(express.static(path.join(__dirname, '/public/dist')));
app.use(bParse.json());
app.use(bParse.urlencoded({extended: true}));
app.listen(port, () => console.log(`Listening on port ${port}...`));

require("./server/config/mongoose.js");
require("./server/config/routes.js")(app);