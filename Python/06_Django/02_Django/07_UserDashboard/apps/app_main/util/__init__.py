import re
import bcrypt
char_re  = re.compile(r'^[A-Za-z]+$')
num_re   = re.compile(r'^\d+$')
email_re = re.compile(r"(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$)")

def tern(cond,a,b):
	if cond:
		return a
	else:
		return b

def isBlank(field):
    return len(field) < 1

def isNum(field):
    return num_re.match(field)

def isChar(field):
    return char_re.match(field)

def validPass(field):
    return len(field) > 7

def validEmail(field):
    return email_re.match(field)

def matchPass(password,hashed):
	return bcrypt.hashpw(password.encode('utf-8'),hashed.encode('utf-8')) == hashed

def hashPass(password):
	return bcrypt.hashpw(password.encode('utf-8'),bcrypt.gensalt())

def doNames(first,last,li):
	if isBlank(first):
		li.append('First name cannot be blank.')
	elif not isChar(first):
		li.append("First name must contain characters only.")
	if isBlank(last):
		li.append('Last name cannot be blank.')
	elif not isChar(last):
		li.append("Last name must contain characters only.")
def doEmail(email,li):
	if isBlank(email):
		li.append("Email cannot be blank")
	elif not validEmail(email):
		li.append("Invalid email format.")
def doPass(password,li):
	if isBlank(password):
		li.append('Password cannot be blank.')
def doPassword(password,confirm,li):
	if isBlank(password):
		li.append('Password cannot be blank.')
	elif not validPass(password):
		li.append('Password must be at least 8 characters in length.')
	if isBlank(confirm):
		li.append('Password Confirmation cannot be blank.')
	elif password != confirm:
		li.append('Passwords must match.')