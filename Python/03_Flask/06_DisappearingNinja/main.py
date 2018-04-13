from flask import Flask,render_template,request,redirect

app = Flask(__name__)

@app.route('/')
def index():
    return render_template("index.html",style="style.css",js="main.js")

@app.route("/ninja")
def ninja():
    return render_template('ninja.html',pic="/static/tmnt.png")

di = {
    "red":"raphael.jpg",
    "blue":"leonardo.jpg",
    "purple":"donatello.jpg",
    "orange":"michelangelo.jpg"
}

@app.route("/ninja/<col>")
def findNinja(col):
    img  = ""

    for i in di:
        if col == i:
            img  = "/static/"+di[i]
            return render_template(col+'.html',pic=img)

    col  = "april"
    img  = "/static/notapril.jpg"
    return render_template(col+'.html',pic=img)
app.run(debug=True)