create database Farmacia;
use Farmacia;

create table medicamento (
nomeVenda varchar(45),
principioAtivo varchar(45),

primary key (nomeVenda)
);

create table virus (
nomeCientifico varchar(45),
nomePopular varchar(45),

primary key (nomeCientifico)
);

create table paciente (
idPaciente int auto_increment,
nome varchar(45),

primary key (idPaciente)
);

create table trata (
nomeVenda varchar(45),
nomeCientifico varchar(45),
idPaciente int,

primary key (nomeVenda, nomeCientifico, idPaciente),
foreign key (nomeVenda) references medicamento (nomeVenda),
foreign key (nomeCientifico) references virus (nomeCientifico),
foreign key (idPaciente) references paciente (idPaciente)
);
