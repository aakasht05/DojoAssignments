from flask import Flask,render_template,redirect,request,session

app = Flask(__name__)

@app.route('/')
def index():
	style="static/style.css"
	return render_template('index.html',style=style)

@app.route('/result',methods=['POST'])
def upload():
	pass
app.run(debug=True)
