CREATE TABLE categoria (
	codigo VARCHAR(255) PRIMARY KEY,
	nome VARCHAR(50) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO categoria (codigo, nome) values ('09375c32-e70c-464c-a8c4-ec5ededb0d0f', 'Tecnologia');
INSERT INTO categoria (codigo, nome) values ('a8ec09fd-1ae4-407b-bd9f-1b34655e5c83', 'Acessórios para veículos');
INSERT INTO categoria (codigo, nome) values ('8cf9d614-4c59-4169-b4ab-83bb7182fbf1', 'Esporte e Lazer');
INSERT INTO categoria (codigo, nome) values ('4c1597f6-be67-434e-a065-6ea622eecd29', 'Casa e Eletrodomésticos');
INSERT INTO categoria (codigo, nome) values ('1b7e53c4-40cb-43ba-9f05-23e8da99cfff', 'Joias e Relógios');