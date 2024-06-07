CREATE TABLE IF NOT EXISTS users (
    id int PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE produtos (
    id int PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(50),
    descricao VARCHAR(255),
    quantidade INTEGER,
    preco DOUBLE
);

CREATE TABLE vendas (
    id int PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    valor DECIMAL(10, 2),
    pago BOOLEAN
);
