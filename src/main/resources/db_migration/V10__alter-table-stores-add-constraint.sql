ALTER TABLE users
ADD CONSTRAINT fk_users_addres
FOREIGN KEY (addres_id) REFERENCES addres (addres_id);