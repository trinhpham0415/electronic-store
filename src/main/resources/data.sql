INSERT INTO categories (name) VALUES ('phone'); --1
INSERT INTO categories (name) VALUES ('laptop'); --2

INSERT INTO products (name, price, stock, category_id) VALUES ('Samsung S21', 10000, 5, 1); --1
INSERT INTO products (name, price, stock, category_id) VALUES ('Samsung S22', 20000, 5, 1); --2
INSERT INTO products (name, price, stock, category_id) VALUES ('Samsung S23', 30000, 5, 1); --3
INSERT INTO products (name, price, stock, category_id) VALUES ('Samsung S24', 40000, 5, 1); --4
INSERT INTO products (name, price, stock, category_id) VALUES ('Samsung S25', 50000, 5, 1); --5
INSERT INTO products (name, price, stock, category_id) VALUES ('Samsung S26', 60000, 5, 1); --6
INSERT INTO products (name, price, stock, category_id) VALUES ('Samsung S27', 70000, 5, 1); --7
INSERT INTO products (name, price, stock, category_id) VALUES ('Samsung S28', 80000, 5, 1); --8
INSERT INTO products (name, price, stock, category_id) VALUES ('Samsung S29', 90000, 5, 1); --9
INSERT INTO products (name, price, stock, category_id) VALUES ('Samsung S30', 100000, 5, 1); --10
INSERT INTO products (name, price, stock, category_id) VALUES ('Samsung S31', 110000, 5, 1); --11
INSERT INTO products (name, price, stock, category_id) VALUES ('HP EliteBook G8', 120000, 5, 2); --12

insert into discounts (percent, start_date, end_date, created_date) values (10, '2025-07-11', CURRENT_DATE() + 1, CURRENT_DATE()); --1
insert into discounts (percent, start_date, end_date, created_date) values (20, '2025-07-20', CURRENT_DATE() + 1, CURRENT_DATE()); --2
insert into discounts (percent, start_date, end_date, created_date) values (30, '2025-07-20', '2025-07-31', CURRENT_DATE()); --3
insert into discounts (percent, start_date, end_date, created_date) values (40, '2025-07-12', '2025-07-19', CURRENT_DATE()); --4

insert into product_discount (product_id, discount_id) values (1, 1);
insert into product_discount (product_id, discount_id) values (1, 2); -- Product id = 1 has 2 valid discounts id = 1, 2
insert into product_discount (product_id, discount_id) values (2, 1); -- Product id = 2 has 1 valid discount id = 1
insert into product_discount (product_id, discount_id) values (3, 4); -- Product id = 3 has 1 invalid discount id = 4
insert into product_discount (product_id, discount_id) values (4, 1); -- Product id = 4 has 1 valid discount id = 1 and 1 invalid discount id = 4
insert into product_discount (product_id, discount_id) values (4, 4);

insert into customers (name) values ('Trinh Pham'); --1
insert into customers (name) values ('Lan Nguyen'); --2
insert into customers (name) values ('Tran Phan'); --3
insert into customers (name) values ('Ngoc Tran'); --4