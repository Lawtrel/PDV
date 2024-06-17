CREATE DATABASE IF NOT EXISTS pdvdb;

USE PDVDB;
CREATE TABLE IF NOT EXISTS users (
    id int PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS produtos (
    id int PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(50),
    descricao VARCHAR(255),
    quantidade INTEGER,
    preco DOUBLE
);

CREATE TABLE IF NOT EXISTS vendas (
    id int PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    valor DECIMAL(10, 2),
    pago BOOLEAN,
    forma_pagamento VARCHAR(50)
);

INSERT INTO `users`(`username`, `password`) VALUES ('lawtrel','123');
INSERT INTO `users`(`username`, `password`) VALUES ('caiq','321');
INSERT INTO `produtos`(`codigo`,`descricao`,`quantidade`,`preco`) VALUES ('1','CAFE','1','2.50');
INSERT INTO `produtos`(`codigo`,`descricao`,`quantidade`,`preco`) VALUES ('2','MONSTER','1','11');
INSERT INTO `produtos`(`codigo`,`descricao`,`quantidade`,`preco`) VALUES ('3','CACHAÇA','1','20');
INSERT INTO `produtos`(`codigo`,`descricao`,`quantidade`,`preco`) VALUES ('4','REDLABEL','1','119.90');
INSERT INTO `produtos`(`codigo`,`descricao`,`quantidade`,`preco`) VALUES ('5','FANDANGOS','1','5');
INSERT INTO `produtos`(`codigo`,`descricao`,`quantidade`,`preco`) VALUES ('6','LAYS','1','12.90');
INSERT INTO `produtos`(`codigo`,`descricao`,`quantidade`,`preco`) VALUES ('7','MALBORO','1','13.50');
INSERT INTO `produtos`(`codigo`,`descricao`,`quantidade`,`preco`) VALUES ('8','BLACK','1','19.90');