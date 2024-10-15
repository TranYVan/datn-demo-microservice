from flask import request, Response, json, Blueprint
from src.models.product_model import Product

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
        "stock_quantity": product.stock_quantity
    } 

    return Response(
        response=json.dumps({'status': "success", "data": product_obj}),
        status=200,
        mimetype='application/json'
    )