-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE T_PESSOA (
estado VARCHAR(30),
rua VARCHAR(50),
numero NUMERIC(10),
cidade VARCHAR(50),
nome VARCHAR(50),
data_nascimento DATETIME,
email VARCHAR(50),
senha VARCHAR(30),
id_pessoa NUMERIC(20) PRIMARY KEY
)

CREATE TABLE T_COMENTARIO (
comentario VARCHAR(500),
id_comentario NUMERIC(20) PRIMARY KEY,
data_comentario VARCHAR(10),
curtidas VARCHAR(10),
id_pessoa NUMERIC(10),
FOREIGN KEY(id_pessoa) REFERENCES T_PESSOA (id_pessoa)
)

CREATE TABLE T_POSTAGEM (
data_publicacao DATETIME,
id_publicacao NUMERIC(20) PRIMARY KEY,
id_pessoa NUMERIC(10),
id_produto NUMERIC(10),
FOREIGN KEY(id_pessoa) REFERENCES T_PESSOA (id_pessoa)
)

CREATE TABLE T_PRODUTO (
fabricante VARCHAR(30),
nome VARCHAR(30),
foto VARCHAR(500),
foto1 VARCHAR(500),
foto2 VARCHAR(500),
foto3 VARCHAR(500),
id_produto NUMERIC(10) PRIMARY KEY,
modelo VARCHAR(30),
nota DECIMAL(10)
)

ALTER TABLE T_POSTAGEM ADD FOREIGN KEY(id_produto) REFERENCES T_PRODUTO (id_produto)
