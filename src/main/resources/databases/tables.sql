

CREATE TABLE T_PESSOA (
id_pessoa INT(20) not null AUTO_INCREMENT PRIMARY KEY,
estado VARCHAR(30) not null,
cidade VARCHAR(50),
nome VARCHAR(50)not null,
data_nascimento DATETIME,
email VARCHAR(50) not null,
senha VARCHAR(30) not null
)

CREATE TABLE T_PRODUTO (
fabricante VARCHAR(30),
nome VARCHAR(30) not null,
id_produto INT(20)  not null AUTO_INCREMENT PRIMARY KEY,
valor DECIMAL(10,2)
)

CREATE TABLE T_MENSAGEM (
cod_mensagem VARCHAR(5) not null PRIMARY KEY,
mensagem VARCHAR(255) not null
)

ALTER TABLE T_POSTAGEM ADD FOREIGN KEY(id_produto) REFERENCES T_PRODUTO (id_produto)

ALTER TABLE info_goods.T_PESSOA 
DEFAULT CHARSET=utf8 ;

ALTER TABLE info_goods.T_PRODUTO 
DEFAULT CHARSET=utf8 ;

ALTER TABLE info_goods.T_MENSAGEM 
DEFAULT CHARSET=utf8 ;
