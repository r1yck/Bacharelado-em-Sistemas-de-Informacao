create database Empresa;
use Empresa;

create table Empregado(
pnome VarChar(45),
minicial VarChar(45),
unome Varchar(45),
ssn int auto_increment,
datanasc date,
endereço varchar(100),
sexo varchar(45),
salario float,
dnumero int,
superssn int,

primary key (ssn),
foreign key (superssn) references Empregado (ssn)
);

create table Departamento(
dnome VarChar(45),
dnumero int auto_increment,
gerssn int,
gerdatainicio date,

primary key (dnumero),
foreign key (gerssn) references Empregado (ssn)
);

create table Depto_localizacoes(
dnumro int,
dlocalizacao VarChar(45),

primary key (dnumro, dlocalizacao),
foreign key (dnumro) references Departamento (dnumero)
);

create table Projeto(
pjnome VarChar(45),
pnumero int auto_increment,
plocalizacao varchar(45),
dnum int,

primary key (pnumero),
foreign key (dnum) references Departamento (dnumero)
);

create table Trabalha_em(
essn int auto_increment,
pn int,
horas int,

primary key (essn, pn),
foreign key (essn) references Empregado (ssn),
foreign key (pn) references Projeto (pnumero)
);

create table Dependente(
essn int,
nome_dependente VarChar(45),
sexo varchar(45),
datanasc date,
parentesco varchar(45),

primary key (essn, nome_dependente),
foreign key (essn) references Empregado (ssn)
);
