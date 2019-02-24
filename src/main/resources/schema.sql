DROP TABLE IF EXISTS Products;
CREATE TABLE Products(
    id serial PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price integer NOT NULL,
    breadcrumbs VARCHAR(200) NOT NULL,
    storename VARCHAR(20) NOT NULL
);