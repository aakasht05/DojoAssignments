from __future__ import unicode_literals
from django.db import models
import util

class UserManager(models.Manager):
    def isLoggedIn(self,request):
        if not 'user_id' in request.session:
            return False
        else:
            return True

    def isAdmin(self,request):
        user = User.manager.get(id=request.session['user_id'])
        return user.level > 0

    def updateProfile(self,first_name,last_name,email,description,id):
        errs = []
        util.doEmail(email,errs)
        util.doNames(first_name,last_name,errs)

        if len(errs) < 1:
            user = User.manager.get(id=id)
            user.first_name  = first_name
            user.last_name   = last_name
            user.email       = email
            user.description = description
            user.save()

            return False
        else:
            return errs

    def updatePassword(self,password,confirm,id):
        errs = []
        util.doPassword(password,confirm,errs)

        if len(errs) < 1:
            password = util.hashPass(password)
            user = User.manager.get(id=id)
            user.password = password
            user.save()

            return False
        else:
            return errs
    #Admin Only
    def editProfile(self,first_name,last_name,email,level,id):
        errs = []
        util.doEmail(email,errs)
        util.doNames(first_name,last_name,errs)

        if level == "User":
            level = 0
        elif level == "Admin":
            level = 9

        if len(errs) < 1:
            user = User.manager.get(id=id)
            user.first_name  = first_name
            user.last_name   = last_name
            user.email       = email
            user.level       = level
            user.save()

            return False
        else:
            return errs

    def login(self,email,password):
        errs = []
        util.doEmail(email,errs)
        util.doPass(password,errs)

        if len(errs) < 1:
            user = User.manager.filter(email=email)
            if len(user) < 1:
                errs.append("No user with this email was found.")
                return errs
            else:
                if util.matchPass(password,user[0].password):
                    return user[0].id
                else:
                    errs.append("Invalid Password.")
                    return errs
        else:
            return errs

    def register(self,first_name,last_name,email,password,confirm):
        errs = []
        util.doNames(first_name,last_name,errs)
        util.doEmail(email,errs)
        util.doPassword(password,confirm,errs)

        if len(errs) < 1:
            password = util.hashPass(password)
            level = User.manager.all()
            if len(level) < 1:
                level = 9
            else:
                level = 0

            user = User.manager.create(
                first_name  = first_name,
                last_name   = last_name,
                email       = email,
                password    = password,
                description = "",
                level       = level
            )

            return user.id
        else:
            return errs

class PostManager(models.Manager):
    def add(self,text,user_id,profile_id):
        errs = []
        if util.isBlank(text):
            errs.append('Post cannot be blank.')

        if len(errs) < 1:
            return Post.manager.create(
                text       = text,
                user_id    = user_id,
                profile_id = profile_id
            )
        else:
            return errs

class CommentManager(models.Manager):
    def add(self,text,user_id,post_id):
        errs = []
        if util.isBlank(text):
            errs.append('Comment cannot be blank.')

        if len(errs) < 1:
            return Comment.manager.create(
                text    = text,
                user_id = user_id,#user who posted
                post_id = post_id #post it belongs to
            )
        else:
            return errs

class User(models.Model):
    first_name  = models.CharField(max_length=255)
    last_name   = models.CharField(max_length=255)
    email       = models.CharField(max_length=255)
    password    = models.CharField(max_length=255)
    description = models.TextField(max_length=1000)
    level       = models.IntegerField()
    manager     = UserManager()
    created_at  = models.DateTimeField(auto_now_add=True)
    updated_at  = models.DateTimeField(auto_now=True)

class Post(models.Model):
    text        = models.TextField(max_length=1000)
    user        = models.ForeignKey(User)#person who posted
    profile     = models.ForeignKey(User,related_name="profile")#profile it was posted to
    manager     = PostManager()
    created_at  = models.DateTimeField(auto_now_add=True)
    updated_at  = models.DateTimeField(auto_now=True)

class Comment(models.Model):
    text         = models.TextField(max_length=1000)
    user         = models.ForeignKey(User)#who posted it
    post         = models.ForeignKey(Post)#post it belongs to
    manager      = CommentManager()
    created_at   = models.DateTimeField(auto_now_add=True)
    updated_at   = models.DateTimeField(auto_now=True)
