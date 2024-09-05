/* Views 
1 a) Cria a view ProdutosBaixoEstoque que exibe produtos com estoque abaixo de 5 unidades */
CREATE VIEW ProdutosBaixoEstoque AS
SELECT 
    ProdutoID,        -- Identificador único do produto
    NomeProduto,      -- Nome do produto
    Preco,            -- Preço do produto
    QtdeEstoque       -- Quantidade em estoque do produto
FROM 
    Produtos
WHERE 
    QtdeEstoque < 5; -- Filtro para produtos com estoque abaixo de 5 unidades

-- Consulta a view ProdutosBaixoEstoque para exibir os resultados
SELECT * FROM ProdutosBaixoEstoque;



/* 1 b) Cria a view FaturamentoMensal que exibe o faturamento total por mês */
CREATE VIEW FaturamentoMensal AS
SELECT 
    DATE_FORMAT(Data, '%Y-%m') AS MesAno,  -- Formata a data para exibir ano e mês
    SUM(Valor) AS FaturamentoTotal         -- Soma dos valores de pedidos por mês
FROM 
    Pedidos
GROUP BY 
    DATE_FORMAT(Data, '%Y-%m');            -- Agrupa os resultados por ano e mês

-- Consulta a view FaturamentoMensal para exibir os resultados
SELECT * FROM FaturamentoMensal;



/* 1 c) Cria a view PedidosUltimos30Dias que lista os pedidos realizados nos últimos 30 dias com o nome do cliente */
CREATE VIEW PedidosUltimos30Dias AS
SELECT 
    p.Numero,           -- Número do pedido
    p.Data,             -- Data do pedido
    p.Valor,            -- Valor do pedido
    c.NomeCliente       -- Nome do cliente que fez o pedido
FROM 
    Pedidos p
JOIN 
    Clientes c ON p.ClienteID = c.ClienteID  -- Junta com a tabela Clientes para obter o nome do cliente
WHERE 
    p.Data >= CURDATE() - INTERVAL 30 DAY;   -- Filtro para pedidos feitos nos últimos 30 dias

-- Consulta a view PedidosUltimos30Dias para exibir os resultados
SELECT * FROM PedidosUltimos30Dias;



/* 1 d) Cria a tabela ItensPedido para armazenar detalhes dos itens em cada pedido */
CREATE TABLE ItensPedido (
    ItemID INT AUTO_INCREMENT PRIMARY KEY,    -- Identificador único do item no pedido
    PedidoNumero INT,                        -- Número do pedido ao qual o item pertence
    ProdutoID INT,                           -- Identificador do produto
    Quantidade INT,                          -- Quantidade do produto no pedido
    FOREIGN KEY (PedidoNumero) REFERENCES Pedidos(Numero), -- Chave estrangeira referenciando a tabela Pedidos
    FOREIGN KEY (ProdutoID) REFERENCES Produtos(ProdutoID)  -- Chave estrangeira referenciando a tabela Produtos
);


/* 1 d) Cria a view DetalhesPedidos que mostra os detalhes dos itens em cada pedido */
CREATE VIEW DetalhesPedidos AS
SELECT 
    i.ItemID,                      -- Identificador único do item
    p.Numero AS PedidoNumero,      -- Número do pedido
    p.Data AS DataPedido,          -- Data do pedido
    pr.NomeProduto,                -- Nome do produto
    i.Quantidade,                  -- Quantidade do produto no pedido
    pr.Preco,                      -- Preço do produto
    (i.Quantidade * pr.Preco) AS ValorTotal  -- Valor total do item (quantidade * preço)
FROM 
    ItensPedido i
JOIN 
    Pedidos p ON i.PedidoNumero = p.Numero  -- Junta com a tabela Pedidos para obter detalhes do pedido
JOIN 
    Produtos pr ON i.ProdutoID = pr.ProdutoID;  -- Junta com a tabela Produtos para obter detalhes do produto

-- Consulta a view DetalhesPedidos para exibir os resultados
SELECT * FROM DetalhesPedidos;


/* 1 e) Cria a view ClientesComAnimais que exibe o nome do cliente e dos animais associados a ele */
CREATE VIEW ClientesComAnimais AS
SELECT 
    c.NomeCliente,  -- Nome do cliente
    a.NomeAnimal    -- Nome do animal associado ao cliente
