from __future__ import unicode_literals
from django.shortcuts import render,redirect
from django.contrib import messages
from .models import User
import re
email_re = re.compile(r'(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$)') 

def index(request):
    return render(request,'app_main/index.html')

def process(request):
    errs = []
    uname = request.POST['email']

    if len(uname) < 1:
        errs.append('Email cannot be blank.')
    if not len(uname) >= 8 or not len(uname) < 26:
        errs.append('Email must be between 8-25 characters.')
    if not email_re.match(uname):
        errs.append('Invalid email format.')

    if len(errs) < 1:
        request.session['email'] = uname
        User.objects.create(email=uname)
        return redirect('/success')
    else:
        for err in errs:
            messages.add_message(request,messages.ERROR,err)

        return redirect('/')

def success(request):
    ctx = {'users':User.objects.all()}

    return render(request,'app_main/success.html',ctx)