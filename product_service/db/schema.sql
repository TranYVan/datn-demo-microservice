
CREATE TABLE prod_type (
    id SERIAL PRIMARY KEY,
    type_name VARCHAR(60) UNIQUE NOT NULL
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    prod_name VARCHAR(255) UNIQUE NOT NULL,
    stock_quantity INTEGER NOT NULL,
    prod_type_id INTEGER REFERENCES prod_type(id)
);

