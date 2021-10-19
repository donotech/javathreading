from flask import Flask, render_template
from flask_cors import CORS, cross_origin
from flask import request, render_template_string

# Flask constructor takes the name of
# current module (__name__) as argument.
app = Flask(__name__)
cors = CORS(app)
app.config['CORS_HEADERS'] = 'Content-Type'


def read_config_entries():
    return {'dbuser': 'root_user', 'passwd': 'mysecret_password'}


# The route() function of the Flask class is a decorator,
# which tells the application which URL should call
# the associated function.
@app.route('/search')
@cross_origin()
# ‘/’ URL is bound with hello_world() function.
def search():
    dbConfig = read_config_entries()
    username = request.args.get('username')
    searchterms = request.args.get('search')
    print(dbConfig)
    template = f'''Hello {username} <p> you searched %s </p>''' % searchterms
    search_term_store.append(searchterms)
    return render_template_string(template)


search_term_store = []
@app.route('/search2')
@cross_origin()
# ‘/’ URL is bound with hello_world() function.
def search2():
    dbConfig = read_config_entries()
    username = request.args.get('username')
    searchterms = request.args.get('search')
    search_term_store.append(searchterms)
    return f'<h1>added search term total terms = {len(search_term_store)}</h1><a href="/list">To see all searches</a>'


@app.route('/')
@cross_origin()
# ‘/’ URL is bound with hello_world() function.
def hello_world():
    return render_template('test.html')


@app.route('/list')
@cross_origin()
def list_all_terms():
    str = '<html><body><ol>'
    for i in search_term_store:
        str += '<li>' + i + '</li>'
        print(str)
    str += '</ol><p><a href="/">Click To Go Back</a></p></body></html>'
    return str


# main driver function
if __name__ == '__main__':
    # run() method of Flask class runs the application
    # on the local development server.
    app.run()