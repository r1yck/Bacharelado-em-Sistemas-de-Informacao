CREATE DATABASE IF NOT EXISTS novaEmpresa;
USE novaEmpresa;


CREATE TABLE departamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);


CREATE TABLE funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    departamento_id INT,
    FOREIGN KEY (departamento_id) REFERENCES departamento(id)
);


CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);


CREATE TABLE fornecedor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(20) NOT NULL UNIQUE
);


INSERT INTO departamento (nome) VALUES
('Recursos Humanos'),
('TI'),
('Financeiro'),
('Marketing'),
('Vendas'),
('Jurídico'),
('Suporte'),
('Logística'),
('Produção'),
('Qualidade'),
('Compras'),
('Projetos'),
('Desenvolvimento'),
('Operações'),
('Administração'),
('Treinamento'),
('Manutenção'),
('Planejamento'),
('Pesquisa e Desenvolvimento'),
('Comunicação');


INSERT INTO funcionario (nome, salario, departamento_id) VALUES
('Ana Silva', 3500.00, 1),
('Bruno Oliveira', 4000.00, 2),
('Carla Souza', 4500.00, 3),
('Daniel Lima', 3000.00, 4),
('Eva Santos', 5000.00, 5),
('Felipe Costa', 5500.00, 6),
('Gabriela Almeida', 6000.00, 7),
('Henrique Pereira', 3500.00, 8),
('Isabela Fernandes', 3700.00, 9),
('João Almeida', 3900.00, 10),
('Karen Martins', 4100.00, 11),
('Lucas Silva', 4300.00, 12),
('Mariana Santos', 4500.00, 13),
('Nicolas Pereira', 4700.00, 14),
('Olga Oliveira', 4900.00, 15),
('Paulo Souza', 5100.00, 16),
('Quiteria Lima', 5300.00, 17),
('Roberto Costa', 5500.00, 18),
('Sofia Silva', 5700.00, 19),
('Tiago Ferreira', 5900.00, 20);


INSERT INTO cliente (nome, email) VALUES
('Júlio Almeida', 'julio.almeida@example.com'),
('Mariana Costa', 'mariana.costa@example.com'),
('Pedro Oliveira', 'pedro.oliveira@example.com'),
('Laura Santos', 'laura.santos@example.com'),
('Thiago Lima', 'thiago.lima@example.com'),
('Fernanda Almeida', 'fernanda.almeida@example.com'),
('Carlos Pereira', 'carlos.pereira@example.com'),
('Juliana Silva', 'juliana.silva@example.com'),
('Gabriel Fernandes', 'gabriel.fernandes@example.com'),
('Luciana Rocha', 'luciana.rocha@example.com'),
('Ricardo Lima', 'ricardo.lima@example.com'),
('Marcio Santos', 'marcio.santos@example.com'),
('Patricia Costa', 'patricia.costa@example.com'),
('Roberto Almeida', 'roberto.almeida@example.com'),
('André Silva', 'andre.silva@example.com'),
('Ana Paula Lima', 'ana.paula.lima@example.com'),
('Mário Ferreira', 'mario.ferreira@example.com'),
('Vanessa Oliveira', 'vanessa.oliveira@example.com'),
('Cristina Costa', 'cristina.costa@example.com'),
('Eduardo Lima', 'eduardo.lima@example.com');


INSERT INTO fornecedor (nome, cnpj) VALUES
('Fornecedor A', '12.345.678/0001-90'),
('Fornecedor B', '23.456.789/0001-91'),
('Fornecedor C', '34.567.890/0001-92'),
('Fornecedor D', '45.678.901/0001-93'),
('Fornecedor E', '56.789.012/0001-94'),
('Fornecedor F', '67.890.123/0001-95'),
('Fornecedor G', '78.901.234/0001-96'),
('Fornecedor H', '89.012.345/0001-97'),
('Fornecedor I', '90.123.456/0001-98'),
('Fornecedor J', '01.234.567/0001-99'),
('Fornecedor K', '12.345.678/0001-00'),
('Fornecedor L', '23.456.789/0001-01'),
('Fornecedor M', '34.567.890/0001-02'),
('Fornecedor N', '45.678.901/0001-03'),
('Fornecedor O', '56.789.012/0001-04'),
('Fornecedor P', '67.890.123/0001-05'),
('Fornecedor Q', '78.901.234/0001-06'),
('Fornecedor R', '89.012.345/0001-07'),
('Fornecedor S', '90.123.456/0001-08'),
('Fornecedor T', '01.234.567/0001-09');
