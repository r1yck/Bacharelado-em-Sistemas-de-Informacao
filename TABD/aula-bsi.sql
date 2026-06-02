CREATE TABLE clientes (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100),
	email VARCHAR(100),
	cidade VARCHAR(50),
	data_cadastro DATE DEFAULT CURRENT_DATE
);

CREATE TABLE produtos (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100),
	preco DECIMAL(10,2),
	categoria VARCHAR(50)
);

CREATE TABLE pedidos (
	id SERIAL PRIMARY KEY,
	cliente_id INT REFERENCES cliente(id),
	data_pedido DATE
);

CREATE TABLE itens_pedido (
	id SERIAL PRIMARY KEY,
	pedido_id INT REFERENCES pedidos(id),
	produto_id INT REFERENCES produto(id),
	quantidade INT,
	preco_unitario DECIMAL(10,2)
);

INSERT INTO clientes (nome, email, cidade)
SELECT
  'Cliente' || i,
  'cliente' || i || '@email.com',
  CASE
    WHEN i % 4 = 0 THEN 'Salavador'
    WHEN i % 4 = 1 THEN 'Feira de Santana'
    WHEN i % 4 = 2 THEN 'Vitoria da Conquista'
    ELSE 'Ilheus'
  END
FROM generate-series(1,1000) AS s(i); 

INSERT INTO produtos (nome, preco, categoria) VALUES
('Notebook', 3500, 'Eletronicos'),
('Mouse', 50, 'Acessorios'),
('Teclado', 120, 'Acessorios'),
('Monitor', 500, 'Eletronicos'),
('Cadeira', 800, 'Moveis'),
('Mesa', 1200, 'Moveis');
