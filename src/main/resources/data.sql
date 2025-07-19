INSERT INTO products (name, price, stock) VALUES ('Samsung S21', 10000, 5); --1
INSERT INTO products (name, price, stock) VALUES ('Samsung S22', 20000, 5); --2
INSERT INTO products (name, price, stock) VALUES ('Samsung S23', 30000, 5); --3
INSERT INTO products (name, price, stock) VALUES ('Samsung S24', 40000, 5); --4
INSERT INTO products (name, price, stock) VALUES ('Samsung S25', 50000, 5); --5
INSERT INTO products (name, price, stock) VALUES ('Samsung S26', 60000, 5); --6
INSERT INTO products (name, price, stock) VALUES ('Samsung S27', 70000, 5); --7
INSERT INTO products (name, price, stock) VALUES ('Samsung S28', 80000, 5); --8
INSERT INTO products (name, price, stock) VALUES ('Samsung S29', 90000, 5); --9
INSERT INTO products (name, price, stock) VALUES ('Samsung S30', 100000, 5); --10
INSERT INTO products (name, price, stock) VALUES ('Samsung S31', 110000, 5); --11

insert into discounts (percent, start_date, end_date) values (5, '2025-07-19', '2025-07-19');
insert into discounts (percent, start_date, end_date) values (10, '2025-07-19', '2025-07-19');
insert into discounts (percent, start_date, end_date) values (20, '2025-07-20', '2025-07-19');

insert into product_discount (product_id, discount_id) values (1, 1);
insert into product_discount (product_id, discount_id) values (2, 1);