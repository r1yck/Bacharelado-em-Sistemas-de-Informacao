-- Exercício Visões
USE academia ;
 -- a)
CREATE VIEW nomeS AS
SELECT Nome, Sobrenome
FROM Pessoa_Associada;

SELECT * FROM nomeS;

-- b)
CREATE VIEW nomeSob AS
SELECT 
    CONCAT(PA.Nome, ' ', PA.Sobrenome) AS NomeCompleto,
    CONCAT(E.Logradouro, ', ', E.Numero, ', ', E.Bairro, ', CEP ', E.CEP) AS EnderecoCompleto
FROM Pessoa_Associada PA
JOIN Endereco E ON PA.Endereco_ID = E.Endereco_ID;

SELECT * FROM nomeSob;

-- c)
CREATE VIEW endC AS
SELECT Nome, Sobrenome
FROM Pessoa_Treinadora;

SELECT * FROM endC;

-- d)
CREATE VIEW tudo AS
SELECT 
    CONCAT(PA.Nome, ' ', PA.Sobrenome) AS NomeCompleto,
    CONCAT(E.Logradouro, ', ', E.Numero, ', ', E.Bairro, ', CEP ', E.CEP) AS EnderecoCompleto,
    CONCAT('Contato: ', T.Telefone_Contato, ', Emergência: ', T.Telefone_Emergencia) AS Telefones
FROM Pessoa_Associada PA
JOIN Endereco E ON PA.Endereco_ID = E.Endereco_ID
LEFT JOIN Telefone T ON PA.Telefone_ID = T.Telefone_ID;

SELECT * FROM tudo;

-- e)


-- f)


-- g)


-- h)
