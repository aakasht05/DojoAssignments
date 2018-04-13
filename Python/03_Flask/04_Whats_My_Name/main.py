from flask import Flask,redirect,request,render_template

app = Flask(__name__)

@app.route("/")
def index():
    return render_template("index.html")

@app.route("/process",methods=["POST"])
def process():
    print request.form["name"]
    

    return redirect("/")
app.run()