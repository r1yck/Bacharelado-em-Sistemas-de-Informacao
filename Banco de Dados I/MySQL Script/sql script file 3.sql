create database Biblioteca;
use Biblioteca;

create table Biblioteca(
Codigo VarChar(45),
Descrição VarChar(45),
Endereço Varchar(45),

primary key (Codigo)
);

create table Associado(
Matricula VarChar(45),
Nome VarChar(45),
Sexo varchar(45),

primary key (Matricula)
);

create table Autor(
Codigo VarChar(45),
Nome VarChar(45),

primary key (Codigo)
);

create table Assunto(
BCodigo VarChar(45),
Descrição VarChar(45),

primary key (BCodigo)
);

create table Livro(
ISBN VarChar(45),
Titulo VarChar(45),
BCodigo VarChar(45),
BMatricula VarChar(45),

primary key (ISBN),
foreign key (BCodigo) references Biblioteca (Codigo),
foreign key (BMatricula) references Associado (Matricula)
);

create table Cadastro(
BCodigo VarChar(45),
BMatricula VarChar(45),

primary key (BMatricula, BCodigo),
foreign key (BCodigo) references Biblioteca (Codigo),
foreign key (BMatricula) references Associado (Matricula)
);

create table Aborda(
ABCodigo VarChar(45),
BISBN VarChar(45),

primary key (ABCodigo, BISBN),
foreign key (ABCodigo) references Assunto (BCodigo),
foreign key (BISBN) references Livro (ISBN)
);

create table Escreve(
ACodigo VarChar(45),
BISBN VarChar(45),

primary key (BISBN,ACodigo),
foreign key (ACodigo) references Autor (Codigo),
foreign key (BISBN) references Livro (ISBN)
);
