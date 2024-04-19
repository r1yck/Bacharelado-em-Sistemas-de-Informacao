-- Exercício Visões
USE academia ;

 -- a) Uma view chamada nomeS que exiba o nome e sobrenome das pessoas associadas.
CREATE VIEW nomeS AS
SELECT Nome, Sobrenome
FROM Pessoa_Associada;

SELECT * FROM nomeS;

-- b) Uma view chamada nomeSob que exiba o endereço completo.
CREATE VIEW nomeSob AS
SELECT 
    CONCAT(PA.Nome, ' ', PA.Sobrenome) AS NomeCompleto,
    CONCAT(E.Logradouro, ', ', E.Numero, ', ', E.Bairro, ', CEP ', E.CEP) AS EnderecoCompleto
FROM Pessoa_Associada PA
INNER JOIN Endereco E ON PA.Endereco_ID = E.Endereco_ID;

SELECT * FROM nomeSob;

-- c) Uma view chamada endC que exiba o nome e sobrenome das pessoas treinadoras.
CREATE VIEW endC AS
SELECT Nome, Sobrenome
FROM Pessoa_Treinadora;

SELECT * FROM endC;

-- d) Uma view chamada tudo que exiba o nome completo, endereço completo e informações de contato (telefone) das pessoas associadas.
CREATE VIEW tudo AS
SELECT 
    CONCAT(PA.Nome, ' ', PA.Sobrenome) AS NomeCompleto,
    CONCAT(E.Logradouro, ', ', E.Numero, ', ', E.Bairro, ', CEP ', E.CEP) AS EnderecoCompleto,
    CONCAT('Contato: ', T.Telefone_Contato, ', Emergência: ', T.Telefone_Emergencia) AS Telefones
FROM Pessoa_Associada PA
INNER JOIN Endereco E ON PA.Endereco_ID = E.Endereco_ID
INNER JOIN Telefone T ON PA.Telefone_ID = T.Telefone_ID;

SELECT * FROM tudo;

-- e) Uma view chamada modal que exiba o nome dos associados, modalidade praticada e nome dos respectivos treinadores.
CREATE VIEW modal AS
SELECT pa.Nome AS Nome_Associado, m.Nome_modalidade AS Modalidade, pt.Nome AS Nome_Treinador
FROM Pessoa_Associada AS pa
INNER JOIN Treino AS t ON pa.Pessoa_Associada_ID = t.Pessoa_Associada_ID
INNER JOIN Modalidade AS m ON t.Modalidade_ID = m.Modalidade_ID
INNER JOIN Pessoa_Treinadora AS pt ON t.Horario_ID = pt.Pessoa_Treinadora_ID;

SELECT * FROM tudo;

-- f) Uma view chamada turno que exiba o nome completo, endereço completo, modalidade e horário de treino dos associados cujos nomes começam com a letra 'A'.
CREATE VIEW turno AS
SELECT CONCAT(pa.Nome, ' ', pa.Sobrenome) AS Nome_Completo, CONCAT(e.Logradouro, ', ', e.Numero, ' - ', e.Bairro) AS Endereco_Completo, m.Nome_modalidade AS Modalidade, h.Periodo AS Horario
FROM Pessoa_Associada AS pa
INNER JOIN Treino AS t ON pa.Pessoa_Associada_ID = t.Pessoa_Associada_ID
INNER JOIN Modalidade AS m ON t.Modalidade_ID = m.Modalidade_ID
INNER JOIN Horario AS h ON t.Horario_ID = h.Horario_ID
INNER JOIN Endereco AS e ON pa.Endereco_ID = e.Endereco_ID
WHERE pa.Nome LIKE 'A%';

SELECT * FROM turno;

-- g) Uma view chamada valor que exiba o nome completo, endereço completo, nome do plano, modalidade e valor pago pelas pessoas associadas cujos nomes contenham a letra 'S'.
CREATE VIEW valor AS
SELECT CONCAT(pa.Nome, ' ', pa.Sobrenome) AS Nome_Completo, CONCAT(e.Logradouro, ', ', e.Numero, ' - ', e.Bairro) AS Endereco_Completo, pl.Nome_plano AS Plano, m.Nome_modalidade AS Modalidade, pl.Valor AS Valor_Pago
FROM Pessoa_Associada AS pa
INNER JOIN Plano AS pl ON pa.Plano_ID = pl.Plano_ID
INNER JOIN Treino AS t ON pa.Pessoa_Associada_ID = t.Pessoa_Associada_ID
INNER JOIN Modalidade AS m ON t.Modalidade_ID = m.Modalidade_ID
INNER JOIN Endereco AS e ON pa.Endereco_ID = e.Endereco_ID
WHERE pa.Nome LIKE '%S%';

SELECT * FROM valor;

-- h) Uma view chamada gasto que calcule o valor médio gasto pelos associados.
CREATE VIEW gasto AS
SELECT 
     ROUND(AVG(Valor),2) AS Valor_Medio_Gasto
FROM Pessoa_Associada AS pa
      INNER JOIN Plano AS pl ON pa.Plano_ID = pl.Plano_ID;

SELECT * FROM gasto;
