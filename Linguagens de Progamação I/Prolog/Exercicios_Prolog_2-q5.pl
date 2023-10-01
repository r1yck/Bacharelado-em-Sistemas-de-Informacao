codigo(1).
codigo(2).
codigo(3).

msg1(integer_overflow).
msg2(divisao_por_zero).
msg3(id_desconhecido).

traduzaum(1, Y) :- codigo(1), msg1(Y).
traduzadois(2, Y) :- codigo(2), msg2(Y).
traduzatres(3, Y) :- codigo(3), msg3(Y).