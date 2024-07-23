CREATE TABLE users (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50),
  password VARCHAR(50),
  email VARCHAR(50),
  cell_phone VARCHAR(20),
  cpf VARCHAR(14),
  registration_date DATETIME,
  role_id INTEGER,
  addres_id INTEGER
);