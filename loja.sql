CREATE DATABASE loja
GO
USE loja

GO
CREATE TABLE produto(
id			INT				NOT NULL,
nome		VARCHAR(30)		NOT NULL,
fornecedor	VARCHAR(30)		NOT NULL,
valor		DECIMAL(7,2)	NOT NULL,
descricao	VARCHAR(255)	NOT NULL
PRIMARY KEY (id)
)

GO
CREATE TABLE estoque(
idproduto	INT	NOT NULL,
quantidade	INT NOT NULL
FOREIGN KEY (idproduto) REFERENCES produto(id)
)

GO
CREATE TABLE funcionario(
login		VARCHAR(20)		NOT NULL,
senha		VARCHAR(30)		NOT NULL,
area		VARCHAR(30)		NOT NULL
PRIMARY KEY (login)
)

GO
CREATE TABLE pedido(
id				INT				NOT NULL,
valorTotal		DECIMAL(7,1)	NOT NULL,
data			VARCHAR(10)		NOT NULL
PRIMARY KEY (id)
)

GO
CREATE TABLE item(
idproduto	INT	NOT NULL,
quantidade	INT NOT NULL,
idpedido	INT NOT NULL
FOREIGN KEY (idpedido) REFERENCES pedido(id)
)

SELECT * FROM pedido
SELECT * FROM item
SELECT * FROM produto
SELECT * FROM estoque
SELECT * FROM funcionario

DELETE funcionario
DELETE produto
DELETE estoque
DELETE pedido
DELETE item