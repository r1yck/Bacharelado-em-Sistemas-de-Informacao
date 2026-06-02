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
	cliente_id INT REFERENCES clientes(id),
	data_pedido DATE
);

CREATE TABLE itens_pedido (
	id SERIAL PRIMARY KEY,
	pedido_id INT REFERENCES pedidos(id),
	produto_id INT REFERENCES produtos(id),
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
FROM generate_series(1,1000) AS s(i); 

INSERT INTO produtos (nome, preco, categoria) VALUES
('Notebook', 3500, 'Eletronicos'),
('Mouse', 50, 'Acessorios'),
('Teclado', 120, 'Acessorios'),
('Monitor', 500, 'Eletronicos'),
('Cadeira', 800, 'Moveis'),
('Mesa', 1200, 'Moveis');

INSERT INTO pedidos (cliente_id, data_pedido)
SELECT
  (random() * 999 + 1)::INT,
  CURRENT_DATE - (random() * 365)::INT
FROM generate_series(1,5000);

INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, preco_unitario)
SELECT
  (random() * 4999 + 1)::INT,
  (random() * 5 + 1)::INT,
  (random() * 5 + 1)::INT,
  (random() * 3000 + 50)::DECIMAL(10,2)
FROM generate_series(1,2000);
