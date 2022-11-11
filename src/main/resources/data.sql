--add payment data
INSERT INTO PAYMENT (entry, installments) values (1,5);
INSERT INTO PAYMENT (entry, installments) values (2,2);
INSERT INTO PAYMENT (entry, installments) values (3,5);
INSERT INTO PAYMENT (entry, installments) values (4,2);

--add product data
INSERT INTO PRODUCT (name, price, payment_entity_id) VALUES ('PHONE', 1890.99,1);
INSERT INTO PRODUCT (name, price, payment_entity_id) VALUES ('WATCH', 2500.99,2);
INSERT INTO PRODUCT (name, price, payment_entity_id) VALUES ('MOUSE', 400.91,3);
INSERT INTO PRODUCT (name, price, payment_entity_id) VALUES ('HEADSET', 350.00,4);
