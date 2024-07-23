ALTER TABLE stores
ADD CONSTRAINT fk_stores_addres_id
FOREIGN KEY (addres_id) REFERENCES addres(id);