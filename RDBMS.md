# Database
- SQL


-- ecommerce:

-- seller -> product(inventry)
-- user -> order -> orderIteams
-- address -> seller/user
-- payment


create database ecommerce;
use ecommerce;


-- sellers first (so FK references work)
CREATE TABLE seller (
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
s_name VARCHAR(255) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;

create table Users(
id bigint unsigned primary key auto_increment,
name varchar(100) not null,
age tinyint unsigned not null check(age >= 18),
gander enum('M', 'F') not null,
email varchar(250) unique,
createdAt timestamp default current_timestamp

);

-- addresses (user can have many addresses; seller can also have addresses if needed)
CREATE TABLE address (
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
owner_type ENUM('USER','SELLER') NOT NULL,   -- simple polymorphic owner
owner_id BIGINT UNSIGNED NOT NULL,
line1 VARCHAR(255) NOT NULL,
line2 VARCHAR(255),
city VARCHAR(100),
state VARCHAR(100),
postal_code VARCHAR(30),
country VARCHAR(100),
is_default BOOL DEFAULT FALSE,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
INDEX (owner_type, owner_id)
) ENGINE=InnoDB;


-- products
CREATE TABLE product (
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
p_name VARCHAR(255) NOT NULL,
sku VARCHAR(100) UNIQUE,
price DECIMAL(12,2) NOT NULL,
seller_id BIGINT UNSIGNED NOT NULL,
category VARCHAR(100),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (seller_id) REFERENCES seller(id) ON DELETE RESTRICT
) ENGINE=InnoDB;


-- inventory (separate from product for flexibility: multiple warehouses, stock events)
CREATE TABLE inventory (
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
product_id BIGINT UNSIGNED NOT NULL,
quantity BIGINT NOT NULL DEFAULT 0,
warehouse VARCHAR(100),
last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE,
INDEX (product_id),
INDEX (warehouse)
) ENGINE=InnoDB;

-- orders (one row per order)
CREATE TABLE orders (
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
user_id BIGINT UNSIGNED NOT NULL,
order_status ENUM('PLACED','PAID','SHIPPED','DELIVERED','CANCELLED','REFUNDED') DEFAULT 'PLACED',
total_amount DECIMAL(14,2) NOT NULL,
shipping_address_id BIGINT UNSIGNED,
placed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY (shipping_address_id) REFERENCES address(id)
) ENGINE=InnoDB;

-- order_items (line-items)
CREATE TABLE order_item (
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
order_id BIGINT UNSIGNED NOT NULL,
product_id BIGINT UNSIGNED NOT NULL,
unit_price DECIMAL(12,2) NOT NULL,
quantity INT NOT NULL,
subtotal DECIMAL(14,2) AS (unit_price * quantity) STORED,
FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
FOREIGN KEY (product_id) REFERENCES product(id),
INDEX (order_id),
INDEX (product_id)
) ENGINE=InnoDB;

-- payments
CREATE TABLE payment (
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
order_id BIGINT UNSIGNED NOT NULL,
amount DECIMAL(14,2) NOT NULL,
payment_method ENUM('CARD','UPI','WALLET','COD') DEFAULT 'CARD',
payment_status ENUM('PENDING','SUCCESS','FAILED','REFUNDED') DEFAULT 'PENDING',
txn_id VARCHAR(255),
paid_at TIMESTAMP NULL,
FOREIGN KEY (order_id) REFERENCES orders(id),
INDEX (order_id)
) ENGINE=InnoDB;

INSERT INTO seller (s_name) VALUES
('Amazon Seller Pvt Ltd'),
('Flipkart Retail'),
('Local Electronics Store'),
('Fashion Hub'),
('Home Essentials');

INSERT INTO users (name, email, gander, age) VALUES
('Vicky', 'vicky@gmail.com', 'M', 24),
('Rahul', 'rahul@gmail.com', 'M', 28),
('Ankit', 'ankit@gmail.com', 'M', 31),
('Priya', 'priya@gmail.com', 'F', 26),
('Neha', 'neha@gmail.com', 'F', 29);

INSERT INTO address (owner_type, owner_id, line1, city, state, postal_code, country, is_default) VALUES
('USER', 1, 'Hostel Road', 'Ahmedabad', 'Gujarat', '380001', 'India', true),
('USER', 2, 'MG Road', 'Bangalore', 'Karnataka', '560001', 'India', true),
('USER', 3, 'Sector 18', 'Noida', 'UP', '201301', 'India', true),
('USER', 4, 'Baner Road', 'Pune', 'Maharashtra', '411045', 'India', true),
('USER', 5, 'Andheri East', 'Mumbai', 'Maharashtra', '400069', 'India', true);


INSERT INTO product (p_name, sku, price, seller_id, category) VALUES
('iPhone 15', 'APL-IP15', 79999.00, 1, 'Mobile'),
('Samsung Galaxy S24', 'SMS-S24', 69999.00, 2, 'Mobile'),
('Sony Headphones', 'SNY-HDPHN', 4999.00, 3, 'Electronics'),
('Nike Running Shoes', 'NK-SHOE', 8999.00, 4, 'Fashion'),
('Wooden Study Table', 'HOME-TABLE', 12999.00, 5, 'Furniture'),
('MacBook Air M2', 'APL-MBA-M2', 114999.00, 1, 'Laptop'),
('Mi Power Bank', 'MI-PB-10K', 1999.00, 3, 'Accessories');


INSERT INTO inventory (product_id, quantity, warehouse) VALUES
(1, 50, 'BLR_WH'),
(2, 40, 'DEL_WH'),
(3, 100, 'DEL_WH'),
(4, 60, 'MUM_WH'),
(5, 30, 'MUM_WH'),
(6, 25, 'BLR_WH'),
(7, 200, 'DEL_WH');

INSERT INTO orders (user_id, total_amount, shipping_address_id, order_status) VALUES
(1, 84998.00, 1, 'PAID'),
(2, 69999.00, 2, 'DELIVERED'),
(3, 12999.00, 3, 'SHIPPED'),
(4, 4999.00, 4, 'PAID'),
(5, 114999.00, 5, 'PLACED');

INSERT INTO order_item (order_id, product_id, unit_price, quantity) VALUES
(1, 1, 79999.00, 1),
(1, 7, 1999.00, 1),

(2, 2, 69999.00, 1),

(3, 5, 12999.00, 1),

(4, 3, 4999.00, 1),

(5, 6, 114999.00, 1);

INSERT INTO payment (order_id, amount, payment_method, payment_status, txn_id, paid_at) VALUES
(1, 84998.00, 'CARD', 'SUCCESS', 'TXN1001', NOW()),
(2, 69999.00, 'UPI', 'SUCCESS', 'TXN1002', NOW()),
(3, 12999.00, 'CARD', 'SUCCESS', 'TXN1003', NOW()),
(4, 4999.00, 'WALLET', 'SUCCESS', 'TXN1004', NOW()),
(5, 114999.00, 'CARD', 'PENDING', 'TXN1005', NULL);


select * from orders;
-- get all the orders of vicky
select * from orders where user_id  =(select id from users where name = 'Vicky');

-- ecommerce:

-- seller -> product(inventry)
-- user -> order -> orderIteams
-- address -> seller/user
-- payment

show tables;
-- write a qiery to get the orders of user = vicky
select * from users;
select * from orders;
select * from order_item;

select count(*) from orders o join users u on 1=1;

select * from orders o join users u on u.id=o.user_id where u.name="Vicky";
select * from orders where user_id = (select id from users where name = 'Vicky');

select oi.*, o.*, p.*
from orders o
inner join order_item oi on 1=1
inner join product p on p.id = oi.product_id
;

-- order -> order_item
select product_id as prodct, count(quantity) as orders from order_item group by product_id;

select p.id, p.p_name, sum(oi.quantity) as quantity
FROM order_item oi
JOIN product p on 1=1
JOIN orders o on o.id = oi.order_id
WHERE o.placed_at >= DATE_SUB(current_date, interval 30 day)
and o.order_status in('paid', 'shipped', 'delivered')
group by p.id, p.p_name
order by quantity desc
limit 10;
