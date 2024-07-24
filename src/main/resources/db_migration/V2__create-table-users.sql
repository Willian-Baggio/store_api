CREATE TABLE users (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50),
  password VARCHAR(60),
  email VARCHAR(50),
  cellphone VARCHAR(20),
  cpf VARCHAR(14),
  registration_date DATETIME,
  addres_id INTEGER,
  role VARCHAR(20)
);