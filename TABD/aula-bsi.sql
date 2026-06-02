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
