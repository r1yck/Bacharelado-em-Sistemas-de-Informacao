Drop schema if exists empresa;

create database empresa;
use empresa;

CREATE TABLE Funcionarios (
    Codigo INT PRIMARY KEY,
    PrimeiroNome VARCHAR(50),
    SegundoNome VARCHAR(50),
    UltimoNome VARCHAR(50),
    DataNasci DATE,
    CPF VARCHAR(14),
    RG VARCHAR(20),
    Endereco VARCHAR(100),
    CEP VARCHAR(10),
    Cidade VARCHAR(50),
    Fone VARCHAR(20),
    CodigoDepartamento INT,
    Funcao VARCHAR(50),
    Salario DECIMAL(10, 2)
);

CREATE TABLE Departamentos (
    Codigo INT PRIMARY KEY,
    Nome VARCHAR(100),
    Localizacao VARCHAR(100),
    CodigoFuncionarioGerente INT,
    FOREIGN KEY (CodigoFuncionarioGerente) REFERENCES Funcionarios(Codigo)
);

INSERT INTO Funcionarios (Codigo, PrimeiroNome, SegundoNome, UltimoNome, DataNasci, CPF, RG, Endereco, CEP, Cidade, Fone, CodigoDepartamento, Funcao, Salario)
VALUES
    (1, 'Joao', 'Silva', 'Santos', '1990-05-15', '123.456.789-10', '1234567', 'Rua A, 123', '12345-678', 'Sao Paulo', '(11) 98765-4321', 1, 'Analista de Vendas', 5000.00),
    (2, 'Maria', 'Oliveira', 'Sousa', '1985-10-20', '987.654.321-00', '7654321', 'Av. B, 456', '54321-876', 'Rio de Janeiro', '(21) 12345-6789', 2, 'Gerente de Marketing', 8000.00),
    (3, 'Pedro', '', 'Cruz', '1982-07-08', '456.789.123-45', '9876543', 'Rua C, 789', '98765-432', 'Salvador', '(71) 56789-0123', 1, 'Analista de Sistemas', 6000.00),
	(4, 'Carlos', 'Ferreira', 'Silva', '1980-03-25', '111.222.333-44', '9999999', 'Rua D, 456', '54321-987', 'Rio de Janeiro', '(21) 55555-5555', 2, 'Supervisor', 7000.00),
    (5, 'Rafael', 'Alves', 'Pinto', '1980-03-25', '111.222.333-44', '9999999', 'Rua D, 456', '54321-987', 'Recife', '(21) 55555-5555', 2, 'Telefonista', 5000.00);

INSERT INTO Departamentos (Codigo, Nome, Localizacao, CodigoFuncionarioGerente)
VALUES
    (1, 'Vendas', 'Andar 1', 1),
    (2, 'Marketing', 'Andar 2', 2),
    (3, 'Tecnologia', 'Andar 3', 3);