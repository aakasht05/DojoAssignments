let User = require("mongoose").model("User");

module.exports = {
    create:function(req,res){
        let user = new User({
            name:req.body.name,
            img:req.body.img,
            score:req.body.score
        });

        user.save(function(err){
            if(err){
                console.log(err);
            }else{
                res.json(user);
            }
        })
    },

    all:function(req,res){
        User.find({},function(err,users){
            if(err){
                console.log(err);
            }else{
                res.json(users);
            }
        })
    },

    get:function(req,res){
        User.find({_id:req.params.id},function(err,user){
            if(err){
                console.log(err);
            }else{
                res.json(user);
            }
        })
    }
}