FROM 
    Clientes c
JOIN 
    Animais a ON c.ClienteID = a.ClienteID;  -- Junta com a tabela Animais para obter o nome do animal

-- Consulta a view ClientesComAnimais para exibir os resultados
SELECT * FROM ClientesComAnimais;


/* 1 f) Cria a view ProdutosAbaixoDoLimite que exibe produtos cujo estoque está abaixo de um limite definido (neste caso, 10) */
CREATE VIEW ProdutosAbaixoDoLimite AS
SELECT 
    NomeProduto,   -- Nome do produto
    QtdeEstoque,   -- Quantidade em estoque do produto
    10 AS Limite   -- Limite definido (10) para comparação
FROM 
    Produtos
WHERE 
    QtdeEstoque < 10;  -- Filtro para produtos com estoque abaixo de 10 unidades

-- Consulta a view ProdutosAbaixoDoLimite para exibir os resultados
SELECT * FROM ProdutosAbaixoDoLimite;


/* Stored Procedures 
2 a. Atualize as informações de um cliente existente */

-- Exibe todos os clientes para verificação antes da atualização
SELECT * FROM Clientes;

-- Define o delimitador para permitir a criação da stored procedure
DELIMITER $$

-- Cria a stored procedure para atualizar informações de um cliente
CREATE PROCEDURE AtualizaCliente(
    IN p_ClienteID INT,                 -- ID do cliente a ser atualizado
    IN p_NomeCliente VARCHAR(100),      -- Novo nome do cliente
    IN p_Telefone VARCHAR(15),          -- Novo telefone do cliente
    IN p_Endereco VARCHAR(255)          -- Novo endereço do cliente
)
BEGIN
    -- Atualiza os dados do cliente na tabela
    UPDATE Clientes
    SET 
        NomeCliente = p_NomeCliente,
        Telefone = p_Telefone,
        Endereco = p_Endereco
    WHERE 
        ClienteID = p_ClienteID;
END $$

-- Restaura o delimitador padrão
DELIMITER ;

-- Chama a stored procedure para atualizar o cliente com ID 1
CALL AtualizaCliente(1, 'João atualizado Silva', '11987654321', 'Rua Nova, 123');

-- Exibe todos os clientes após a atualização para verificação
SELECT * FROM Clientes;

/* 2 b. Exclua um pedido e todos os itens associados a ele */

-- Exibe todos os pedidos para verificação antes da exclusão
SELECT * FROM Pedidos;

-- Define o delimitador para permitir a criação da stored procedure
DELIMITER $$

-- Cria a stored procedure para excluir um pedido e seus itens
CREATE PROCEDURE ExcluirPedido(
    IN p_PedidoNumero INT                -- Número do pedido a ser excluído
)
BEGIN
    -- Exclui os itens associados ao pedido
    DELETE FROM ItensPedido
    WHERE PedidoNumero = p_PedidoNumero;
    
    -- Exclui o pedido da tabela Pedidos
    DELETE FROM Pedidos
    WHERE Numero = p_PedidoNumero;
END $$

-- Restaura o delimitador padrão
DELIMITER ;

-- Chama a stored procedure para excluir o pedido com número 1
CALL ExcluirPedido(1);

-- Exibe todos os pedidos após a exclusão para verificação
SELECT * FROM Pedidos;

/* 2 c. Retorne todos os animais associados a um cliente específico */

-- Define o delimitador para permitir a criação da stored procedure
DELIMITER $$

-- Cria a stored procedure para retornar animais associados a um cliente
CREATE PROCEDURE AnimaisPorCliente(
    IN p_ClienteID INT                  -- ID do cliente para buscar seus animais
)
BEGIN
    -- Seleciona todos os animais associados ao cliente especificado
    SELECT 
        NomeAnimal, 
        Tipo, 
        Idade 
    FROM 
        Animais
    WHERE 
        ClienteID = p_ClienteID;
END $$

-- Restaura o delimitador padrão
DELIMITER ;

-- Chama a stored procedure para retornar animais associados ao cliente com ID 1
CALL AnimaisPorCliente(1);

/* 2 d. Calcule o faturamento total de todos os pedidos realizados em um determinado mês */

-- Define o delimitador para permitir a criação da stored procedure
DELIMITER $$

