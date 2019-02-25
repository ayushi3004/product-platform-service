DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS products;

CREATE TABLE products(
    productId serial PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price integer NOT NULL,
    breadcrumbs VARCHAR(200) NOT NULL,
    storeName VARCHAR(20) NOT NULL
);

CREATE TABLE comments(
    commentId serial PRIMARY KEY,
    userName VARCHAR(100),
    message VARCHAR(500),
    productId INTEGER,
    CONSTRAINT fk_comment_product FOREIGN KEY ("productid") REFERENCES PRODUCTS ("productid")
);