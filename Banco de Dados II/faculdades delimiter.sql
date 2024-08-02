delimiter //
create procedure faculdades_select()
begin
select * from faculdades;
end //
delimiter;

call faculdades_insert();

delimiter //
create procedure faculdades_insert(idx int, nomex varchar(65), emailx varchar(65), localizacaox varchar(65), municipiox varchar(65), municipiox varchar(65), municipiox varchar(65), estadox vrachar(65))
begin
insert into faculdades(id_faculdade, nome, email, localizacao, municipio, estado)
values (idx, nomex, emails, localizacaox, municipiox, estadox);
end //
delimiter;

call faculdades_insert(10, 'HUICODE ACADEMY', 'huicodesocial@gmail.com', 'rua dos bandeirantes', '');

delimiter //
create procedure pesquisar_faculdade(in idsearch int)
begin
select nome, email, localizacao, municipio, estado
from faculdades;
end //
delimiter;

call pesquisar_faculdade(11);




