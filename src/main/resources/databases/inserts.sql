
/* PESSOAS */

INSERT INTO info_goods.T_PESSOA
(estado, cidade, nome, data_nascimento, email, senha)
VALUES('Rio Grande do Sul', 'Porto Alegre', 'Eduardo Dornelles', '1992-06-30', 'e_dornelles1992@hotmail.com', '123456');

INSERT INTO info_goods.T_PESSOA
(estado, cidade, nome, data_nascimento, email, senha)
VALUES('Parana',  'Londrina', 'Luiz Paulo', '1995-08-25', 'luiz_123@hotmail.com', '123456');

INSERT INTO info_goods.T_PESSOA
(estado, cidade, nome, data_nascimento, email, senha)
VALUES('São Paulo', 'São Paulo', 'Maria Silva de Paula', '1994-03-05', 'mariasilva@gmail.com', '123456');

INSERT INTO info_goods.T_PESSOA
(estado, cidade, nome, data_nascimento, email, senha)
VALUES('Salvador', 'Bahia', 'João Ricardo', '1997-08-21', 'joaoricardo2@hotmail.com', '123456');

/* PRODUTOS */

INSERT INTO info_goods.T_PRODUTO
(fabricante, nome, foto, foto1, foto2, foto3, modelo, nota)
VALUES('Panasonic', 'Barbeador X29', '', '', '', '', 'A520BC', 0);

INSERT INTO info_goods.T_PRODUTO
(fabricante, nome, foto, foto1, foto2, foto3, modelo, nota)
VALUES('Brastemp', 'Geladeira F203', '', '', '', '', 'XX20XS', 0);

INSERT INTO info_goods.T_PRODUTO
(fabricante, nome, foto, foto1, foto2, foto3, modelo, nota)
VALUES('Castor', 'Colchão King B20', '', '', '', '', 'MOB23', 0);

INSERT INTO info_goods.T_PRODUTO
(fabricante, nome, foto, foto1, foto2, foto3, modelo, nota)
VALUES('Dell', 'Notebook Special 15R', '', '', '', '', 'AL22F', 0);

/* POSTAGEM */

INSERT INTO info_goods.T_POSTAGEM
(data_publicacao, id_pessoa, id_produto,curtida)
VALUES(NOW(), 1, 1,5);

INSERT INTO info_goods.T_POSTAGEM
(data_publicacao, id_pessoa, id_produto,curtida)
VALUES(NOW(), 2, 2,10);

INSERT INTO info_goods.T_POSTAGEM
(data_publicacao, id_pessoa, id_produto,curtida)
VALUES(NOW(), 1, 3,12);

INSERT INTO info_goods.T_POSTAGEM
(data_publicacao, id_pessoa, id_produto,curtida)
VALUES(NOW(), 4, 4,30);

/* COMENTARIO */

INSERT INTO info_goods.T_COMENTARIO
(comentario, data_comentario, curtidas, id_pessoa, id_publicacao)
VALUES('Excelente produto recomendo a todos!', NOW(), 0, 1, 3);

INSERT INTO info_goods.T_COMENTARIO
(comentario, data_comentario, curtidas, id_pessoa, id_publicacao)
VALUES('Bom produto, porém possui pouca durabilidade, não recomendo pelo custo beneficio!', NOW(), 0, 2, 4);

INSERT INTO info_goods.T_COMENTARIO
(comentario, data_comentario, curtidas, id_pessoa, id_publicacao)
VALUES('Super recomendo! ótimo custo beneficio e boa durabilidade', NOW(), 2, 3, 1);

INSERT INTO info_goods.T_COMENTARIO
(comentario, data_comentario, curtidas, id_pessoa, id_publicacao)
VALUES('Péssimo produto! não recomendo a ninguem! caro e não funciona!', NOW(), 1, 1, 2);

INSERT INTO info_goods.T_COMENTARIO
(comentario, data_comentario, curtidas, id_pessoa, id_publicacao)
VALUES('Bom produto, mas tem muito a melhorar!', NOW(), 2, 1,3);

INSERT INTO info_goods.T_COMENTARIO
(comentario, data_comentario, curtidas, id_pessoa, id_publicacao)
VALUES('Não adquira, propaganda enganosa!', NOW(), 0, 2,2);

INSERT INTO info_goods.T_COMENTARIO
(comentario, data_comentario, curtidas, id_pessoa, id_publicacao)
VALUES('Bom produto, porém gasta muita energia!', NOW(), 0, 3,4);

INSERT INTO info_goods.T_COMENTARIO
(comentario, data_comentario, curtidas, id_pessoa, id_publicacao)
VALUES('Muita propaganda e baixa qualidade!', NOW(), 0, 3,1);

/* MENSAGENS */

INSERT INTO T_MENSAGEM (cod_mensagem, mensagem) 
VALUES ('A001', 'Usuário não encontrado.');

INSERT INTO T_MENSAGEM (cod_mensagem, mensagem) 
values ('A002', 'Conta criada com sucesso.');

INSERT INTO T_MENSAGEM (cod_mensagem, mensagem) 
values ('A003', 'Erro ao criar a conta.');

INSERT INTO T_MENSAGEM (cod_mensagem, mensagem) 
values ('A004', 'Preencha todos os campos corretamente.');

INSERT INTO T_MENSAGEM (cod_mensagem, mensagem) 
values ('A005', 'Digite um E-mail válido.');

INSERT INTO T_MENSAGEM (cod_mensagem, mensagem) 
values ('A006', 'Digite uma senha com no minimo seis caracteres.');





