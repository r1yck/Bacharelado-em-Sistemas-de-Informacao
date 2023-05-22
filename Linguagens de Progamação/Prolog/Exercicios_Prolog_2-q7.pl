aluno(joao, paradigmas).
aluno(maria, paradigmas).
aluno(joel, lab2).
aluno(joel, estruturas).
frequenta(joao, feup).
frequenta(maria, feup).
frequenta(joel, ist).
professor(carlos, paradigmas).
professor(ana_paula, estruturas).
professor(pedro, lab2).
funcionario(pedro, ist).
funcionario(ana_paula, feup).
funcionario(carlos, feup).

professor_de(X, Y) :- professor(X, Z), aluno(Y, Z).
frequenta_uni(X, Y) :- professor_de(Z,X), funcionario(Z,Y); funcionário(X, Y).

colega_aluno(X, Y) :- aluno(X, Z), aluno(Y,Z),X \= Y.
colega_prof(X, Y) :- funcionario(X, Z), funcionario(Y, Z), X \= Y.

/*
a) Quem são os alunos do professor X? 
?- professor_de(X,Y).
X = carlos,
Y = joao
X = carlos,
Y = maria
X = ana_paula,
Y = joel
X = pedro,
Y = joel

b) Quem são as pessoas da universidade X? (alunos ou docentes)
?- X = joao,
Y = feup
X = maria,
Y = feup
X = joel,
Y = feup
X = joel,
Y = ist
X = pedro,
Y = ist
X = ana_paula,
Y = feup
X = carlos,
Y = feup


c) Quem é colega de quem? Se aluno: é colega se for colega de disciplina ou colega de curso ou
colega de universidade. Se professor: se for professor da mesma universidade.
?- colega_aluno(X,Y);colega_prof(X,Y).
X = joao,
Y = maria
X = maria,
Y = joao
X = ana_paula,
Y = carlos
X = carlos,
Y = ana_paula