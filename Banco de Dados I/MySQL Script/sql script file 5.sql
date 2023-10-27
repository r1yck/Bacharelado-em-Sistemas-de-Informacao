create database Teste;
use Teste;

create table if not exists Aluno(
no_cartao int,
nome VarChar(45),

primary key (no_cartao)
);

create table if not exists Sala(
num_predio int auto_increment,
num_sala int,
capacidade int,

primary key (num_predio, num_sala)
);

create table if not exists Aula(
dia date,
hora time,
sala_num_predio int,
sala_num_sala int,

primary key (dia, hora, sala_num_predio, sala_num_sala),
foreign key (sala_num_predio, sala_num_sala) references Sala (num_predio, num_sala)
);

create table if not exists Presenca(
aluno_no_cartao int,
aula_dia date,
aula_hora time,

primary key (aluno_no_cartao, aula_dia, aula_hora),
foreign key (aluno_no_cartao) references Aluno (no_cartao),
foreign key (aula_dia, aula_hora) references Aula (dia, hora)
);
