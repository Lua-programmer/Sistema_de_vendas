CREATE TABLE categoria (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO categoria (nome) values ('Tecnologia');
INSERT INTO categoria (nome) values ('Acess�rios para ve�culos');
INSERT INTO categoria (nome) values ('Esporte e Lazer');
INSERT INTO categoria (nome) values ('Casa e Eletrodom�sticos');
INSERT INTO categoria (nome) values ('Joias e Rel�gios');