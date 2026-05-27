DROP DATABASE IF EXISTS atividade1_bd;
CREATE DATABASE atividade1_bd;
USE atividade1_bd;

-- ESTRUTURA DO BANCO (DDL)

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARBINARY(255) -- VARBINARY para receber o CPF criptografado depois
);

CREATE TABLE fornecedores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(18) NOT NULL UNIQUE
);

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    qtd_estoque INT NOT NULL
);

CREATE TABLE vendas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    data_venda TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor_total_venda DECIMAL(10,2) DEFAULT 0,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE itens_venda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    venda_id INT,
    produto_id INT,
    quantidade INT NOT NULL,
    preco_unitario_no_momento DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (venda_id) REFERENCES vendas(id),
    FOREIGN KEY (produto_id) REFERENCES produtos(id)
);

CREATE TABLE compras (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fornecedor_id INT,
    data_compra TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor_total_compra DECIMAL(10,2) DEFAULT 0,
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedores(id)
);

CREATE TABLE itens_compra (
    id INT AUTO_INCREMENT PRIMARY KEY,
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

-- Compras de estoque
INSERT INTO compras (fornecedor_id) VALUES (1), (3);

INSERT INTO itens_compra (compra_id, produto_id, quantidade, preco_custo_no_momento) VALUES
(1, 1, 200, 4.20),
(1, 2, 150, 6.00),
(2, 3, 100, 12.50);

-- Vendas (Cabeçalhos)
-- Rick (ID 1) com 6 vendas para o teste do HAVING > 5
INSERT INTO vendas (cliente_id) VALUES (1), (1), (1), (1), (1), (1);
-- Daniel (ID 2) com 7 vendas
INSERT INTO vendas (cliente_id) VALUES (2), (2), (2), (2), (2), (2), (2);
-- Maria (ID 3) com 2 vendas
INSERT INTO vendas (cliente_id) VALUES (3), (3);

-- Itens das vendas do Rick (IDs 1 a 6)
INSERT INTO itens_venda (venda_id, produto_id, quantidade, preco_unitario_no_momento) VALUES
(1, 1, 1, 6.00),
(1, 2, 2, 8.50),
(2, 3, 1, 18.90),
(3, 4, 1, 45.00),
(4, 5, 4, 5.20),
(5, 6, 2, 9.90),
(6, 1, 2, 6.00);

-- Itens das vendas do Daniel (IDs 7 a 13)
INSERT INTO itens_venda (venda_id, produto_id, quantidade, preco_unitario_no_momento) VALUES
(7, 1, 1, 6.00),
(8, 2, 1, 8.50),
(9, 3, 1, 18.90),
(10, 4, 1, 45.00),
(11, 5, 2, 5.20),
(12, 6, 1, 9.90),
(13, 1, 3, 6.00);

-- Desativa trava de update em massa temporariamente
SET SQL_SAFE_UPDATES = 0;

-- Calcula e atualiza o valor total das tabelas de vendas e compras (Usa id > 0 para burlar o DataGrip)
UPDATE vendas v SET valor_total_venda = (
    SELECT SUM(quantidade * preco_unitario_no_momento)
    FROM itens_venda
    WHERE venda_id = v.id
) WHERE v.id > 0;

UPDATE compras c SET valor_total_compra = (
    SELECT SUM(quantidade * preco_custo_no_momento)
    FROM itens_compra
    WHERE compra_id = c.id
) WHERE c.id > 0;

SET SQL_SAFE_UPDATES = 1;

-- Regras

USE atividade1_bd;

-- Reseta roles antigas se existirem
DROP ROLE IF EXISTS 'role_aluno', 'role_professor', 'role_administrador';

-- Cria as Roles
CREATE ROLE 'role_aluno', 'role_professor', 'role_administrador';

-- Garante os privilégios de cada role
GRANT ALL PRIVILEGES ON atividade1_bd.* TO 'role_administrador'; -- Admin total
GRANT SELECT, INSERT, UPDATE, DELETE ON atividade1_bd.* TO 'role_professor'; -- Professor (DML)
GRANT SELECT ON atividade1_bd.* TO 'role_aluno'; -- Aluno (Só leitura)

-- Reseta usuários antigos se existirem
DROP USER IF EXISTS 'henrique_aluno'@'%', 'fabio_prof'@'%', 'admin'@'%';

-- Cria os usuários do projeto
CREATE USER 'henrique_aluno'@'%' IDENTIFIED BY 'henrique123';
CREATE USER 'fabio_prof'@'%' IDENTIFIED BY 'fabio123';
CREATE USER 'admin'@'%' IDENTIFIED BY 'admin123!';

-- Atribui as roles aos respectivos usuários
GRANT 'role_aluno' TO 'henrique_aluno'@'%';
GRANT 'role_professor' TO 'fabio_prof'@'%';
GRANT 'role_administrador' TO 'admin'@'%';

-- Força o MySQL a ativar as roles direto no login
SET DEFAULT ROLE ALL TO 'henrique_aluno'@'%', 'fabio_prof'@'%', 'admin'@'%';

-- Requisito de TLS/SSL: Obriga o usuário admin a conectar com criptografia
ALTER USER 'admin'@'%' REQUIRE SSL;

-- Criptografia AES no CPF do Rick
UPDATE clientes
SET cpf = AES_ENCRYPT('123.456.789-12', 'chave123')
WHERE nome = 'Rick';

-- Atualiza as permissões do banco
FLUSH PRIVILEGES;