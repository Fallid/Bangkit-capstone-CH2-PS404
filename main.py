from flask import Flask, jsonify, render_template, request
from flask_mysqldb import MySQL

app = Flask(__name__)
app.config['MYSQL_HOST'] = '202.10.40.73'
app.config['MYSQL_USER'] = 'destiplanner'
app.config['MYSQL_PASSWORD'] = 'kE<138£<m1Ly'
app.config['MYSQL_DB'] = 'destiplanner'

mysql = MySQL(app)

@app.route('/', methods=['GET'])
def index():
    return 'tes'

@app.route('/wisata', methods=['GET'])
def wisata():
    try:
        limit = request.args.get('limit', default=None, type=int)

        cur = mysql.connection.cursor()
        
        if limit is not None:
            cur.execute(f"SELECT * FROM wisata LIMIT {limit}")
        else:
            cur.execute("SELECT * FROM wisata")

        results = cur.fetchall()
        cur.close()

        key_order = ['place_id', 'place_name', 'city', 'images', 'price', 'rating', 'dorn', 'coordinate', 'lat', 'long', 'category', 'description']

        json_results = [{key: result[i] for i, key in enumerate(key_order)} for result in results]

        return jsonify({'status' : 200, 'message': 'Success', 'wisata': json_results})

    except Exception as e:
        return jsonify({'error': str(e)})

if __name__ == '__main__':
    app.run(debug=True)
