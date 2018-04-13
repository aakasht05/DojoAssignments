from __future__ import unicode_literals
from django.shortcuts import render,redirect
import random
from datetime import datetime

def rand(a,b):
    return random.randint(a,b)

def doOutcome(num):
    newStr = "Earned "

    if num is 1:
        num = rand(10,20)
        newStr += str(num)+" gold from the Farm!"
    elif num is 2:
        num = rand(5,10)
        newStr += str(num)+" gold from the Cave!"
    elif num is 3:
        num = rand(2,5)
        newStr += str(num)+" gold from the House!"
    elif num is 4:
        num = rand(0,50)
        if rand(0,1) is 1:
            newStr = "Lost "
            num = -num
        newStr += str(num)+" gold from the Casino!"

    newStr += " "+str(datetime.now())
    return [num,newStr]

def index(request):
    if not 'gold' in request.session:
        request.session['gold'] = 0
    if not 'results' in request.session:
        request.session['results'] = ""

    return render(request,'app_main/index.html')

def process(request,form_id):
    form_id = int(form_id)
    if request.method == "POST":
        res = doOutcome(form_id)
        request.session['gold'] += res[0]
        request.session['results'] += res[1]+"\n"

    return redirect('/')