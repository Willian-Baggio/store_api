ALTER TABLE drinks
ADD CONSTRAINT fk_drinks_stores
FOREIGN KEY (store_id) REFERENCES stores (store_id);