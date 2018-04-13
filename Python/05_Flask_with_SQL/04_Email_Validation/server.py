from flask import Flask,render_template,session,flash,redirect,request
from mysqlconnection import MySQLConnector
import re

app = Flask(__name__)
app.secret_key = "hideMe"

db  = MySQLConnector(app,'email_validation')
email_re = re.compile(r'^[a-sA-Z0-9.+_-]+@[a-zA-Z0-9._]+$')

@app.route('/')
def index():
    return render_template('index.html',style="static/style.css")

@app.route('/success')
def success():
    q = "SELECT * FROM emails"
    session['emails'] = db.query(q)
    flash("The email address you entered {} is a VALID email address! Thank you!".format(session['email']))

    return render_template('success.html',style="static/style.css")

@app.route('/process',methods=['POST'])
def process():
    email = request.form['email']
    valid = True

    if not email_re.match(email):
        valid = False
        flash("Email is not valid!")

    if valid:
        session['email'] = email
        q = "INSERT INTO emails(name,created_at,updated_at) VALUES('{}',NOW(),NOW())".format(email)
        db.query(q)
        return redirect('/success')
    else:
        return redirect('/')

app.run(debug=True)