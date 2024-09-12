-- Criação do banco de dados
CREATE DATABASE LocadoraVeiculos;
USE LocadoraVeiculos;

-- Tabela de Usuários
CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo ENUM('cliente', 'funcionario') NOT NULL
);

-- Tabela de Clientes
CREATE TABLE Clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    habilitacao_valida BOOLEAN NOT NULL DEFAULT TRUE
);

-- Tabela de Veículos
CREATE TABLE Veiculos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(255) NOT NULL,
    placa VARCHAR(10) UNIQUE NOT NULL,
    disponibilidade BOOLEAN NOT NULL DEFAULT TRUE
);

-- Tabela de Empréstimos
CREATE TABLE Emprestimos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    veiculo_id INT,
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    pagamento ENUM('pix', 'dinheiro', 'cartao') NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES Clientes(id),
    FOREIGN KEY (veiculo_id) REFERENCES Veiculos(id)
);

-- Adicionando registros na tabela Usuarios
INSERT INTO Usuarios (email, senha, tipo) VALUES
('cliente1@example.com', 'senha123', 'cliente'),
('funcionario1@example.com', 'senha123', 'funcionario');

-- Adicionando registros na tabela Clientes
INSERT INTO Clientes (cpf, nome, telefone, habilitacao_valida) VALUES
('12345678901', 'João da Silva', '99999-9999', TRUE),
('10987654321', 'Maria Oliveira', '98888-8888', TRUE);

-- Adicionando registros na tabela Veiculos
INSERT INTO Veiculos (modelo, placa, disponibilidade) VALUES
('Fusca', 'ABC-1234', TRUE),
('Civic', 'XYZ-5678', TRUE),
('Palio', 'LMN-9012', FALSE);

-- Adicionando registros na tabela Emprestimos
INSERT INTO Emprestimos (cliente_id, veiculo_id, data_emprestimo, data_devolucao, valor, pagamento) VALUES
(1, 1, '2024-09-01', '2024-09-10', 100.00, 'pix'),
(2, 2, '2024-09-05', '2024-09-12', 150.00, 'cartao');

DELIMITER //

CREATE TRIGGER definir_data_devolucao
BEFORE INSERT ON Emprestimos
FOR EACH ROW
BEGIN
    SET NEW.data_devolucao = DATE_ADD(NEW.data_emprestimo, INTERVAL 1 MONTH);
END;

//

DELIMITER ;
ALTER TABLE Emprestimos
MODIFY valor DECIMAL(10, 2) NULL;

DELIMITER //





