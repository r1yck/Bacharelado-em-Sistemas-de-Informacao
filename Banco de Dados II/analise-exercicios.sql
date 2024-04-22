-- Exercício 2 / BD II
-- Henrique Fontoura

-- a) A tabela original de "vendas" não está normalizada porque possui redundâncias e não segue as regras certas. 
--    A normalização arruma isso dividindo a tabela em pedaços menores e mais organizados.

-- b) Vendas (*CdVdd*, DtVen, CdVen, CdCli, CdCanalVendas, Status, Deletado)
--    Cliente (*CdCli*, NmCli, Cidade, Estado, Pais)
--    Produto (*CdPro*, NmPro, Und, VrUnt)

-- c)
SELECT estado, SUM(valor) AS total_vendas
FROM vendas
GROUP BY estado;

-- d)
SELECT produto.nome AS produto, cidade.nome AS cidade, AVG(vendas.valor) AS media_gasto
FROM vendas
JOIN produto ON vendas.produto_id = produto.id
JOIN cidade ON vendas.cidade_id = cidade.id
GROUP BY produto.nome, cidade.nome
ORDER BY cidade.nome;

-- e)
SELECT produto.nome AS produto, COUNT(*) AS qtd_vendas
FROM vendas
JOIN produto ON vendas.produto_id = produto.id
WHERE vendas.canal = 'ecommerce'
GROUP BY produto.nome
ORDER BY qtd_vendas DESC
LIMIT 1;

-- f)
SELECT *
FROM vendas
WHERE data_venda BETWEEN '2019-05-07' AND '2021-03-03';

-- g)
CREATE VIEW produto_info AS
SELECT id AS codigo, nome, tipo
FROM produto;

-- h)
CREATE VIEW vendedores_dependentes AS
SELECT vendedor.nome AS nome_vendedor, dependente.nome AS nome_dependente, dependente.parentesco
FROM vendedor
LEFT JOIN dependente ON vendedor.id = dependente.vendedor_id;

-- i)
CREATE VIEW vendas_por_canal AS
SELECT canal, COUNT(*) AS qtd_vendas
FROM vendas
GROUP BY canal;

-- j)
CREATE VIEW vendas_vendedores AS
SELECT vendas.id AS codigo_venda, vendas.data_venda, produto.nome AS nome_produto, vendedor.nome AS nome_vendedor
FROM vendas
JOIN produto ON vendas.produto_id = produto.id
JOIN vendedor ON vendas.vendedor_id = vendedor.id;

-- k)
CREATE VIEW relacao_produtos_cidades_vendedores_clientes AS
SELECT produto.nome AS produto, cidade.nome AS cidade, vendedor.nome AS vendedor, cliente.nome AS cliente
FROM vendas
JOIN produto ON vendas.produto_id = produto.id
JOIN cidade ON vendas.cidade_id = cidade.id
JOIN vendedor ON vendas.vendedor_id = vendedor.id
JOIN cliente ON vendas.cliente_id = cliente.id;
