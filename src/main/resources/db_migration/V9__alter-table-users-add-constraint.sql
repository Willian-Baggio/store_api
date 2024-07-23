ALTER TABLE users
ADD CONSTRAINT fk_users_addres_id
FOREIGN KEY (addres_id) REFERENCES addres(id);