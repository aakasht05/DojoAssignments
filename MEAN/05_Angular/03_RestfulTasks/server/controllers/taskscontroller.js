const mongoose = require("mongoose");
const Task = mongoose.model("Task");

class TasksController{
    index(request, response){
        Task.find({}, (error, tasks) => {
            if(error){
                return response.json(error);
            }
            return response.json(tasks);
        });
    }
    create(request, response){
        Task.create(request.body, (error, tasks) => {
            if(error){
                return response.json(error);
            }
            return response.json(tasks);
        });
    }
    show(request, response){
        Task.findById(request.params.id, (error,task) => {
            if(error){
                return response.json({error: "404 - Task not found"});
            }
            return response.json(task);
        });
    }
    update(request, response){
        Task.findByIdAndUpdate(request.params.id, {$set: request.body}, {new: true}, (error, task) =>{
            if(error){
                return response.json(error);
            }
            return response.json(task);
        });
    }
    destroy(request, response){
        Task.findByIdAndRemove(request.params.id,(error,task) => {
            if(error){
                return response.json(error);
            }
            return response.json({"success": "successfully deleted task"});
            // return response.json(task);
        });
    }
}

//get all tasks method: index, route: /tasks, type: get
//create a task method: create, routes: /tasks, type: post
//get a single task from the db method: show, route: /tasks/id, type: get
//update task by id method: update, route: /tasks/:id , type: put/patch
//delete task by id, method: destroy, route: /tasks/:id, type: delete


module.exports = new TasksController();