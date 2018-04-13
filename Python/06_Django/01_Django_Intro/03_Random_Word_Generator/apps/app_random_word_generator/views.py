from __future__ import unicode_literals
from django.shortcuts import render,redirect
import random
charStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

def randWord():
    word = ""
    for i in range(0,random.randint(8,16)):
        word += charStr[random.randint(0,len(charStr)-1)]
    return word

def index(request):
    if not 'attempt' in request.session:
        request.session['attempt'] = 1
    if not 'word' in request.session:
        request.session['word'] = randWord()

    return render(request,'app_random_word_generator/index.html')

def process(request):
    if request.method == 'POST':
        request.session['attempt'] += 1
        request.session['word'] = randWord()

        return redirect('/')