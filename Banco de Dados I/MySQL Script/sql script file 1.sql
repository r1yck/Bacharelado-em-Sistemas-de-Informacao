create database Lojinha;
use Lojinha;

create table cliente(
nroCliente int auto_increment,
nome varchar(45),
email varchar(45),
endereço varchar(45),
cartão varchar(45),

primary key (nroCliente)
);


create table produto (
codProduto int auto_increment,
nome varchar (45),
preço float,
estoque int,

primary key (codProduto)
);


create table compra (
nroCompra int auto_increment,
refCliente int,
status varchar (45),

primary key (nroCompra),
foreign key (refCliente) references cliente (nroCliente)
);


create table item (
número int auto_increment,
refCompra int,
refProduto int,
quantidade int,

primary key (número),
foreign key (refCompra) references compra (nroCompra),
foreign key (refProduto) references produto (codProduto)
)