CREATE TABLE foods (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  food_name VARCHAR(50),
  store_id INTEGER,
  quantity INTEGER,
  price DECIMAL(10, 2),
  description VARCHAR(255)
);