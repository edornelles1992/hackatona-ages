

CREATE TABLE T_PESSOA (
id_pessoa INT(20) not null AUTO_INCREMENT PRIMARY KEY,
estado VARCHAR(30) not null,
cidade VARCHAR(50),
nome VARCHAR(50)not null,
data_nascimento DATETIME,
email VARCHAR(50) not null,
senha VARCHAR(30) not null
)

CREATE TABLE T_COMENTARIO (
comentario VARCHAR(500),
id_comentario INT(20) not null AUTO_INCREMENT PRIMARY KEY,
data_comentario DATETIME not null,
curtidas NUMERIC(20),
id_pessoa INT(20),
FOREIGN KEY(id_pessoa) REFERENCES T_PESSOA (id_pessoa)
)

CREATE TABLE T_POSTAGEM (
data_publicacao DATETIME not null,
id_publicacao INT(20) not null AUTO_INCREMENT PRIMARY KEY,
id_pessoa INT(20) not null,
id_produto INT(20) not null,
FOREIGN KEY(id_pessoa) REFERENCES T_PESSOA (id_pessoa)
)

CREATE TABLE T_PRODUTO (
fabricante VARCHAR(30),
nome VARCHAR(30) not null,
foto VARCHAR(500),
foto1 VARCHAR(500),
foto2 VARCHAR(500),
foto3 VARCHAR(500),
id_produto INT(20)  not null AUTO_INCREMENT PRIMARY KEY,
modelo VARCHAR(30),
nota DECIMAL(10)
)

CREATE TABLE T_MENSAGEM (
cod_mensagem VARCHAR(5) not null PRIMARY KEY,
mensagem VARCHAR(255) not null
)

ALTER TABLE T_POSTAGEM ADD FOREIGN KEY(id_produto) REFERENCES T_PRODUTO (id_produto)

ALTER TABLE info_goods.T_COMENTARIO 
DEFAULT CHARSET=utf8 ;

ALTER TABLE info_goods.T_PESSOA 
DEFAULT CHARSET=utf8 ;

ALTER TABLE info_goods.T_POSTAGEM 
DEFAULT CHARSET=utf8 ;

ALTER TABLE info_goods.T_PRODUTO 
DEFAULT CHARSET=utf8 ;

ALTER TABLE info_goods.T_MENSAGEM 
DEFAULT CHARSET=utf8 ;
