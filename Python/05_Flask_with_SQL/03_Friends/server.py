from flask import Flask,render_template,session,flash,redirect,request
from mysqlconnection import MySQLConnector

app = Flask(__name__)
app.secret_key = "hideMe"
db  = MySQLConnector(app,'friends')

@app.route('/')
def index():
    q = "SELECT * FROM friends"
    friends = db.query(q)
    return render_template('index.html',friends=friends)

@app.route('/new_friend',methods=['POST'])
def create():
    name  = request.form['name']
    age   = request.form['age']
    since = request.form['friend_since']
    valid = True

    if len(name) < 3:
        flash('Name must be 3 or more characters.')
        valid = False
    elif len(name) > 45:
        flash('Name must be 45 or less characters.')
        valid = False

    if int(age) < 0:
        flash('Age must be between 0-128.')
        valid = False
    if int(age) > 128:
        flash('Age must be between 0-128.')
        valid = False

    if valid:
        q = "INSERT INTO friends(name,age,friend_since) "
        q += "VALUES('{}','{}','{}')".format(name,age,since)
        db.query(q)

    return redirect('/')
app.run()