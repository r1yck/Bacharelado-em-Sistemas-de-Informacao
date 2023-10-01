progenitor(maria,jose).
progenitor(joao,jose).
progenitor(joao,ana).
progenitor(jose,julia).
progenitor(jose,iris).
progenitor(iris,jorge).
progenitor(ana,bob).

masculino(jose).
masculino(joao).
masculino(jorge).
masculino(bob).

feminino(maria).
feminino(ana).
feminino(julia).
feminino(iris).

avô(X,Y) :- masculino(X),progenitor(X,A),progenitor(A,Y).
avó(X,Y) :- feminino(X),progenitor(X,A),progenitor(A,Y).

irmão(X,Y) :- masculino(X),progenitor(A,X),progenitor(A,Y),X\==Y.
irmã(X,Y) :- feminino(X),progenitor(A,X),progenitor(A,Y),X\==Y.

tio(X,Y) :- irmão(X,A),progenitor(A,Y).
tia(X,Y) :- irmã(X,A),progenitor(A,Y).

primo(X,Y) :- irmão(A,B),progenitor(A,X),progenitor(B,Y),X\==Y.
prima(X,Y) :- irmã(A,B),progenitor(A,X),progenitor(B,Y),X\==Y.


            
            
