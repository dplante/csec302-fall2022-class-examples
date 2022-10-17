import pymysql
from app import app
from db import mysql
from flask import jsonify
from flask import render_template

@app.route('/user/')
@app.route('/user/<id>')
def user(id=None):
    user = None
    if id:
        conn = mysql.connect()

        cursor = conn.cursor(pymysql.cursors.DictCursor)
        cursor.execute("SELECT * FROM user WHERE id="+id)

        user = cursor.fetchone()

    return render_template('user.html', user=user)

@app.route('/')
def users():
    conn = mysql.connect()
    
    cursor = conn.cursor(pymysql.cursors.DictCursor)
    cursor.execute("SELECT * FROM user")
    
    rows = cursor.fetchall()
    
    resp = jsonify(rows)
    resp.status_code = 200
    
    return resp

if __name__ == "__main__":
    app.run(debug=True,host='0.0.0.0')
