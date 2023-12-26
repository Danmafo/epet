INSERT INTO TB_ROLE(name) VALUES ('employee');
INSERT INTO TB_ROLE(name) VALUES ('administrator');

INSERT INTO TB_DEPARTMENT(name) VALUES ('administrative');
INSERT INTO TB_DEPARTMENT(name) VALUES ('cash');

INSERT INTO TB_PRODUCT(name, code, price, quantity) VALUES ('Ração', '1', 10.0, 10);
INSERT INTO TB_PRODUCT(name, code, price, quantity) VALUES ('Brinquedo para Cachorro', '2', 15.0, 20);
INSERT INTO TB_PRODUCT(name, code, price, quantity) VALUES ('Coleira', '3', 8.5, 15);
INSERT INTO TB_PRODUCT(name, code, price, quantity) VALUES ('Shampoo para Gatos', '4', 12.0, 15);
INSERT INTO TB_PRODUCT(name, code, price, quantity) VALUES ('Coleira Antipulgas', '5', 7.5, 25);
INSERT INTO TB_PRODUCT(name, code, price, quantity) VALUES ('Areia Sanitária', '6', 8.0, 30);
INSERT INTO TB_PRODUCT(name, code, price, quantity) VALUES ('Bolinha de Borracha', '7', 5.0, 50);
INSERT INTO TB_PRODUCT(name, code, price, quantity) VALUES ('Comedouro Automático', '8', 20.0, 10);
INSERT INTO TB_PRODUCT(name, code, price, quantity) VALUES ('Brinquedo para Pássaros', '9', 6.0, 20);
INSERT INTO TB_PRODUCT(name, code, price, quantity) VALUES ('Casinha para Hamster', '10', 15.0, 8);
INSERT INTO TB_PRODUCT(name, code, price, quantity) VALUES ('Ração Premium para Cães', '11', 18.0, 15);
INSERT INTO TB_PRODUCT(name, code, price, quantity) VALUES ('Arranhador para Gatos', '12', 25.0, 12);
INSERT INTO TB_PRODUCT(name, code, price, quantity) VALUES ('Comedouro para Pássaros', '13', 10.0, 30);

INSERT INTO TB_USER(name, email, password, contact, role_id, department_id) VALUES ('daniel.fonseca', 'daniel.fonseca@email.com', '123456', '(91)911111111', 1, 1);
INSERT INTO TB_USER(name, email, password, contact, role_id, department_id) VALUES ('taylor.souza', 'taylor.souza@email.com', 'abcdef', '(91)922222222', 2, 1);
INSERT INTO TB_USER(name, email, password, contact, role_id, department_id) VALUES ('henrique.teixeira', 'henrique.teixeira@email.com', 'qwerty', '(91)933333333', 1, 2);

INSERT INTO TB_SERVICE(name, date, user_id) VALUES ('Banho e Tosa', '2023-12-31', 1);
INSERT INTO TB_SERVICE(name, date, user_id) VALUES ('Consulta', '2023-12-28', 3);
INSERT INTO TB_SERVICE(name, date, user_id) VALUES ('Banho e Tosa', '2023-12-27', 1);
INSERT INTO TB_SERVICE(name, date, user_id) VALUES ('Banho e Tosa', '2023-12-26', 2);
INSERT INTO TB_SERVICE(name, date, user_id) VALUES ('Consulta', '2023-12-25', 3);
INSERT INTO TB_SERVICE(name, date, user_id) VALUES ('Consulta', '2023-12-24', 1);
