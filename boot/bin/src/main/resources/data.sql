INSERT INTO brand (id,name)
VALUES(1,'ZARA');

INSERT INTO price_fee (id, name)
VALUES(1,'Fee no. 1'),(2,'Fee no. 2'),(3,'Fee no. 3'),(4,'Fee no. 4');

INSERT INTO product (id, name)
VALUES(35455, 'Jeans');

INSERT INTO price (id, brand_id, start_date, end_date, price_fee_id, product_id, priority, price, currency)
VALUES(1,1,'2020-06-14T14:00:00+01:00', '2020-12-31T14:00:00+01:00', 1, 35455, 0, 35.50, 'EURO'),
(2,1,'2020-06-14T14:00:00+01:00','2020-06-14T14:00:00+01:00', 2 , 35455, 1, 25.45,'EURO'),
(3,1,'2020-06-15T14:00:00+01:00','2020-06-15T14:00:00+01:00',3,35455,1,30.50, 'EURO'),
(4,1, '2020-06-15T14:00:00+01:00','2020-12-31T14:00:00+01:00',4, 35455, 1,38.95,'EURO');