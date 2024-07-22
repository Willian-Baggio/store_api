ALTER TABLE sales
ADD CONSTRAINT fk_sales_stores
FOREIGN KEY (store_id) REFERENCES stores (store_id);

ADD CONSTRAINT fk_sales_users
FOREIGN KEY (user_id) REFERENCES users (user_id);