-- Cria a stored procedure para calcular o faturamento mensal
CREATE PROCEDURE FaturamentoMensal(
    IN p_Mes INT,                       -- Mês para calcular o faturamento
    IN p_Ano INT                        -- Ano para calcular o faturamento
)
BEGIN
    -- Calcula o faturamento total para o mês e ano especificados
    SELECT 
        SUM(Valor) AS FaturamentoTotal
    FROM 
        Pedidos
    WHERE 
        MONTH(Data) = p_Mes 
        AND YEAR(Data) = p_Ano;
END $$

-- Restaura o delimitador padrão
DELIMITER ;

-- Chama a stored procedure para calcular o faturamento de agosto de 2024
CALL FaturamentoMensal(8, 2024);

/* 2 e. Insira um novo animal a partir das informações do cliente */

-- Exibe todos os clientes e animais para verificação antes da inserção
SELECT * FROM Clientes;
SELECT * FROM Animais;

-- Define o delimitador para permitir a criação da stored procedure
DELIMITER $$

-- Cria a stored procedure para inserir um novo animal
CREATE PROCEDURE InserirAnimal(
    IN p_NomeAnimal VARCHAR(100),      -- Nome do novo animal
    IN p_Tipo VARCHAR(50),             -- Tipo do novo animal
    IN p_Idade INT,                    -- Idade do novo animal
    IN p_ClienteID INT                 -- ID do cliente associado ao animal
)
BEGIN
    -- Insere um novo animal na tabela Animais
    INSERT INTO Animais (NomeAnimal, Tipo, Idade, ClienteID)
    VALUES (p_NomeAnimal, p_Tipo, p_Idade, p_ClienteID);
END $$

-- Restaura o delimitador padrão
DELIMITER ;

-- Chama a stored procedure para inserir um novo animal associado ao cliente com ID 1
CALL InserirAnimal('filho do Rex', 'Cachorro', 1, 1);

/* 2 f. Gere um relatório de vendas para um determinado período */

-- Define o delimitador para permitir a criação da stored procedure
DELIMITER $$

-- Cria a stored procedure para gerar um relatório de vendas
CREATE PROCEDURE RelatorioVendas(
    IN p_DataInicio DATE,              -- Data de início do período para o relatório
    IN p_DataFim DATE                  -- Data de fim do período para o relatório
)
BEGIN
    -- Gera o relatório de vendas para o período especificado
    SELECT 
        COUNT(*) AS NumeroDePedidos,
        SUM(Valor) AS ValorTotalVendas,
        AVG(Valor) AS MediaValorPorPedido
    FROM 
        Pedidos
    WHERE 
        Data BETWEEN p_DataInicio AND p_DataFim;
END $$

-- Restaura o delimitador padrão
DELIMITER ;

-- Chama a stored procedure para gerar o relatório de vendas de agosto de 2024
CALL RelatorioVendas('2024-08-01', '2024-08-31');


/* Triggers 
3 a) Atualize a quantidade em estoque de um produto ao inserir um pedido na tabela Pedidos */

-- Define o delimitador para permitir a criação da trigger
DELIMITER //

-- Cria a trigger para atualizar o estoque após a inserção de um pedido
CREATE TRIGGER AtualizarEstoque
AFTER INSERT ON Pedidos
FOR EACH ROW
BEGIN
    -- Atualiza a quantidade em estoque do produto
    UPDATE Produtos
    SET QtdeEstoque = QtdeEstoque - 1
    WHERE ProdutoID = NEW.ProdutoID;
END //

-- Restaura o delimitador padrão
DELIMITER ;

-- Verifica o estoque do produto com ID 1 antes da inserção
SELECT QtdeEstoque FROM Produtos WHERE ProdutoID = 1;

-- Insere um novo pedido para acionar a trigger
INSERT INTO Pedidos (ClienteID, Data, Valor, ProdutoID) VALUES (1, '2024-08-21', 89.90, 1);

/* 3 b) Atualize o valor total de um pedido ao inserir um novo pedido na tabela Pedidos */

-- Define o delimitador para permitir a criação da trigger
DELIMITER //

-- Cria a trigger para atualizar o valor total do pedido antes da inserção
CREATE TRIGGER AtualizarValorTotal
BEFORE INSERT ON Pedidos
FOR EACH ROW
BEGIN
    -- Obtém o preço do produto e atualiza o valor do pedido
    SET NEW.Valor = (SELECT Preco FROM Produtos WHERE ProdutoID = NEW.ProdutoID);
