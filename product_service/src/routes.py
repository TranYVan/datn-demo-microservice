from flask import Blueprint
from src.controllers.product_controller import products

api = Blueprint('api', __name__)

api.register_blueprint(products, url_prefix='/products')