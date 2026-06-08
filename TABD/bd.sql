-- Ativa a extensão de criptografia do Postgres
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- ESTRUTURA DO BANCO (DDL)
CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf BYTEA -- BYTEA para receber o CPF criptografado depois
);

CREATE TABLE fornecedores (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(18) NOT NULL UNIQUE
);

CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    qtd_estoque INT NOT NULL
);

CREATE TABLE vendas (
    id SERIAL PRIMARY KEY,
    cliente_id INT,
    data_venda TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor_total_venda DECIMAL(10,2) DEFAULT 0,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE itens_venda (
    id SERIAL PRIMARY KEY,
    venda_id INT,
    produto_id INT,
    quantidade INT NOT NULL,
    preco_unitario_no_momento DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (venda_id) REFERENCES vendas(id),
    FOREIGN KEY (produto_id) REFERENCES produtos(id)
);

CREATE TABLE compras (
    id SERIAL PRIMARY KEY,
    fornecedor_id INT,
    data_compra TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor_total_compra DECIMAL(10,2) DEFAULT 0,
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedores(id)
);

CREATE TABLE itens_compra (
    id SERIAL PRIMARY KEY,
    compra_id INT,
    produto_id INT,
    quantidade INT NOT NULL,
    preco_custo_no_momento DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (compra_id) REFERENCES compras(id),
    FOREIGN KEY (produto_id) REFERENCES produtos(id)
);

-- INSERÇÃO DOS DADOS (DML)
INSERT INTO fornecedores (nome, cnpj) VALUES
('Atacadão Distribuidora', '12.345.678/0001-99'),
('Ambev S.A.', '03.010.987/0001-11'),
('Moinho Central', '07.441.234/0001-22');

INSERT INTO clientes (nome) VALUES
('Rick'), ('Daniel'), ('Maria'), ('Hudson'), ('Roberta');

INSERT INTO produtos (nome, preco_unitario, qtd_estoque) VALUES
('Arroz 1kg', 6.00, 100),
('Feijão Carioca 1kg', 8.50, 150),
('Café Torrado 500g', 18.90, 80),
('Azeite de Oliva 500ml', 45.00, 40),
('Leite Integral 1L', 5.20, 200),
('Chocolate Amargo 100g', 9.90, 60);

INSERT INTO compras (fornecedor_id) VALUES (1), (3);

INSERT INTO itens_compra (compra_id, produto_id, quantidade, preco_custo_no_momento) VALUES
(1, 1, 200, 4.20),
(1, 2, 150, 6.00),
(2, 3, 100, 12.50);

INSERT INTO vendas (cliente_id) VALUES (1), (1), (1), (1), (1), (1);
INSERT INTO vendas (cliente_id) VALUES (2), (2), (2), (2), (2), (2), (2);
INSERT INTO vendas (cliente_id) VALUES (3), (3);

INSERT INTO itens_venda (venda_id, produto_id, quantidade, preco_unitario_no_momento) VALUES
(1, 1, 1, 6.00), (1, 2, 2, 8.50), (2, 3, 1, 18.90),
(3, 4, 1, 45.00), (4, 5, 4, 5.20), (5, 6, 2, 9.90),
(6, 1, 2, 6.00), (7, 1, 1, 6.00), (8, 2, 1, 8.50),
(9, 3, 1, 18.90), (10, 4, 1, 45.00), (11, 5, 2, 5.20),
(12, 6, 1, 9.90), (13, 1, 3, 6.00);

-- Calcula e atualiza o valor total das tabelas de vendas e compras
UPDATE vendas v SET valor_total_venda = (
    SELECT COALESCE(SUM(quantidade * preco_unitario_no_momento), 0)
    FROM itens_venda
    WHERE venda_id = v.id
);

UPDATE compras c SET valor_total_compra = (
    SELECT COALESCE(SUM(quantidade * preco_custo_no_momento), 0)
    FROM itens_compra
    WHERE compra_id = c.id
);

-- CONTROLE DE ACESSO E SEGURANÇA (DCL)
DROP ROLE IF EXISTS role_aluno, role_professor, role_administrador;
CREATE ROLE role_aluno;
CREATE ROLE role_professor;
CREATE ROLE role_administrador;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO role_administrador;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO role_professor;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO role_aluno;

DROP USER IF EXISTS henrique_aluno, fabio_prof, admin;
CREATE USER henrique_aluno WITH PASSWORD 'henrique123';
CREATE USER fabio_prof WITH PASSWORD 'fabio123';
CREATE USER admin WITH PASSWORD 'admin123!';

GRANT role_aluno TO henrique_aluno;
GRANT role_professor TO fabio_prof;
GRANT role_administrador TO admin;

-- Criptografia no CPF do Rick (Usando pgcrypto)
UPDATE clientes
SET cpf = pgp_sym_encrypt('123.456.789-12', 'chave123')
WHERE nome = 'Rick';
