DROP TABLE IF EXISTS Comments;
CREATE TABLE Comments(
    id serial PRIMARY KEY references products(id) FOREIGN KEY,
    userName VARCHAR(100),
    comment VARCHAR(500)
);