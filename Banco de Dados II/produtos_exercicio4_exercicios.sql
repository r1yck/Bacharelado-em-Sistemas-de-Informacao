-- Exercício 4 / BD II
-- Henrique Fontoura

/* 1- Utilize o script produto.sql e faça:

a) Um trigger para atualizar o estoque ao inserir um item no carrinho. */

use produto;
DELIMITER $$
CREATE TRIGGER inserir_itens AFTER INSERT
ON itens_carrinho
FOR EACH ROW
BEGIN
	UPDATE Produtos SET Estoque = Estoque - NEW.Quantidade
WHERE id_produto = NEW.id_produto;
END $$
DELIMITER ;

-- b) Um trigger para atualizar o estoque ao atualizar um item no carrinho.
DELIMITER $$
CREATE TRIGGER atualizar_itens AFTER UPDATE
ON itens_carrinho
FOR EACH ROW
BEGIN
	IF (NEW.quantidade  > OLD.quantidade) THEN
		UPDATE Produtos SET estoque = estoque  - (NEW.quantidade  - OLD.quantidade)
        WHERE id_produto = id_produto;
	ELSE
		UPDATE Produtos SET estoque = estoque + (OLD.quantidade - NEW.quantidade)
        WHERE id_produto = id_produto;
	END IF;
END $$
DELIMITER ;

SELECT * FROM PRODUTOS;
SELECT * FROM ITENS_CARRINHO;

INSERT INTO ITENS_CARRINHO VALUES (2, 1, 100, 3);

UPDATE ITENS_CARRINHO SET quantidade = 20 WHERE ID_CARRINHO = 1;


-- c) Um trigger para atualizar o estoque ao excluir um item no carrinho.
DELIMITER $$
CREATE TRIGGER excluir_itens AFTER DELETE
ON itens_carrinho
FOR EACH ROW
BEGIN
	UPDATE Produtos SET Estoque = Estoque + OLD.Quantidade
WHERE id_produto = id_produto;
END $$
DELIMITER ;

-- d) Teste os triggers fazendo as manipulações na tabela itens_carrinho.

SELECT * FROM PRODUTOS;
SELECT * FROM ITENS_CARRINHO;

INSERT INTO ITENS_CARRINHO VALUES (2, 1, 100, 3);

UPDATE ITENS_CARRINHO SET quantidade = 20 WHERE ID_CARRINHO = 1;

DELETE FROM ITENS_CARRINHO WHERE ID_CARRINHO = 2;

-- 2- Utilize o script exercicio4.sql e faça:

use exercicio4;
-- a) Trigger para baixar o estoque de um PRODUTO quando ele for vendido:
CREATE TRIGGER BaixarEstoqueVenda
AFTER INSERT ON EX2_ITEMPEDIDO
FOR EACH ROW
BEGIN
    UPDATE EX2_PRODUTO
    SET quantidade = quantidade - NEW.quantidade
    WHERE codproduto = NEW.codproduto;
END;

-- b) Trigger para criar uma requisição de REQUISICAO_COMPRA quando o estoque atingir 50% da venda mensal:
CREATE TRIGGER CriarRequisicaoCompra
AFTER UPDATE ON EX2_PRODUTO
FOR EACH ROW
BEGIN
    DECLARE quantidade_vendida_mensal INT;
    DECLARE estoque_atual INT;
    DECLARE quantidade_necessaria INT;

    -- Calcular a quantidade vendida no mês atual
    SET quantidade_vendida_mensal = (
        SELECT SUM(quantidade)
        FROM EX2_ITEMPEDIDO
        WHERE codproduto = OLD.codproduto
        AND EX2_ITEMPEDIDO.codpedido IN (
            SELECT codpedido
            FROM EX2_PEDIDO
            WHERE MONTH(datapedido) = MONTH(CURDATE())
            AND YEAR(datapedido) = YEAR(CURDATE())
        )
    );

    -- Calcular a quantidade necessária para a requisição
    SET estoque_atual = OLD.quantidade;
    SET quantidade_necessaria = quantidade_vendida_mensal * 0.5;

    IF estoque_atual <= quantidade_necessaria THEN
        INSERT INTO EX2_REQUISICAO_COMPRA (codproduto, data, quantidade)
        VALUES (OLD.codproduto, CURDATE(), quantidade_necessaria - estoque_atual);
    END IF;
END;

-- c) Trigger para NÃO deixar valores negativos serem inseridos em EX2_ITEMPEDIDO:
CREATE TRIGGER VerificarValorItemPedido
BEFORE INSERT ON EX2_ITEMPEDIDO
FOR EACH ROW
BEGIN
    IF NEW.valorunitario < 0 THEN
        SET NEW.valorunitario = 0;
    END IF;
END;

-- d)  Trigger que NÃO permita que uma EX2_CLIENTE com data de nascimento anterior à data de hoje seja inserida ou atualizada:
CREATE TRIGGER VerificarDataNascimentoCliente
BEFORE INSERT ON EX2_CLIENTE
FOR EACH ROW
BEGIN
    IF NEW.datanascimento >= CURDATE() THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Data de nascimento não pode ser igual ou posterior à data de hoje.';
    END IF;
END;

CREATE TRIGGER VerificarDataNascimentoClienteAtualizacao
BEFORE UPDATE ON EX2_CLIENTE
FOR EACH ROW
BEGIN
    IF NEW.datanascimento >= CURDATE() THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Data de nascimento não pode ser igual ou posterior à data de hoje.';
    END IF;
END;
