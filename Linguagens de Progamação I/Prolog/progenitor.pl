progenitor(sara,isaque).
progenitor(abraao,isaque).
progenitor(abraao,ismael).
progenitor(isaque,esaú).
progenitor(isaque,jacó).
progenitor(jacó,josé).

masculino(abraao).
feminino(sara).


pai(A,B) :- progenitor(A,B),masculino(A).
mae(A,B) :- progenitor(A,B),feminino(A).

