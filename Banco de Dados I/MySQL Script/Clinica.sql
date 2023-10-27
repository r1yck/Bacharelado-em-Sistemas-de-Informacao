create database clinica;

use clinica;

create table Ambulatorio(
 cdAmb int auto_increment, 
 andar numeric(3) not null,
 capacidade smallint,
 primary key (cdAmb)
 );
 
 create table Medico(
 cdMed int auto_increment,
 nome varchar(40) not null,
 idade smallint not null,
 especialidade char(20), 
 CPF numeric(11) unique not null,
 cidade varchar(30),
 cdAmb int,
 primary key (cdMed),
 foreign key (cdAmb) references Ambulatorio (cdAmb)
 );

create table Paciente(
cdPac int auto_increment,
nome varchar(40) not null,
idade smallint not null,
cidade char(30),
CPF numeric(11) unique,
doenca varchar(40) not null,
primary key (cdPac)
);

CREATE TABLE Funcionario(
  cdFunc int auto_increment primary key,
  nome varchar(40) not null, 
  idade smallint, 
  CPF numeric(11) unique,
  cidade varchar(30), 
  salario float,
  cargo varchar(20),
  cdAmb int not null,
  foreign key(cdAmb) references Ambulatorio(cdAmb)
);

create table Consulta(

  cdCons int primary key,
  cdMed int, 
  cdPac int,
  cdFunc_Marcacao int,
  data date, 
  hora time, 
  Obs varchar(100),
  foreign key (cdMed) references Medico(cdMed),
  foreign key (cdPac) references Paciente(cdPac),
  foreign key (cdFunc_Marcacao) references Funcionario(cdFunc)
);


INSERT INTO Ambulatorio (andar, capacidade) VALUES
(1, 30),
(1, 30),
(2, 50),
(2, 50),
(2, 15);

INSERT INTO Medico (nome, idade, especialidade, CPF, cidade, cdAmb) VALUES
('Joao', 40, 'ortopedia', 10000100000, 'Salvador', 1),
('Maria', 42, 'ortopedia', 10000110000, 'Salvador', 1),
('Pedro', 51, 'pediatria', 11000100000, 'Conquista', 2),
('Carlos', 28, 'pediatria', 11000110000, 'Itapetinga', 3),
('Marcia', 33, 'pediatria', 11000111000, 'Itapetinga', 3);

INSERT INTO Paciente (nome, idade, cidade, CPF, doenca) VALUES
('Ana', 20, 'Itapetinga', 20000200000, 'Gripe'),
('Paulo', 24, 'Conquista', 20000220000, 'Fratura'),
('Lucia', 30, 'Itapetinga', 22000200000, 'Fratura'),
('Carlos', 28, 'Itapetinga', 11000110000, 'Sarampo');

INSERT INTO Funcionario (nome, idade, cidade, salario, CPF, cdAmb) VALUES
('Rita', 32, 'Itapetinga', 1200, 20000100000, 1),
('Maria', 55, 'Conquista', 1220, 30000110000, 2),
('Caio', 45, 'Salvador', 2000, 41000100000, 3),
('Carlos', 44, 'Conquista', 1200, 51000110000, 4),
('Paula', 33, 'Salvador', 2500, 61000111000, 5);

INSERT INTO Consulta (cdCons, cdMed, cdPac, cdFunc_Marcacao, data, hora, Obs) VALUES
(1, 1, 1, 1, '2023-06-12', '19:20', 'AGENDADO'),
(2, 1, 4, 1, '2023-06-13', '13:20', 'AGENDADO'),
(3, 2, 1, 2, '2023-05-09', '13:30', 'CONFIRMADO'),
(4, 2, 2, 2, '2023-05-13', '12:30', 'CONFIRMADO'),
(5, 2, 3, 2, '2023-05-10', '15:00', 'CONFIRMADO'),
(6, 2, 4, 3, '2023-05-13', '10:00', 'CONFIRMADO'),
(7, 3, 1, 3, '2023-06-19', '11:00', 'AGENDADO'),
(8, 3, 3, 4, '2023-06-12', '12:20', 'AGENDADO'),
(9, 3, 4, 4, '2023-07-19', '13:20', 'AGENDADO'),
(10, 2, 4, 4, '2023-05-10', '19:40', 'CONFIRMADO'),
(11, 4, 4, 4, '2023-05-22', '19:20', 'CONFIRMADO');
