create database faculdade2;

create table faculdades(
id_faculdade int primary key,
nome varchar(65) not null,
email varchar(60),
localizacao varchar(80) not null,
municipio varchar(45) not null,
estado varchar(45) not null
);

insert into
faculdades(id_faculdade,nome,email,localizacao,municipio,estado)
values(11,'FATEC BAURU','f196acad@cps.sp.gov.br','Rua
Manoel Bento da Cruz, 3-30 - Centro','Bauru', 'São Paulo');
insert into
faculdades(id_faculdade,nome,email,localizacao,municipio,estado)
values(26,'ESCOLA DE ENGENHARIA DE LINS','unilins@unilins.edu.br','Avenida Nicolau Zarvos, 1925
- Jardim Aeroporto','Lins', 'São Paulo');

SELECT * FROM faculdades;