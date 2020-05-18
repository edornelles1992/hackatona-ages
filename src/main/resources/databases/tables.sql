

CREATE TABLE T_USUARIO (
id INT(20) not null AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(50) not null,
usuario VARCHAR(100),
senha VARCHAR(300) not null,
perfil INT(1) not null
)

CREATE TABLE T_ALUNO (
id INT(20) not null AUTO_INCREMENT PRIMARY KEY,
matricula VARCHAR(30) not null,
sugestao VARCHAR(50),
curso VARCHAR(50) not null,
id_curso VARCHAR(20) not null,
nome VARCHAR(50) not null,
id_time INT(20) not null
)

CREATE TABLE T_TIME (
id INT(20) not null AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(50) not null
)

CREATE TABLE T_AVALIACAO (
id INT(20) not null AUTO_INCREMENT PRIMARY KEY,
software INT(1),
processo INT(1),
pitch INT(1),
inovacao INT(1),
id_time INT(20) not null,
id_usuario INT(20) not null
)

ALTER TABLE T_ALUNO ADD FOREIGN KEY(id_time) REFERENCES T_TIME (id)
ALTER TABLE T_AVALIACAO ADD FOREIGN KEY(id_time) REFERENCES T_TIME (id)
ALTER TABLE T_AVALIACAO ADD FOREIGN KEY(id_usuario) REFERENCES T_USUARIO (id)

ALTER TABLE info_goods.T_ALUNO 
DEFAULT CHARSET=utf8 ;

ALTER TABLE info_goods.T_AVALIACAO 
DEFAULT CHARSET=utf8 ;

ALTER TABLE info_goods.T_TIME 
DEFAULT CHARSET=utf8 ;

ALTER TABLE info_goods.T_USUARIO 
DEFAULT CHARSET=utf8 ;
