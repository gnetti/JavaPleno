INSERT INTO tb_usuario (nome, email, senha) VALUES ('Bob', 'bob@mail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO tb_usuario (nome, email, senha) VALUES ('Gil', 'gil@mail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');

INSERT INTO tb_perfil (nome_perfil) VALUES ('PERFIL_USER');
INSERT INTO tb_perfil (nome_perfil) VALUES ('PERFIL_ADMIN');

INSERT INTO tb_perfil_usuario (id_usuario, id_perfil) VALUES (1, 1);
INSERT INTO tb_perfil_usuario (id_usuario, id_perfil) VALUES (2, 1);
INSERT INTO tb_perfil_usuario (id_usuario, id_perfil) VALUES (2, 2);