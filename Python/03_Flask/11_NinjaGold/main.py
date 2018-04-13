from flask import Flask,render_template,request,redirect,session
import random
import datetime

app = Flask(__name__)
app.secret_key = "hi"

@app.route('/')
def index():
    session['gold'] = 0
    session['text'] = ""
    return render_template('index.html',style="static/style.css",js="static/main.js")

@app.route('/process',methods=['POST'])
def process():
    rnd = 0
    loc = ""
    res = "Earned "
    li  = request.form

    for i in li:
        i = int(i)
        if i == 0:
            rnd = random.randint(10,20)
            loc = "Farm "
        elif i == 1:
            rnd = random.randint(5,10)
            loc = "Cave "
        elif i == 2:
            rnd = random.randint(2,5)
            loc = "House "
        elif i == 3:
            rnd = random.randint(0,50)
            if random.randint(0,1) == 1:
                rnd = -rnd
                res = "Lost "
            loc = "Casino "

    t = str(datetime.datetime.utcnow())
    session['gold'] += rnd
    session['text'] += res+str(rnd)+" gold from the "+loc+t+"\n"

    return render_template("index.html",style="static/style.css",js="static/main.js")
app.run(debug=True)