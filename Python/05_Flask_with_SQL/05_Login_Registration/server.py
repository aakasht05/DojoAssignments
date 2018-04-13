from flask import Flask,render_template,session,flash,redirect,request
from mysqlconnection import MySQLConnector

import re
from flask_bcrypt import Bcrypt

app = Flask(__name__)
app.secret_key = "hideMe"
db  = MySQLConnector(app,'login_registration')
email_re = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
bcrypt = Bcrypt(app)

@app.route('/')
def index():
    return render_template('index.html',style="static/style.css")

@app.route('/process',methods=['POST'])
def process():
    valid      = True
    first_name = request.form['first_name']
    last_name  = request.form['last_name']
    email      = request.form['email']
    password   = request.form['password']
    confirm    = request.form['confirm']

    if len(first_name) < 2 or len(last_name) < 2:
        flash('Names must be greater than 2 characters.')
        valid = False
    if not email_re.match(email) or len(email) < 1:
        flash('Invalid email format.')
        valid = False
    if len(password) < 8:
        flash('password must be at least 8 characters.')
        valid = False
    if password != confirm:
        flash("Passwords do not match.")
        valid = False

    if valid:
        password = bcrypt.generate_password_hash(password)

        q = "INSERT INTO users(first_name,last_name,email,password,created_at) "
        q += "VALUES('{}','{}','{}','{}',NOW())".format(first_name,last_name,email,password)
        db.query(q)
        session['name']  = "Thanks for submitting your information, {}".format(first_name)
        session['email'] = "We've sent a confirmation email to {}. Please confirm it.".format(email)

        return redirect('/success')

    return redirect('/')

@app.route('/success')
def success():
    return render_template('success.html',style="static/style.css")

@app.route('/login')
def login():
    return render_template('login.html',style="static/style.css")


@app.route('/process_login',methods=['POST'])
def doLogin():
    valid = True
    email = request.form['email']
    pw    = request.form['password']

    if not email_re.match(email) or len(email) < 1:
        valid = False
        flash('Invalid email format')
    if len(pw) < 8:
        valid = False
        flash('Invalid password length')

    if valid:
        q = "SELECT * FROM users WHERE users.email = '{}'".format(email)
        data = db.query(q)

        if len(data) > 0:
            isHash = bcrypt.check_password_hash(data[0]['password'],pw)

            if isHash:
                session['user'] = data[0]['id'] # ;D
                session['name'] = "You've logged in successfully, {}".format(data[0]['first_name'])
                session['email'] = " "
                return redirect('/success')
            else:
                flash('Invalid Password')
                return redirect('/login')
        else:
            flash("Oops! You don't seem to have an account. We've redirected you to the registration page.")
            valid = False
            return redirect('/')
    else:
        return redirect('/login')

app.run(debug=True)