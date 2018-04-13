let Listing = require("mongoose").model("Listing");
let User    = require("mongoose").model("User");

module.exports = {
    create:function(req,res){
        User.findOne({_id:req.body._user},function(err,user){
            let listing   = new Listing(req.body);
            listing._user = user._id;
            listing.save(function(err){
                if(err){
                    console.log(err);
                }else{
                    user.listings.push(listing);
                    user.save(function(err){
                        if(err){
                            console.log(err);
                        }else{
                            res.json({listing:listing});
                        }
                    })
                }
            })
        })
    },

    get:function(req,res){
        Listing.find({_id:req.params.id},function(err,listing){
            if(err){
                console.log(err);
            }else{
                res.json({listing:listing});
            }
        })
    },

    all:function(req,res){
        Listing.find({}).populate("_user").exec(function(err,listings){
            if(err){
                console.log(err);
            }else{
                res.json({listings:listings});
            }
        })
    },

    update:function(req,res){ // Why this gets called onDelete() doesnt make sense to me. It breaks everything.
        Listing.findOne({_id:req.params.id},function(err,listing){
            if(err){
                console.log(err);
            }else{
                if(listing != null){
                    listing.title       = req.body.title;
                    listing.description = req.body.description;
                    listing.price       = req.body.price;
                    listing.location    = req.body.location;
                    listing.img         = req.body.img;
                    listing.save(function(err){
                        if(err){
                            console.log(err);
                        }else{
                            res.json({listing:listing});
                        }
                    })
                }
            }
        })
    },

    delete:function(req,res){
        Listing.findOne({_id:req.params.id},function(err,listing){
            if(err){console.log(err);}

            Listing.remove({_id:req.params.id},function(err){
                if(err){console.log(err);}
                res.json({listing:listing});
            })
        })
    },

    query:function(req,res){
        Listing.find({title:req.params.query},function(err,listings){
            if(err){console.log(err);}

            res.json({listings:listings});
        })
    }
}
