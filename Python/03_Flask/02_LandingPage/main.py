from flask import Flask,redirect,request,render_template

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')
@app.route('/success')
def success():
    return render_template('success.html')
@app.route('/ninjas')
def ninjas():
    return render_template('ninjas.html')
@app.route('/dojos/new')
def newDojo():
    return render_template('dojos.html')
@app.route('/dojos',methods=['POST'])
def getDojos():
    print request.form

    return redirect('/success')
app.run(debug=True)