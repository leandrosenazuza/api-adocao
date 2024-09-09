CREATE TABLE Animal (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nome VARCHAR(255) NOT NULL,
                        raca VARCHAR(255) NOT NULL,
                        idade DOUBLE NOT NULL
);

INSERT INTO Animal (nome, raca, idade) VALUES ('Rex', 'Cachorro', 5.0);
INSERT INTO Animal (nome, raca, idade) VALUES ('Miau', 'Gato', 3.0);
INSERT INTO Animal (nome, raca, idade) VALUES ('Pássaro', 'Pássaro', 2.0);