from flask import Flask
from flask import request
           
app = Flask(__name__)
                     
@app.route('/login', methods=['GET', 'POST'])
def login():                                 
    resp = ""
    if request.method == 'POST' and 'email' in request.form and 'password' in request.form:
        values = {}                                                                        
        values['email'] = request.form['email']
        values['password'] = request.form['password']
        resp = str(values)                           
        out_file = open("output.txt", 'a')
        out_file.write(resp)              
                              
    return resp               
               
if __name__ == "__main__":
    app.run(debug=True,host='0.0.0.0')
