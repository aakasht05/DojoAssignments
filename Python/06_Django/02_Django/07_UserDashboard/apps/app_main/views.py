from __future__ import unicode_literals
from django.shortcuts import render,redirect
from .models import User,Post,Comment
from django.contrib import messages

def index(request):
    return render(request,'app_main/index.html')

def sign_in(request):
    return render(request,'app_main/sign_in.html')

def sign_out(request):
    request.session.clear()
    return redirect('/signin')

def sign_in_process(request):
    errs = User.manager.login(
        request.POST['email'],
        request.POST['password']
    )

    if type(errs) == list:#errors
        for err in errs:
            messages.add_message(request,messages.ERROR,err)
        return redirect('/signin')
    else:#user_id
        request.session['user_id'] = errs
        return redirect('/dashboard')

def register(request):
    return render(request,'app_main/register.html')

def register_process(request):
    errs = User.manager.register(
        request.POST['first_name'],
        request.POST['last_name'],
        request.POST['email'],
        request.POST['password'],
        request.POST['confirm'],
    )

    if type(errs) == list:#errors
        for err in errs:
            messages.add_message(request,messages.ERROR,err)
        return redirect('/register')
    else:#user_id
        if 'users_new' in request.session:#an admin created this user, redirect them to their own dashboard, not the new users.
            request.session['users_new'] = False
            messages.add_message(request,messages.SUCCESS,'Successfully created user: {}'.format(errs))
            return redirect('/dashboard')
        else:
            request.session['user_id'] = errs
            return redirect('/dashboard')
def users_new(request):
    if not User.manager.isLoggedIn(request):
        messages.add_message(request,messages.ERROR,'You must be logged in to access this page.')
        return redirect('/')
    else:
        if not User.manager.isAdmin(request):
            messages.add_message(request,messages.ERROR,'You must be an Administrator to access this page.')
            return redirect('/')
        else:
            request.session['users_new'] = True#Lets not make a new route for creating users via admin panel. Just use registration route and check for this.
            return render(request,'app_main/users_new.html')

def users_delete(request,user_id):
    if User.manager.isLoggedIn(request):
        if User.manager.isAdmin(request):
            User.manager.get(id=user_id).delete()
            return redirect('/dashboard')
        else:
            return redirect('/')
    else:
        return redirect('/')
def users_show(request,user_id):
    if not User.manager.isLoggedIn(request):
        messages.add_message(request,messages.ERROR,'You must be logged in to access this page.')
        return redirect('/')

    return render(request,'app_main/users_show.html',{
        'user':User.manager.get(id=user_id),
        'posts':Post.manager.filter(profile_id=user_id),
        'comments':Comment.manager.filter(post__profile_id=user_id)#grab posts from associated post, then grab profile id from post.
    })

def users_edit(request):
    if not User.manager.isLoggedIn(request):
        messages.add_message(request,messages.ERROR,'You must be logged in to access this page.')
        return redirect('/')

    return render(request,'app_main/users_edit.html',{
        'user':User.manager.get(id=request.session['user_id'])
    })

def updateProfile(request):
    if not User.manager.isLoggedIn(request):
        messages.add_message(request,messages.ERROR,'You must be logged in to access this page.')
        return redirect('/')

    errs = User.manager.updateProfile(
        request.POST['first_name'],
        request.POST['last_name'],
        request.POST['email'],
        request.POST['description'],
        request.session['user_id']
    )

    if errs:
        for err in errs:
            messages.add_message(request,messages.ERROR,err)

    return redirect('/users/edit')

def updatePassword(request):
    if not User.manager.isLoggedIn(request):
        messages.add_message(request,messages.ERROR,'You must be logged in to access this page.')
        return redirect('/')

    errs = User.manager.updatePassword(
        request.POST['password'],
        request.POST['confirm'],
        request.session['user_id']
    )

    if errs:
        for err in errs:
            messages.add_message(request,messages.ERROR,err)

    return redirect('/users/edit')

def users_edit_user(request,user_id):
    if not User.manager.isLoggedIn(request):
        messages.add_message(request,messages.ERROR,'You must be logged in to access this page.')
        return redirect('/')
    else:
        if not User.manager.isAdmin(request):
            messages.add_message(request,messages.ERROR,'You must be an Administrator in to access this page.')
            return redirect('/')
        else:
            return render(request,'app_main/users_edit_user.html',{
                "user":User.manager.get(id=user_id)
            })
#Admin Only
def editProfile(request,user_id):
    errs = User.manager.editProfile(
        request.POST['first_name'],
        request.POST['last_name'],
        request.POST['email'],
        request.POST['level'],
        user_id
    )

    if errs:
        for err in errs:
            messages.add_message(request,messages.ERROR,err)

    return redirect('/users/edit/'+user_id)


def dashboard(request):
    if not User.manager.isLoggedIn(request):
        messages.add_message(request,messages.ERROR,'You must be logged in to access this page.')
        return redirect('/')
    else:
        if User.manager.isAdmin(request):#seemed better than having a separate route.
            return render(request,'app_main/dashboard_admin.html',{
                'users':User.manager.all()
            })
        else:
            return render(request,'app_main/dashboard.html',{
                'users':User.manager.all()
            })

def post(request,user_id):#user_id is profile to post to. Never really need it.
    errs = Post.manager.add(
        request.POST['text'],
        request.session['user_id'],#user who posted,
        user_id#profile to post to.
    )

    if type(errs) == list:
        for err in errs:
            messages.add_message(request,messages.ERROR,err)

    return redirect('/users/show/'+user_id)

def comment(request,user_id,post_id):
    errs = Comment.manager.add(#user_id = original poster. Dont need it.
        request.POST['text'],
        request.session['user_id'],#user who posted,
        post_id#profile to post to.
    )

    if type(errs) == list:
        for err in errs:
            messages.add_message(request,messages.ERROR,err)

    return redirect('/users/show/'+user_id)