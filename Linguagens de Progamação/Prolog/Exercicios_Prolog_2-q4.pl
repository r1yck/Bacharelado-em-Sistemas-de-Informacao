passaro(tweetie).
peixe(goldie).
minhoca(molie).
gato(silvester).

gosta(passaro, minhoca).
gosta(gato, peixe).
gosta(gato, passaro).
gosta(silvester, peixe).

come(silvester, peixe).

pertence(silvester, henrique).

amigo(X, Y) :- gato(X), pertence(X, Y).
come_gosta(X, Y) :- gato(X), gosta(X, Y), come(X, Y), pertence(X, henrique).