CREATE TABLE produto (
	codigo VARCHAR(255) PRIMARY KEY,
	descricao VARCHAR(100) NOT NULL,
	quantidade INTEGER NOT NULL,
	preco_custo DECIMAL(10,2) NOT NULL,
	preco_venda DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(500),
	codigo_categoria VARCHAR(255) NOT NULL,
	FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;



INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('28e6844f-9511-49da-9bf7-8501d499cd95','TV Philco 32"', 10, 500, 870, 'Tv 32 Polegadas Philco Led Hd Conv. Digital Ptv32b51d', '09375c32-e70c-464c-a8c4-ec5ededb0d0f');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('d618b08c-9ef0-431a-a7bf-dea5775cbf8f','AOC Smart TV 43"', 10, 1250, 1623.20, 'Smart Tv Led 43 Polegadas Aoc Le43s5970s Full Hd Wi-fi 2 Usb', '09375c32-e70c-464c-a8c4-ec5ededb0d0f');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('bfc5df5d-6d75-4a48-8923-c0c56b46a64e','Sansung HD TV 32"', 10, 729, 1073.36, 'Tv Led 32 Samsung Un32n4000', '09375c32-e70c-464c-a8c4-ec5ededb0d0f');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('c1d5c3ca-61ad-4238-8c85-cb6f5b3b5100','Celular Moto G7 Plus', 25, 1200.50, 1899, 'Celular Motorola Moto G7 Plus Indigo 64gb 4gb Ram Xt1965', '09375c32-e70c-464c-a8c4-ec5ededb0d0f');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('053c4e32-5e72-45f7-82cf-542619a24056','Smartphone Samsung Galaxy S9', 15, 2750, 3299, 'Smartphone Samsung Galaxy S9+ Tela 6.2 128gb 6gb De Ram', '09375c32-e70c-464c-a8c4-ec5ededb0d0f');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('52acde30-7f30-45fc-a7fb-309610540336','Piscina', 10, 500, 700, 'Piscina 10 mil listros', '8cf9d614-4c59-4169-b4ab-83bb7182fbf1');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('f747468f-68a3-4286-b64d-b28ff5dd1a64','Piscina', 10, 600, 800, 'Piscina 20 mil listros', '8cf9d614-4c59-4169-b4ab-83bb7182fbf1');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('b0d79dc7-8d9d-4b1b-9701-44b860d8f3dc','Piscina', 10, 700, 900, 'Piscina 30 mil listros', '8cf9d614-4c59-4169-b4ab-83bb7182fbf1');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('31994cb9-726e-4ba1-8dfd-899b3c43e9c6','Liquidificador 12 Veloc. 1000w', 30, 70.90, 139.90, 'Liquidificador 12 Veloc. 1000w Turbo Premium Mondial 110v', '4c1597f6-be67-434e-a065-6ea622eecd29');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('7dca3809-ecd3-4234-9e97-7cb8a0b20475','Fogão Elétrico De Mesa', 8, 60.80, 106.80, 'Fogão Elétrico De Mesa 2 Pratos 2000 Watts Agrato 220v', '4c1597f6-be67-434e-a065-6ea622eecd29');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('bbd0a2b9-b7f6-4267-b4da-1ce7efe8ccf7','Fogão 4 Bocas', 20, 280.50, 424.86, 'Fogão 4 Bocas Atlas Mônaco Com Acendimento Automático', '4c1597f6-be67-434e-a065-6ea622eecd29');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('b6414f98-8f74-4b4e-a147-2246a04f2b81','Fogão 5 Bocas', 30, 864, 1164.94, 'Fogão 5 Bocas Tripla Chama Automático Agile Glass Inox Atlas', '4c1597f6-be67-434e-a065-6ea622eecd29');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('54615559-ec93-4132-abbe-7d0e3bd83343','Cafeteira Expresso', 22, 315.90, 415.90, 'Cafeteira Expresso 15 Bar Coffee Cream 110v Mondial', '4c1597f6-be67-434e-a065-6ea622eecd29');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('bb54ddb3-5c72-4023-bb91-4ef407c5874f','Geladeira / Refrigerador Electrolux', 50, 1000, 1370, 'Geladeira / Refrigerador Electrolux 240 Litros 1 Porta Class', '4c1597f6-be67-434e-a065-6ea622eecd29');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('1248dc52-5216-4809-8744-2f82a87e961a','Relógio Technos Masculino Dourado', 35, 180, 249, 'Relógio Technos Masculino Dourado Performer - 2115laa/4c', '1b7e53c4-40cb-43ba-9f05-23e8da99cfff');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('1fc25ca8-7061-43b8-bb54-518684db1aa7','Relógio Nibosi Cronógrafo', 50, 100, 160.50, 'Relógio Nibosi Cronógrafo Fr Grátis Promoção Carnaval', '1b7e53c4-40cb-43ba-9f05-23e8da99cfff');
INSERT INTO produto (codigo, descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('5a78dad9-aeba-435a-a8f8-e71f84bbf340','Anel Maciço Ouro 18k', 60, 210, 299.90, 'Anel Solitario Maciço Ouro 18k 750 7mm Escolha A Cor', '1b7e53c4-40cb-43ba-9f05-23e8da99cfff');
