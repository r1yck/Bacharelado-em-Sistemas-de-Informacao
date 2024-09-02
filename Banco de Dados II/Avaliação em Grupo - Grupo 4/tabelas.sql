CREATE DATABASE Loja;
USE Loja;

CREATE TABLE Clientes (
    ClienteID INT AUTO_INCREMENT PRIMARY KEY,
    NomeCliente VARCHAR(100),
    Telefone VARCHAR(15),
    Endereco VARCHAR(255)
);

INSERT INTO Clientes (NomeCliente, Telefone, Endereco)
VALUES 
('João Silva', '11987654321', 'Rua A, 123'),
('Maria Souza', '11987654322', 'Rua B, 456'),
('Carlos Santos', '11987654323', 'Rua C, 789'),
('Ana Oliveira', '11987654324', 'Rua D, 101'),
('Pedro Lima', '11987654325', 'Rua E, 202'),
('Juliana Costa', '11987654326', 'Rua F, 303'),
('Ricardo Almeida', '11987654327', 'Rua G, 404'),
('Patrícia Farias', '11987654328', 'Rua H, 505'),
('Fernando Melo', '11987654329', 'Rua I, 606'),
('Camila Rocha', '11987654330', 'Rua J, 707'),
('André Nunes', '11987654331', 'Rua K, 808'),
('Beatriz Ramos', '11987654332', 'Rua L, 909'),
('Lucas Carvalho', '11987654333', 'Rua M, 1010'),
('Carolina Silva', '11987654334', 'Rua N, 111'),
('Rafael Martins', '11987654335', 'Rua O, 222'),
('Larissa Oliveira', '11987654336', 'Rua P, 333'),
('Bruno Costa', '11987654337', 'Rua Q, 444'),
('Tatiana Santos', '11987654338', 'Rua R, 555'),
('Marcelo Dias', '11987654339', 'Rua S, 666'),
('Fernanda Lima', '11987654340', 'Rua T, 777');


CREATE TABLE Animais (
    AnimalID INT AUTO_INCREMENT PRIMARY KEY,
    NomeAnimal VARCHAR(100),
    Tipo VARCHAR(50),
    Idade INT,
    ClienteID INT,
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID)
);

INSERT INTO Animais (NomeAnimal, Tipo, Idade, ClienteID)
VALUES 
('Rex', 'Cachorro', 5, 1),
('Mimi', 'Gato', 3, 2),
('Bob', 'Cachorro', 2, 3),
('Nina', 'Gato', 4, 4),
('Lola', 'Cachorro', 6, 5),
('Tico', 'Pássaro', 1, 6),
('Billy', 'Cachorro', 7, 7),
('Zeca', 'Gato', 2, 8),
('Daisy', 'Cachorro', 3, 9),
('Chico', 'Pássaro', 5, 10),
('Toby', 'Cachorro', 8, 11),
('Luna', 'Gato', 4, 12),
('Max', 'Cachorro', 3, 13),
('Bela', 'Gato', 1, 14),
('Fred', 'Cachorro', 5, 15),
('Lily', 'Gato', 6, 16),
('Bruno', 'Cachorro', 7, 17),
('Mia', 'Gato', 2, 18),
('Rocky', 'Cachorro', 4, 19),
('Teca', 'Gato', 3, 20);


CREATE TABLE Produtos (
    ProdutoID INT AUTO_INCREMENT PRIMARY KEY,
    NomeProduto VARCHAR(100),
    Preco DECIMAL(10, 2),
    QtdeEstoque INT
);

INSERT INTO Produtos (NomeProduto, Preco, QtdeEstoque)
VALUES 
('Ração para Cachorro', 89.90, 50),
('Ração para Gato', 79.90, 40),
('Coleira para Cachorro', 19.90, 100),
('Coleira para Gato', 15.90, 80),
('Brinquedo para Cachorro', 29.90, 30),
('Brinquedo para Gato', 24.90, 20),
('Cama para Cachorro', 99.90, 10),
('Cama para Gato', 89.90, 15),
('Comedouro para Cachorro', 34.90, 25),
('Comedouro para Gato', 29.90, 35),
('Shampoo para Cachorro', 25.90, 45),
('Shampoo para Gato', 22.90, 40),
('Areia Sanitária para Gato', 19.90, 60),
('Osso para Cachorro', 9.90, 150),
('Petiscos para Cachorro', 14.90, 70),
('Petiscos para Gato', 12.90, 65),
('Arranhador para Gato', 119.90, 5),
('Tapete Higiênico para Cachorro', 49.90, 25),
('Roupa para Cachorro', 59.90, 30),
('Roupa para Gato', 49.90, 20);


CREATE TABLE Pedidos (
    Numero INT AUTO_INCREMENT PRIMARY KEY,
    ClienteID INT,
    Data DATE,
    Valor DECIMAL(10, 2),
    ProdutoID INT,
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID),
    FOREIGN KEY (ProdutoID) REFERENCES Produtos(ProdutoID)
);

INSERT INTO Pedidos (ClienteID, Data, Valor, ProdutoID)
VALUES 
(1, '2024-08-20', 89.90, 1),
(2, '2024-08-21', 79.90, 2),
(3, '2024-08-22', 19.90, 3),
(4, '2024-08-23', 15.90, 4),
(5, '2024-08-24', 29.90, 5),
(6, '2024-08-25', 24.90, 6),
(7, '2024-08-26', 99.90, 7),
(8, '2024-08-27', 89.90, 8),
(9, '2024-08-28', 34.90, 9),
(10, '2024-08-20', 29.90, 10),
(11, '2024-08-21', 25.90, 11),
(12, '2024-08-22', 22.90, 12),
(13, '2024-08-23', 19.90, 13),
(14, '2024-08-24', 9.90, 14),
(15, '2024-08-25', 14.90, 15),
(16, '2024-08-26', 12.90, 16),
(17, '2024-08-27', 119.90, 17),
(18, '2024-08-28', 49.90, 18),
(19, '2024-08-20', 59.90, 19),
(20, '2024-08-21', 49.90, 20);
