ALTER TABLE products_sold
ADD CONSTRAINT fk_products_sold_food_id
FOREIGN KEY (food_id) REFERENCES foods(id);

ALTER TABLE products_sold
ADD CONSTRAINT fk_products_sold_drink_id
FOREIGN KEY (drink_id) REFERENCES drinks(id);

ALTER TABLE products_sold
ADD CONSTRAINT fk_products_sold_sale_id
FOREIGN KEY (sale_id) REFERENCES sales(id);