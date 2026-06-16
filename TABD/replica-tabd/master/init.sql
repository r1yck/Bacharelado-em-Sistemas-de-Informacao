CREATE ROLE replicador WITH REPLICATION LOGIN PASSWORD 'replica123';

CREATE TABLE alunos (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100),
	curso VARCHAR(100)
);

INSERT INTO alunos (nome, curso)
VALUES
('Oliver', 'adm'),
('Felicity', 'bsi'),
('Tommy', 'ads');
