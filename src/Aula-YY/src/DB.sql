CREATE DATABASE investimentos;

USE investimentos;

CREATE TABLE aplicacoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100),
    saldo DOUBLE,
    juros DOUBLE
);

INSERT INTO aplicacoes (descricao, saldo, juros) VALUES
('Poupança', 1000.0, 0.5),
('CDB', 2000.0, 1.0),
('Tesouro Direto', 3000.0, 0.8);
