create database Faculdade;
use Faculdade;

create table Aluno(
matricula int,
nome VarChar(45),
curso varchar(45),
tipo varchar(45),

primary key (matricula)
);

create table Disciplina(
dnumero int auto_increment,
nome varchar(45) not null,
carga_horaria int,
depnumero int,

primary key (dnumero)
);

create table Departamento(
nome varchar(45),
depnumero int,

primary key (depnumero)
);

create table Pre_requisito(
disciplina_dnumero int,
dnumero_pre date,

primary key (dnumero_pre, disciplina_dnumero),
foreign key (disciplina_dnumero) references Disciplina (dnumero)
);

create table Professor(
pnumero int,
nome varchar (45),
departamento_depnumero int,

primary key (pnumero),
foreign key (departamento_depnumero) references Departamento (depnumero)
);

create table Turma(
tnumero int,
disciplina_dnumero int,
ano int,
semestre int,
professor_pnumero int,

primary key (tnumero, disciplina_dnumero, professor_pnumero),
foreign key (disciplina_dnumero) references Disciplina (dnumero),
foreign key (professor_pnumero) references Professor (pnumero)
);

create table Historico(
aluno_matricula int,
turma_tnumero int,
nota int,

primary key (aluno_matricula, turma_tnumero),
foreign key (aluno_matricula) references Aluno (matricula),
foreign key (turma_tnumero) references Turma (tnumero)
);
