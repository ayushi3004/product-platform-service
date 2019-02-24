DROP TABLE IF EXISTS Products;
CREATE TABLE Products(
    id serial PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price integer NOT NULL,
    breadcrumbs VARCHAR(200) NOT NULL,
    storeName VARCHAR(20) NOT NULL
);