CREATE TABLE IF NOT EXISTS users (
    id int PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE produtos (
    id INTEGER IDENTITY PRIMARY KEY,
    codigo VARCHAR(50),
    descricao VARCHAR(255),
    quantidade INTEGER,
    preco DOUBLE
);

CREATE TABLE VENDAS (
    id INTEGER IDENTITY PRIMARY KEY,
    data DATE,
    valor DECIMAL(10, 2),
    pago BOOLEAN
);
