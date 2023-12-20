INSERT INTO TB_ROLE(name) VALUES ('employee');

INSERT INTO TB_DEPARTMENT(name) VALUES ('administrative');

INSERT INTO TB_PRODUCT(name, code, price, quantity) VALUES ('Ração', '1', 10.0, 10);

INSERT INTO TB_USER(name, email, password, contact, role_id, department_id) VALUES ('Daniel Fonseca', 'daniel.fonseca@email.com', '123456', '(91)911111111', 1, 1);

INSERT INTO TB_SERVICE(date, user_id) VALUES ('2023-12-31', 1);
