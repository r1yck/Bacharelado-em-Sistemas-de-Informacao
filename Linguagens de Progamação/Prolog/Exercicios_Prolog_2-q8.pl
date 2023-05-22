come(abelha, polen).
come(passaro, abelha).
come(cobra, passaro).
come(raposa, cobra).

presa(Y, X) :- come(X, Y).

predador(X, Y) :- come(X, Y).