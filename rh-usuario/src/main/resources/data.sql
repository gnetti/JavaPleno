INSERT INTO tb_usuario (profissao_id, nome, email, colaborador, password,situacao_usuario, primeiro_acesso, cpf, matricula) VALUES (0, 'Gen', 'gen@mail.com', '0', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu',1, Null, '27813149009', 'BR278131490');
INSERT INTO tb_usuario (profissao_id, nome, email, colaborador, password,situacao_usuario, primeiro_acesso, cpf, matricula) VALUES (1, 'Jos', 'jos@mail.com', '1', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu',1, Null, '77112227003', 'BR771122270');
INSERT INTO tb_usuario (profissao_id, nome, email, colaborador, password,situacao_usuario, primeiro_acesso, cpf, matricula) VALUES (2, 'Bob', 'bob@mail.com', '1', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu',1, Null, '69266848042', 'BR692668480');
INSERT INTO tb_usuario (profissao_id, nome, email, colaborador, password,situacao_usuario, primeiro_acesso, cpf, matricula) VALUES (3, 'Will', 'will@mail.com', '1', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu',1, Null, '39469221044', 'BR394692210');
INSERT INTO tb_usuario (profissao_id, nome, email, colaborador, password,situacao_usuario, primeiro_acesso, cpf, matricula) VALUES (4, 'Mary', 'mary@mail.com', '1', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu',1, Null, '93065540010', 'BR930655400');
INSERT INTO tb_usuario (profissao_id, nome, email, colaborador, password,situacao_usuario, primeiro_acesso, cpf, matricula) VALUES (5, 'Melissa', 'mellissa@mail.com', '1', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu',1, Null, '30763798010', 'BR307637980');
INSERT INTO tb_usuario (profissao_id, nome, email, colaborador, password,situacao_usuario, primeiro_acesso, cpf, matricula) VALUES (6, 'Erika', 'erika@mail.com', '1', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu',1, Null, '12683560001', 'BR126835600');
INSERT INTO tb_usuario (profissao_id, nome, email, colaborador, password,situacao_usuario, primeiro_acesso, cpf, matricula) VALUES (7, 'Jasmin', 'jasmin@mail.com', '1', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu',1, Null, '82864843048', 'BR828648430');
INSERT INTO tb_usuario (profissao_id, nome, email, colaborador, password,situacao_usuario, primeiro_acesso, cpf, matricula) VALUES (8, 'Helenna', 'helenna@mail.com', '1', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu',1, Null, '39602664053', 'BR396026640');
INSERT INTO tb_usuario (profissao_id, nome, email, colaborador, password,situacao_usuario, primeiro_acesso, cpf, matricula) VALUES (9, 'Jorge', 'jorge@mail.com', '1', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu',1, Null, '79859615004', 'BR798596150');
INSERT INTO tb_usuario (profissao_id, nome, email, colaborador, password,situacao_usuario, primeiro_acesso, cpf, matricula) VALUES (10, 'Petter', 'petter@mail.com', '1', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu',1, Null, '43821243015', 'BR438212430');
INSERT INTO tb_usuario (profissao_id, nome, email, colaborador, password,situacao_usuario, primeiro_acesso, cpf, matricula) VALUES (11, 'Walter', 'walter@mail.com', '1', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu',1, Null, '21104735091', 'BR211047350');
INSERT INTO tb_usuario (profissao_id, nome, email, colaborador, password,situacao_usuario, primeiro_acesso, cpf, matricula) VALUES (12, 'Hernry', 'henry@mail.com', '1', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu',1, Null, '57053554082', 'BR570535540');
INSERT INTO tb_usuario (profissao_id, nome, email, colaborador, password,situacao_usuario, primeiro_acesso, cpf, matricula) VALUES (13, 'marta', 'marta@mail.com', '1', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu',1, Null, '31889244023', 'BR318892440');



INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');


INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (1, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (1, 2);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (2, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (3, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (4, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (5, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (6, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (7, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (8, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (9, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (10, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (11, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (12, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (13, 1);
INSERT INTO tb_role_usuario (id_usuario, id_role) VALUES (14, 1);
