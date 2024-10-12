
from src import db

class Product_type(db.Model):
    __tablename__ = "prod_type"
    id = db.Column(db.Integer(), primary_key = True, unique=True)
    type_name = db.Column(db.String(60), unique=True)
    products = db.relationship("Product", back_populates="prod_type", lazy="dynamic")