from __future__ import unicode_literals
from django.shortcuts import render,redirect
from django.contrib import messages #flash
from .models import User
import re
email_re = re.compile(r'(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$)')
name_re  = re.compile(r'^[a-zA-Z]+$')

def index(request):
    return render(request,'app_main/index.html')

def register(request):
    if request.method == "POST":
        errs = []
        first_name = request.POST['first_name']
        last_name  = request.POST['last_name']
        email      = request.POST['email']
        password   = request.POST['password']
        confirm    = request.POST['confirm']

        if len(first_name) < 2 or len(last_name) < 2:
            errs.append('Name must be at least 2 characters long.')
        elif not name_re.match(first_name) or not name_re.match(last_name):
            errs.append('Name must contain characters only.')

        if len(email) < 1:
            errs.append('Email cannot be blank.')
        elif not email_re.match(email):
            errs.append('Invalid email format!')
        if len(User.objects.filter(email=email)) >= 1:
            errs.append('A user with this email already exists.')

        if len(password) < 8:
            errs.append('Passwords must be at least 8 characters long.')
        if password != confirm:
            errs.append('Passwords must match.')

        if len(errs) < 1:
            user = User.objects.create(
                first_name = first_name,
                last_name  = last_name,
                email      = email,
                password   = password
            )
            request.session['id'] = user.id
            request.session['first_name'] = first_name
            request.session['action'] = "Registered"
            return redirect('/success')
        else:
            for err in errs:
                messages.add_message(request,messages.ERROR,err)

        return redirect('/')

def login(request):
    errs = []
    email    = request.POST['email']
    password = request.POST['password']
    user     = User.objects.filter(email=email)

    if len(email) < 1:
        errs.append('Email cannot be blank.')
    elif not email_re.match(email):
        errs.append('Invalid email format!')
    elif len(user) < 1:
        errs.append('No user found with email: {}'.format(email))

    if len(password) < 1:
        errs.append('Password cannot be blank.')
    elif len(user) >= 1:
        if user[0].password != password:
            errs.append('Incorrect password.')

    if len(errs) < 1:
        request.session['first_name'] = user[0].first_name
        request.session['action'] = "Logged in"
        return redirect('/success')
    else:
        for err in errs:
            messages.add_message(request,messages.ERROR,err)

    return redirect('/')

def success(request):
    return render(request,'app_main/success.html')