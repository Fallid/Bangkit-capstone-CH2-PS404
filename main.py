from flask import Flask, jsonify, render_template, request
from flask_mysqldb import MySQL
from dotenv import load_dotenv
import os

app = Flask(__name__)

load_dotenv()

# Database configuration
app.config['MYSQL_HOST'] = os.getenv('MYSQL_HOST')
app.config['MYSQL_USER'] = os.getenv('MYSQL_USER')
app.config['MYSQL_PASSWORD'] = os.getenv('MYSQL_PASSWORD')
app.config['MYSQL_DB'] = os.getenv('MYSQL_DB')
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
