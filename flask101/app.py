from flask import Flask

app = Flask(__name__)


@app.route("/")
def index():
    return "Hello, world!"


@app.route("/<string:name>")
def hello(name):
    return f'hello, {name}!'  # f means format


if __name__ == "__main__":
    app.run(host="127.0.0.1", port=5000, debug=True)
