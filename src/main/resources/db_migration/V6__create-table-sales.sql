CREATE TABLE sales (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  stores_id INTEGER,
  users_id INTEGER,
  sale_date DATETIME,
  quantity_sold INTEGER,
  total_price INTEGER,
  payment_method VARCHAR(50)
);