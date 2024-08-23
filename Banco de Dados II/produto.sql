create database produto;
use produto;

create table produtos(
    id_produto int primary key,
    descricao_produto varchar(30),
    valor_unitario float,
    estoque float
); 

create table itens_carrinho(
    id_carrinho int,
    id_produto int,
    quantidade float,
    valor_unitario float,
    primary key (id_carrinho, id_produto),
    constraint fk_produto foreign key (id_produto) references produtos(id_produto)
);

insert into produtos values (1, 'caneta azul', 1, 300);
insert into produtos values (2, 'caneta vermelha', 1, 120);
insert into produtos values (3, 'caneta verde', 1, 115);
insert into produtos values (4, 'caneta preta', 1, 400);
insert into produtos values (5, 'lápis', 0.5, 150);
insert into produtos values (6, 'borracha', 0.4, 80);
insert into produtos values (7, 'apontador', 1.5, 50);
insert into produtos values (8, 'caderno', 22.89, 40);