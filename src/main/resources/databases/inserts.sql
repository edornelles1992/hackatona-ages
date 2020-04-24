
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
(fabricante, nome, valor)
VALUES('Zupis', 'ChocolateMC', 5);

INSERT INTO info_goods.T_PRODUTO
(fabricante, nome, valor)
VALUES('zzxte', 'Mamão', 3);

INSERT INTO info_goods.T_PRODUTO
(fabricante, nome, valor)
VALUES('luluz', 'Salgadinho Chips', 6);

INSERT INTO info_goods.T_PRODUTO
(fabricante, nome, valor)
VALUES('Joao Ltda', 'Bolacha Bono', 2);

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