END //

-- Restaura o delimitador padrão
DELIMITER ;

-- Verifica o preço do produto com ID 2
SELECT ProdutoID, Preco FROM Produtos WHERE ProdutoID = 2;

-- Insere um novo pedido para acionar a trigger
INSERT INTO Pedidos (ClienteID, Data, Valor, ProdutoID) VALUES (2, '2024-09-02', 0, 2);

-- Verifica o valor do pedido inserido
SELECT Numero, Valor FROM Pedidos WHERE Numero = LAST_INSERT_ID();

/* 3 c) Impeça a exclusão de um cliente que tenha animais registrados */

-- Define o delimitador para permitir a criação da trigger
DELIMITER //

-- Cria a trigger para impedir a exclusão de clientes com animais registrados
CREATE TRIGGER ImpedirExclusao
BEFORE DELETE ON Clientes
FOR EACH ROW
BEGIN
    DECLARE num_animais INT;

    -- Conta o número de animais associados ao cliente
    SELECT COUNT(*) INTO num_animais FROM Animais WHERE ClienteID = OLD.ClienteID;

    -- Impede a exclusão se o cliente tiver animais registrados
    IF num_animais > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Não é possível excluir um cliente que possui animais registrados.';
    END IF;
END //

-- Restaura o delimitador padrão
DELIMITER ;

-- Insere um cliente para testar a trigger
INSERT INTO Clientes (NomeCliente, Telefone, Endereco) VALUES ('Robert Santos', '56411275438', 'Rua Z, 693');

-- Tenta excluir o cliente com ID 21 para acionar a trigger
DELETE FROM Clientes WHERE ClienteID = 21;

-- Verifica os clientes restantes
SELECT * FROM Clientes;

/* 3 d) Atualize o valor total de um pedido ao inserir um novo item na tabela ItensPedidos. */
-- Define o delimitador para permitir a criação da trigger
DELIMITER //

CREATE TRIGGER AtualizarValorPedidoAoInserirItem AFTER INSERT ON ItensPedido
FOR EACH ROW
BEGIN
    -- Atualizar o valor total do pedido após a inserção de um novo item
    UPDATE Pedidos p
    JOIN (
        SELECT PedidoNumero, SUM(Quantidade * Preco) AS NovoValorTotal
        FROM ItensPedido i
        JOIN Produtos pr ON i.ProdutoID = pr.ProdutoID
        WHERE i.PedidoNumero = NEW.PedidoNumero
        GROUP BY i.PedidoNumero
    ) AS TotalPedido ON p.Numero = TotalPedido.PedidoNumero
    SET p.Valor = TotalPedido.NovoValorTotal;
END;

//

DELIMITER ;

/* 3 e) Impeça a inserção de um pedido se o valor total for negativo */

-- Define o delimitador para permitir a criação da trigger
DELIMITER $$

-- Cria a trigger para impedir a inserção de pedidos com valor negativo
CREATE TRIGGER ImpedirInsercao
BEFORE INSERT ON Pedidos
FOR EACH ROW
BEGIN
    -- Verifica o valor do pedido
    IF NEW.Valor < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Não é possível inserir um valor negativo.';
    END IF;
END $$

-- Restaura o delimitador padrão
DELIMITER ;

-- Testa a trigger inserindo um pedido com valor negativo
INSERT INTO Pedidos (ClienteID, Data, Valor, ProdutoID) VALUES (1, '2024-09-01', -50.00, 1);

/* 3 f) Impeça a inserção de um item em um pedido se a quantidade solicitada exceder o estoque disponível. */
DELIMITER //

CREATE TRIGGER ImpedirInsercaoItemExcederEstoque BEFORE INSERT ON ItensPedido
FOR EACH ROW
BEGIN
    DECLARE estoque_atual INT;
    
    -- Verificar o estoque disponível do produto
    SELECT QtdeEstoque INTO estoque_atual FROM Produtos WHERE ProdutoID = NEW.ProdutoID;
    
    -- Se a quantidade solicitada exceder o estoque disponível, impedir a inserção
    IF NEW.Quantidade > estoque_atual THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Quantidade solicitada excede o estoque disponível.';
    END IF;
END;

//

DELIMITER ;


