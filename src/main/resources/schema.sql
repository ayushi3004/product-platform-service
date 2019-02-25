DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS Comment;

CREATE TABLE Products(
    productId serial PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price integer NOT NULL,
    breadcrumbs VARCHAR(200) NOT NULL,
    storeName VARCHAR(20) NOT NULL
);

CREATE TABLE Comments(
    commentId serial PRIMARY KEY,
    userName VARCHAR(100),
    message VARCHAR(500),
    productId INTEGER,
    CONSTRAINT fk_comment_product FOREIGN KEY ("productid") REFERENCES PRODUCTS ("productid")
);