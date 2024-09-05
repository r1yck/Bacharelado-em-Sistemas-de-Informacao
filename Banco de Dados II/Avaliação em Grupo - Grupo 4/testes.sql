-- Testes para as Views

/*1 a) Exiba os produtos com baixo estoque (baixo de 5)*/
SELECT * FROM ProdutosBaixoEstoque;

/*1 b) Exiba o faturamento total por mês*/
SELECT * FROM FaturamentoMensal;

/*1 c) Liste os pedidos realizados nos últimos 30 dias, incluindo o nome do cliente*/
SELECT * FROM PedidosUltimos30Dias;

/*1 d) Mostra os detalhes dos itens em cada pedido, incluindo o nome do produto e a quantidade*/
SELECT * FROM DetalhesPedidos;

/*1 e) Exibe o nome do cliente e dos animais associados a ele*/
SELECT * FROM ClientesComAnimais;

/*1 f) Exiba produtos cujo estoque está abaixo de um determinado limite, mostrando o nome do produto, a quantidade em estoque e o limite*/
SELECT * FROM ProdutosAbaixoDoLimite;

-- Testes para as Stored Procedures

/*2 a) Atualize as informações de um cliente existente*/
CALL AtualizaCliente(1, 'João atualizado Silva', '11987654321', 'Rua Nova, 123');
SELECT * FROM Clientes;

/*2 b) Exclua um pedido e todos os itens associados a ele*/
CALL ExcluirPedido(1);
SELECT * FROM Pedidos;

/*2 c) Retorne todos os animais associados a um cliente específico*/
CALL AnimaisPorCliente(1);

/*2 d) Calcule o faturamento total de todos os pedidos realizados em um determinado mês*/
CALL FaturamentoMensal(8, 2024);

/*2 e) Insira um novo animal a partir das informações do cliente*/
CALL InserirAnimal('filho do Rex', 'Cachorro', 1, 1);
SELECT * FROM Animais;

/*2 f) Gere um relatório de vendas para um determinado período*/
CALL RelatorioVendas('2024-08-01', '2024-08-31');

-- Testes para as Triggers

/*3 a) Atualize a quantidade em estoque de um produto ao inserir um pedido na tabela Pedidos*/
SELECT QtdeEstoque FROM Produtos WHERE ProdutoID = 1;
INSERT INTO Pedidos (ClienteID, Data, Valor, ProdutoID) VALUES (1, '2024-08-21', 89.90, 1);
SELECT QtdeEstoque FROM Produtos WHERE ProdutoID = 1;

/*3 b) Atualize o valor total de um pedido ao inserir um novo pedido na tabela*/
SELECT ProdutoID, Preco FROM Produtos WHERE ProdutoID = 2;
INSERT INTO Pedidos (ClienteID, Data, Valor, ProdutoID) VALUES (2, '2024-09-02', 0, 2);
SELECT Numero, Valor FROM Pedidos WHERE Numero = LAST_INSERT_ID();

/*3 c) Impeça a exclusão de um cliente que tenha animais registrados*/
INSERT INTO Clientes (NomeCliente, Telefone, Endereco) VALUES ('Robert Santos', '56411275438', 'Rua Z, 693');
DELETE FROM Clientes WHERE ClienteID = 21;
SELECT * FROM Clientes;

/*3 d) Atualize o valor total de um pedido ao inserir um novo item na tabela ItensPedidos. */
-- Verifique se o pedido número 1 já existe; caso contrário, insira um novo pedido
INSERT INTO Pedidos (Numero, ClienteID, Data, Valor) 
VALUES (1, 1, '2024-08-21', 0)
ON DUPLICATE KEY UPDATE Numero = Numero;
-- Inserir um novo item no pedido
INSERT INTO ItensPedido (PedidoNumero, ProdutoID, Quantidade) VALUES (1, 1, 2);

/*3 e) Impeça a inserção de um pedido se o valor total for negativo*/
INSERT INTO Pedidos (ClienteID, Data, Valor, ProdutoID) VALUES (1, '2024-09-01', -50.00, 1);

/*3 f) Impeça a inserção de um item em um pedido se a quantidade solicitada exceder o estoque disponível.*/
INSERT INTO ItensPedido (PedidoNumero, ProdutoID, Quantidade) VALUES (1, 1, 100);

