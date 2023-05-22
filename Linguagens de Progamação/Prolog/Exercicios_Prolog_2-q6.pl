cargo(tecnico, rogerio).
cargo(tecnico, ivone). 
cargo(engenheiro, daniel). 
cargo(engenheiro, isabel). 
cargo(engenheiro, oscar). 
cargo(engenheiro, tomas). 
cargo(engenheiro, ana). 
cargo(supervisor, luis). 
cargo(supervisor_chefe, sonia). 
cargo(secretaria_exec, laura). 
cargo(diretor, santiago). 
chefiado_por(tecnico, engenheiro). 
chefiado_por(engenheiro, supervisor). 
chefiado_por(analista, supervisor). 
chefiado_por(supervisor, supervisor_chefe). 
chefiado_por(supervisor_chefe, director). 
chefiado_por(secretaria_exec, director). 

/*
?- chefiado_por(tecnico, X), chefeido_por(X,Y).
X = engenheiro,
Y = supervisor

?- chefiado_por(tecnico, X), cargo(X,ivone), cargo(Y,Z).
false
(ivone não é engenheiro e também não tem parâmetro pra z)

?- cargo(supervisor, X); cargo(supervisor, X).
X = luis
X = luis

?- cargo(J,P), (chefiado_por(J, supervisor_chefe); chefiado_por(J, supervisor)).
J = engenheiro,
P = daniel
J = engenheiro,
P = isabel
J = engenheiro,
P = oscar
J = engenheiro,
P = tomas
J = engenheiro,
P = ana
J = supervisor,
P = luis

?- chefiado_por(P, director), not(cargo(P, carolina)).
P = supervisor_chefe
P = secretaria_exec 
*/