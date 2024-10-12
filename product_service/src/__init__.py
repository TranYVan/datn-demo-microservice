from flask import Flask
import os
from src.config.config import Config
from dotenv import load_dotenv
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

# loading environment variables
load_dotenv()

# declaring flask application
app = Flask(__name__)

# calling the dev configuration
config = Config().dev_config

# making our application to use dev env
app.env = config.ENV

# Path for our local sql lite database
app.config['SQLALCHEMY_DATABASE_URI'] = os.environ.get("SQLALCHEMY_DATABASE_URI_DEV")

# To specify to track modifications of objects and emit signals
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = os.environ.get("SQLALCHEMY_TRACK_MODIFICATIONS")

# sql alchemy instance
db = SQLAlchemy(app)

# Flask Migrate instance to handle migrations
migrate = Migrate(app, db)

from src.models.product_type_model import Product_type
from src.models.product_model import Product

# import models to let the migrate tool know
from src.routes import api
app.register_blueprint(api, url_prefix='/api')