CREATE TABLE drinks (
  drink_id INTEGER PRIMARY KEY,
  drink_name VARCHAR(50),
  store_id INTEGER,
  quantity INTEGER,
  price DECIMAL(10, 2),
  description VARCHAR(255)
);