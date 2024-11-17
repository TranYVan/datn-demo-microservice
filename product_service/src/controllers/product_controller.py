from flask import request, Response, json, Blueprint
from src.models.product_model import Product
from src import db
import time

products = Blueprint('products', __name__)

@products.route('/all', methods = ["GET"])
def fetch_all():

    products = Product.query.all()
    products_obj = [{
        "id": item.id,
        "prod_name": item.prod_name,
        "stock_quantity": item.stock_quantity
    } for item in products]

    return Response(
        response=json.dumps({'status': "success", "data": products_obj}),
        status=200,
        mimetype='application/json'
    )

@products.route('/<prod_id>', methods = ["GET"])
def fetch(prod_id):

    product = Product.query.filter_by(id=prod_id).first()

    product_obj = {
        "id": product.id,
        "prod_name": product.prod_name,
        "stock_quantity": product.stock_quantity,
        "prod_type": product.prod_type.type_name
    } 

    return Response(
        response=json.dumps({'status': "success", "data": product_obj}),
        status=200,
        mimetype='application/json'
    )

@products.route('/<prod_id>', methods = ["PUT"])
def update(prod_id):
    # time.sleep(5)
    payload = request.get_json()
    product = Product.query.filter_by(id=prod_id).update(payload)
    db.session.commit()

    return Response(
        response=json.dumps({'status': "success", "data": "Updated successfully"}),
        status=200,
        mimetype='application/json'
    )

@products.route('/', methods=["POST"])
def create():
    payload = request.get_json()
    # product_obj = Product
    db.session.add()