-- Criação da tabela Animal
CREATE TABLE Animal (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nome VARCHAR(255) NOT NULL,
                        idade DOUBLE NOT NULL,
                        porte VARCHAR(255),
                        raca VARCHAR(255),
                        especie VARCHAR(255),
                        comportamento VARCHAR(255),
                        isCastrado BOOLEAN NOT NULL,
                        isVermifugado BOOLEAN NOT NULL,
                        isVacinado BOOLEAN NOT NULL,
                        isCirurgia BOOLEAN NOT NULL,
                        descricaoCirurgia VARCHAR(255),
                        descricaoAnimal VARCHAR(255),
                        foto VARCHAR(255)
);
-- Inserção de dados na tabela Animal

INSERT INTO Animal (nome, idade, porte, raca, especie, comportamento, isCastrado, isVermifugado, isVacinado, isCirurgia, descricaoCirurgia, descricaoAnimal, foto)
VALUES
    ('Rex', 5.0, 'Grande', 'Labrador', 'Canino', 'Amigável', TRUE, TRUE, TRUE, FALSE, NULL, 'Um cachorro amigável e energético.', 'rex.jpg'),
    ('Miau', 3.0, 'Pequeno', 'Siamês', 'Felino', 'Independente', FALSE, TRUE, TRUE, TRUE, 'Cirurgia de castração realizada', 'Um gato independente e curioso.', 'miau.jpg'),
    ('Pipoca', 2.0, 'Médio', 'Beagle', 'Canino', 'Brincalhão', TRUE, TRUE, FALSE, FALSE, NULL, 'Um cachorro brincalhão e carinhoso.', 'pipoca.jpg');ipoca', 2.0, 'Médio', 'Beagle', 'Canino', 'Brincalhão', TRUE, TRUE, FALSE, FALSE, NULL, 'Um cachorro brincalhão e carinhoso.', 'pipoca.jpg');imal (nome, raca, idade) VALUES ('Pássaro', 'Pássaro', 2.0);