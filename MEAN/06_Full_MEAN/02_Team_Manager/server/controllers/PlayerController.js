let Player = require("mongoose").model("Player");

module.exports = {
    create:function(req,res){
        let player = new Player({
            name:req.body.name,
            position:req.body.position,
            status:req.body.status
        });

        player.save(function(err){
            if(err){
                console.log(err);
            }else{
                res.json(player);
            }
        })
    },

    all:function(req,res){
        Player.find({},function(err,players){
            if(err){
                console.log(err);
            }else{
                res.json(players);
            }
        })
    },

    get:function(req,res){
        Player.find({_id:req.params.id},function(err,player){
            if(err){
                console.log(err);
            }else{
                res.json(player);
            }
        })
    },

    update:function(req,res){
        Player.find({_id:req.params.id},function(err,player){
            if(err){
                console.log(err);
            }else{
                player = player[0];
                player.status = req.body.status;

                player.save(function(err){
                    if(err){
                        console.log(err);
                    }else{
                        res.json(player);
                    }
                })
            }
        })
    },

    delete:function(req,res){
        Player.find({_id:req.params.id},function(err,player){
            player = player[0];
    
            Player.remove({_id:req.params.id},function(err){
                if(err){console.log(err);}
                res.json(player);
            });
        })
    }
}
