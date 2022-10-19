from app import app
from db import mysql
from flask import render_template, request, redirect, url_for, session
from flask_bcrypt import Bcrypt
from flask_cors import CORS
import pymysql
import re

# Secret key generated using:
# python3 -c 'import secrets; print(secrets.token_hex())'

app.secret_key = 'b29401330c3b1d733df280873a9ce587fb39fbcf507cdc5f19fbff5b4c221673'
bcrypt = Bcrypt(app)

CORS(app)
@app.route('/')
@app.route('/search', methods=['GET'])
def search():
    search_query = None
    if 'query' in request.args:
        search_query = request.args['query']
    return render_template('search.html', search_query=search_query)

@app.route('/login', methods = ['GET','POST'])
def login():
    message = ''
    if request.method == 'POST' and 'email' in request.form and 'password' in request.form:
        email = request.form['email']
        password = request.form['password']
        conn = mysql.connect()
        cursor = conn.cursor(pymysql.cursors.DictCursor)
        cursor.execute('SELECT * FROM user WHERE email = % s', (email))
        user = cursor.fetchone()
        if user and bcrypt.check_password_hash(user['pw_hash'], password):
            session['loggedin'] = True
            session['id'] = user['id']
            session['name'] = user['name']
            session['email'] = user['email']
            message = 'Logged in successfully !'
            return render_template('user.html', message = message)
        else:
            message = 'Incorrect email or password.'
    return render_template('login.html', message = message)
  
@app.route('/logout')
def logout():
    session.pop('loggedin', None)
    session.pop('id', None)
    session.pop('email', None)
    return redirect(url_for('login'))
  
@app.route('/register', methods =['GET', 'POST'])
def register():
    message = ''
    if request.method == 'POST' and 'name' in request.form and 'password' in request.form and 'email' in request.form :
        user_name = request.form['name']
        password = request.form['password']
        email = request.form['email']
        conn = mysql.connect()
        cursor = conn.cursor(pymysql.cursors.DictCursor)
        cursor.execute('SELECT * FROM user WHERE email = % s', (email, ))
        account = cursor.fetchone()
        if account:
            message = 'Account already exists !'
        elif not re.match(r'[^@]+@[^@]+\.[^@]+', email):
            message = 'Invalid email address !'
        elif not user_name or not password or not email:
            message = 'Please fill out the form !'
        else:
            pw_hash = bcrypt.generate_password_hash(password)
            cursor.execute('INSERT INTO user VALUES (NULL, % s, % s, % s)', (user_name, email, pw_hash))
            conn.commit()
            message = 'You have successfully registered !'
    elif request.method == 'POST':
        message = 'Please fill out the form !'
    return render_template('register.html', message = message)
 

if __name__ == "__main__":
    app.run(debug=True,host='0.0.0.0')
