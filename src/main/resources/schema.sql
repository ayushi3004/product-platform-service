DROP TABLE IF EXISTS Products;
CREATE TABLE Products(
    id serial PRIMARY KEY,
    name VARCHAR(100),
    price integer,
    breadcrumbs VARCHAR(200),
    storename VARCHAR(20)
);