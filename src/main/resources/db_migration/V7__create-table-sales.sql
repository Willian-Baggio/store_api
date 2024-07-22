CREATE TABLE sales (
  sale_id INTEGER PRIMARY KEY,
  store_id INTEGER,
  user_id INTEGER,
  sale_date DATETIME,
  quantity_sold INTEGER,
  total_price INTEGER,
  payment_method VARCHAR(50)
);