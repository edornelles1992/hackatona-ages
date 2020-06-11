
/* USUARIOS */
--perfil -> 1 - admin / 2 - avaliador
INSERT INTO hackatona.T_USUARIO
(id, nome, usuario, senha, perfil)
VALUES(1, 'admin', 'admin', 'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 1);

INSERT INTO hackatona.T_USUARIO
(id, nome, usuario, senha, perfil)
VALUES(2, 'avaliador1', 'avaliador1', 'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 2);

INSERT INTO hackatona.T_USUARIO
(id, nome, usuario, senha, perfil)
VALUES(3, 'avaliador2', 'avaliador2', 'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 2);

/* TIME */

INSERT INTO hackatona.T_TIME
(id, nome)
VALUES(1 ,'Azul');

INSERT INTO hackatona.T_TIME
(id, nome)
VALUES(2 ,'Verde');

INSERT INTO hackatona.T_TIME
(id, nome)
VALUES(3, 'Amarelo');

INSERT INTO hackatona.T_TIME
(id, nome)
VALUES(4, 'Preto');

/* ALUNO */
INSERT INTO hackatona.T_ALUNO
(matricula, sugestao, curso, id_time, id_curso, nome)
VALUES('134938251','Time Azul', 'Engenharia de Software', 1, '111', 'Marco Silva');

INSERT INTO hackatona.T_ALUNO
(matricula, sugestao, curso, id_time, id_curso, nome)
VALUES('624626657','Time Verde', 'Engenharia de Software', 2,  '111', 'João Pedro');

INSERT INTO hackatona.T_ALUNO
(matricula, sugestao, curso, id_time, id_curso, nome)
VALUES('568484562','Time Verde', 'Engenharia de Software', 2,  '111', 'Julia Costa');

INSERT INTO hackatona.T_ALUNO
(matricula, sugestao, curso, id_curso, nome)
VALUES('547547238','Time Azul', 'Ciência da Computação', '222', 'Marco Silva');

INSERT INTO hackatona.T_ALUNO
(matricula, curso, id_curso, nome)
VALUES('987567535', 'Sistemas de Informação', '333', 'Mariana Castro');

INSERT INTO hackatona.T_ALUNO
(matricula, sugestao, curso, id_time, id_curso, nome)
VALUES('166879988','Time Azul', 'Engenharia de Computação', 1, '444', 'Paulo Manoel');

INSERT INTO hackatona.T_ALUNO
(matricula, curso, id_curso, nome)
VALUES('546546456', 'Engenharia de Computação', '444', 'Ramiro Costa');

/* AVALIACAO */
INSERT INTO hackatona.T_AVALIACAO
(software, processo, pitch, inovacao, id_usuario, id_time)
VALUES(3, 4, 2, 4, 2, 1);

INSERT INTO hackatona.T_AVALIACAO
(software, processo, pitch, inovacao, id_usuario, id_time)
VALUES(3, 4, 2, 4, 2, 2);

INSERT INTO hackatona.T_AVALIACAO
(software, processo, pitch, inovacao, id_usuario, id_time)
VALUES(3, 4, 2, 4, 3, 1);

/* AJUSTE IDS TABELAS */
ALTER TABLE hackatona.t_aluno CHANGE id id_aluno int auto_increment NOT NULL;
ALTER TABLE hackatona.t_avaliacao CHANGE id id_avaliacao int auto_increment NOT NULL;
ALTER TABLE hackatona.t_time CHANGE id_time id_time int auto_increment NOT NULL;
ALTER TABLE hackatona.t_usuario CHANGE id id_usuario int auto_increment NOT NULL;
