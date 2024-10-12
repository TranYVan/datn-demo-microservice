
from src import db

class Product(db.Model):
    __tablename__= 'product'

    id = db.Column(db.Integer(), primary_key = True, unique=True)
    prod_name = db.Column(db.String(255), unique=True)
    stock_quantity = db.Column(db.Integer(), nullable=False)
    prod_type_id = db.Column(db.Integer(), db.ForeignKey("prod_type.id"))
    prod_type = db.relationship("Product_type", back_populates="products")