create database exercicio4;
use exercicio4;

CREATE TABLE EX2_CLIENTE(
codcliente int,
nome varchar(60),
datanascimento date,
cpf varchar(11),
CONSTRAINT pk2_EX2_cliente PRIMARY KEY (codcliente)
);
CREATE TABLE EX2_PEDIDO(
codpedido int,
codcliente int,
datapedido date,
nf varchar(12),
valortotal decimal(10,2),
CONSTRAINT pk2_EX2_pedido PRIMARY KEY (codpedido),
CONSTRAINT pk2_EX2_pedido_cliente FOREIGN KEY (codcliente) REFERENCES EX2_CLIENTE(codcliente)
);
CREATE TABLE EX2_PRODUTO(
codproduto int,
descricao varchar(100),
quantidade int,
CONSTRAINT pk2_EX2_produto PRIMARY KEY (codproduto)
);
CREATE TABLE EX2_ITEMPEDIDO(
codpedido int,
numeroitem int,
valorunitario decimal(10,2),
quantidade int,
codproduto int,
CONSTRAINT pk2_itempedido PRIMARY KEY (codpedido, numeroitem),
CONSTRAINT fk2_codpedido FOREIGN KEY (codpedido) REFERENCES EX2_PEDIDO (codpedido),
CONSTRAINT fk2_itempedido_produto FOREIGN KEY (codproduto) REFERENCES EX2_PRODUTO
(codproduto)
);
CREATE TABLE EX2_LOG(
codlog int,
data date,
descricao varchar(255),
CONSTRAINT pk2_ex2_log PRIMARY KEY (codlog)
);
CREATE TABLE EX2_REQUISICAO_COMPRA(codrequisicaocompra int,
codproduto int,
data date,
quantidade int,
CONSTRAINT pk2_ex2_reqcompra PRIMARY KEY (codrequisicaocompra),
CONSTRAINT fk2_ex2_reqcompra_produto FOREIGN KEY (codproduto) REFERENCES
EX2_PRODUTO(codproduto)
);
INSERT INTO EX2_CLIENTE VALUES (1, 'Sylvio Barbon', ('1984-05-12'),
'12315541212');
INSERT INTO EX2_CLIENTE VALUES (2, 'Antonio Carlos da Silva', ('1970-01-01'),
'12313345512');
INSERT INTO EX2_CLIENTE VALUES (3, 'Thiago Ribeiro', ('1964-11-11'),
'12315544411');
INSERT INTO EX2_CLIENTE VALUES (4, 'Carlos Eduardo', ('1924-12-24'),
'42515541212');
INSERT INTO EX2_PRODUTO VALUES (1, 'Mouse', 10);
INSERT INTO EX2_PRODUTO VALUES (2, 'Teclado', 10);
INSERT INTO EX2_PRODUTO VALUES (3, 'Monitor LCD', 10);
INSERT INTO EX2_PRODUTO VALUES (4, 'Caixas Acústicas', 10);
INSERT INTO EX2_PRODUTO VALUES (5, 'Scanner de Mesa', 10);
INSERT INTO EX2_PEDIDO VALUES (1, 1, ('2012-04/01'), '00001', 400.00);
INSERT INTO EX2_ITEMPEDIDO VALUES (1, 1, 10.90, 1, 1);
INSERT INTO EX2_ITEMPEDIDO VALUES (1, 2, 389.10, 1, 3);
INSERT INTO EX2_PEDIDO VALUES (2, 2, ('2012-04-01'), '00002', 10.90);
INSERT INTO EX2_ITEMPEDIDO VALUES (2, 1, 10.90, 1, 1);
INSERT INTO EX2_PEDIDO VALUES (3, 2, ('2012-04-01'), '00003', 21.80);
INSERT INTO EX2_ITEMPEDIDO VALUES (3, 1, 10.90, 1, 1);
INSERT INTO EX2_PEDIDO VALUES (4, 3, ('2012-05-01'), '00004', 169.10);
INSERT INTO EX2_ITEMPEDIDO VALUES (4, 1, 10.90, 1, 1);
INSERT INTO EX2_ITEMPEDIDO VALUES (4, 2, 15.90, 2, 2);
INSERT INTO EX2_ITEMPEDIDO VALUES (4, 3, 25.50, 1, 4);
INSERT INTO EX2_ITEMPEDIDO VALUES (4, 4, 100.90, 1, 5);
INSERT INTO EX2_PEDIDO VALUES (5, 4, ('2012-05-01'),'00005', 100.90);
INSERT INTO EX2_ITEMPEDIDO VALUES (5, 1, 100.90, 1, 5);
