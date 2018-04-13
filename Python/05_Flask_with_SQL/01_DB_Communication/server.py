from flask import Flask,render_template,session,flash,redirect,request
from mysqlconnection import MySQLConnector

app = Flask(__name__)
db  = MySQLConnector(app,'friendsdb')

@app.route('/')
def index():
    friends = db.query("SELECT * FROM friends;")
    print friends
    return render_template('index.html',friends=friends)

@app.route('/friends',methods=['POST'])
def create():
    q =  "INSERT INTO friends(first_name,last_name,occupation,created_at,updated_at) "
    q += "VALUES(:first_name,:last_name,:occupation,NOW(),NOW());"
    
    data = {
        'first_name':request.form['first_name'],
        'last_name':request.form['last_name'],
        'occupation':request.form['occupation']
    }
    db.query(q,data)
    return redirect('/')


@app.route('/friends/<friend_id>')
def show(friend_id):
    q = "SELECT * FROM friends WHERE id = :specific_id"
    data = {'specific_id':friend_id}
    friends = db.query(q,data)

    return render_template('index.html',friends=friends[0])


@app.route('/update_friend/<friend_id>',methods=['POST'])
def update():
    q  = 'UPDATE friends SET first_name = :first_name,last_name = :last_name,occupation = :occupation '
    q += 'WHERE id = :id;'

    data = {
        'first_name':request.form['first_name'],
        'last_name':request.form['last_name'],
        'occupation':request.form['occupation'],
        'id':friend_id
    }
    db.query(q,data)
    return redirect('/')

@app.route('/remove_friend/<friend_id>',methods=['POST'])
def delete():
    q = "DELETE FROM friends WHERE id = :id;"
    data = {'id':friend_id}
    db.query(q,data)
    return redirect('/')

app.run(debug=True)