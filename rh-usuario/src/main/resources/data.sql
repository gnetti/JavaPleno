INSERT INTO tb_usuario (nome, email, password) VALUES ('Bob', 'bob@mail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO tb_usuario (nome, email, password) VALUES ('Gen', 'gen@mail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (1, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (2, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (2, 2);