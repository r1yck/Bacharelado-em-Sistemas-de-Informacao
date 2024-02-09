-- 1
SELECT PrimeiroNome, UltimoNome
FROM Funcionarios
ORDER BY UltimoNome;

-- 2
SELECT *
FROM Funcionarios
ORDER BY Cidade;

-- 3
SELECT *
FROM Funcionarios
WHERE Salario > 1000.00
ORDER BY PrimeiroNome, UltimoNome;

-- 4
SELECT DataNasci, PrimeiroNome
FROM Funcionarios
ORDER BY DataNasci DESC;

-- 5
SELECT UltimoNome, PrimeiroNome, SegundoNome
FROM Funcionarios
ORDER BY UltimoNome, PrimeiroNome, SegundoNome;

-- 6
SELECT SUM(Salario) AS TotalFolhaPagamento
FROM Funcionarios;

-- 7
SELECT f.PrimeiroNome, f.UltimoNome, d.Nome AS Departamento, f.Funcao
FROM Funcionarios f
INNER JOIN Departamentos d ON f.CodigoDepartamento = d.Codigo
ORDER BY f.PrimeiroNome, f.UltimoNome;

-- 8
SELECT d.Nome AS Departamento, CONCAT(f.PrimeiroNome, ' ', f.UltimoNome) AS Gerente
FROM Departamentos d
INNER JOIN Funcionarios f ON d.CodigoFuncionarioGerente = f.Codigo
ORDER BY Departamento;

-- 9
SELECT d.Nome AS Departamento, SUM(f.Salario) AS TotalFolhaPagamento
FROM Funcionarios f
INNER JOIN Departamentos d ON f.CodigoDepartamento = d.Codigo
GROUP BY d.Nome;

-- 10
SELECT d.Nome AS Departamento, f.PrimeiroNome, f.UltimoNome, f.Funcao
FROM Funcionarios f
INNER JOIN Departamentos d ON f.CodigoDepartamento = d.Codigo
WHERE f.Funcao = 'Supervisor'
ORDER BY d.Nome, f.PrimeiroNome, f.UltimoNome;

-- 11
SELECT COUNT(*) AS QuantidadeFuncionarios
FROM Funcionarios;

-- 12
SELECT AVG(Salario) AS SalarioMedio
FROM Funcionarios;

-- 13
SELECT d.Nome AS Departamento, MIN(f.Salario) AS MenorSalario
FROM Funcionarios f
INNER JOIN Departamentos d ON f.CodigoDepartamento = d.Codigo
GROUP BY d.Nome;

-- 14
SELECT CONCAT(PrimeiroNome, ' ', UltimoNome) AS NomeCompleto
FROM Funcionarios
WHERE SegundoNome IS NULL OR SegundoNome = '';

-- 15
SELECT d.Nome AS Departamento, CONCAT(f.PrimeiroNome, ' ', f.UltimoNome) AS Funcionario
FROM Funcionarios f
INNER JOIN Departamentos d ON f.CodigoDepartamento = d.Codigo
ORDER BY Departamento, Funcionario;

-- 16
SELECT CONCAT(PrimeiroNome, ' ', UltimoNome) AS NomeFuncionario
FROM Funcionarios
WHERE Cidade = 'Recife' AND Funcao = 'Telefonista';






