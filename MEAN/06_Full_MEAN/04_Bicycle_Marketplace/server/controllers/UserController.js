let User = require("mongoose").model("User");

module.exports = {
    register:function(req,res){
        let errors = [];

        User.find({email:req.body.email},function(err,user){
            if(user.length > 0){
                errors.push("A user with this email already exists.");
                res.json({
                    errors:{errors}
                });
            }else{
                let user = new User(req.body);

                user.save(function(err){
                    if(err){
                        errors.push(err)
                        res.json({
                            errors:{errors}
                        });
                    }
                })
            }
        })
    },

    login:function(req,res){
        let errors = [];

        User.find({email:req.body.email})
        .populate("listings").exec(function(err,user){
            if(user.length > 0){
                user = user[0];

                if(user.password == req.body.password){
                    user.password = "";
                    user.confirm  = "";
                    res.json({user});
                }else{
                    errors.push("Invalid Credentials.");
                    res.json({
                        errors:{errors}
                    });
                }
            }else{
                errors.push("No user with this id found.");
                res.json({
                    errors:{errors}
                });
            }
        })
    },

    all:function(req,res){
        
    },

    update:function(req,res){
        
    },

    delete:function(req,res){
        
    }
}
