ALTER TABLE sales
ADD CONSTRAINT fk_sales_store_id
FOREIGN KEY (store_id) REFERENCES stores(id);

ALTER TABLE sales
ADD CONSTRAINT fk_sales_user_id
FOREIGN KEY (user_id) REFERENCES users(id);