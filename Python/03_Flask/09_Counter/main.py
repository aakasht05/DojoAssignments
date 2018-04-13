from flask import Flask,request,redirect,session,render_template

app = Flask(__name__)
app.secret_key = "HIDEMEH"

@app.route('/')
def index():
    session['views'] += 1

    return render_template('index.html',style="static/style.css")

@app.route('/doubleviews')
def doubleViews():
    session['views'] += 1
    return redirect('/')


@app.route('/reset')
def reset():
    session['views'] = 0
    return redirect('/')
app.run(debug=True)