from flask import Flask
from routes.search_operators import operator_bp
from flask_cors import CORS


app = Flask(__name__)

CORS(app)

app.register_blueprint(operator_bp)

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)
