from __future__ import unicode_literals
from django.shortcuts import render,redirect

def index(request):
    return render(request,'app_main/index.html')

def process(request):
    if not 'submits' in request.session:
        request.session['submits'] = 1
    else:
        request.session['submits'] += 1

    if request.method is "POST":
        for i in request.POST:
            if i is not "csrfmiddlewaretoken":
                request.session[i] = request.POST[i]

    return redirect('/result')

def result(request):
    return render(request,'app_main/result.html')