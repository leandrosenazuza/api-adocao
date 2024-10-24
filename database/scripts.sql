-- Criação da tabela 'especie'
CREATE TABLE especie (
                         id BIGSERIAL PRIMARY KEY,
                         descricao_especie VARCHAR(255) NOT NULL
);

-- Inserções na tabela 'especie'
INSERT INTO especie (descricao_especie) VALUES ('Gato');
INSERT INTO especie (descricao_especie) VALUES ('Cachorro');
INSERT INTO especie (descricao_especie) VALUES ('Pássaro');

-- Criação da tabela 'porte'
CREATE TABLE porte (
                       id BIGSERIAL PRIMARY KEY,
                       descricao_porte VARCHAR(255) NOT NULL
);

-- Inserções na tabela 'porte'
INSERT INTO porte (descricao_porte) VALUES ('Pequeno');
INSERT INTO porte (descricao_porte) VALUES ('Médio');
INSERT INTO porte (descricao_porte) VALUES ('Grande');

-- Criação da tabela 'raca' (agora relacionando-se com porte e especie)
CREATE TABLE raca (
                      id BIGSERIAL PRIMARY KEY,
                      descricao_raca VARCHAR(255) NOT NULL,
                      porte_id BIGINT NOT NULL REFERENCES porte(id) ON DELETE RESTRICT,
                      especie_id BIGINT NOT NULL REFERENCES especie(id) ON DELETE RESTRICT
);

-- Inserções na tabela 'raca'
-- Labrador é um cão de porte grande
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Labrador', 3, 2);
-- Poodle é um cão de porte médio
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Poodle', 2, 2);
-- Siamês é um gato de porte pequeno
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Siamês', 1, 1);

-- Criação da tabela 'comportamento'
CREATE TABLE comportamento (
                               id BIGSERIAL PRIMARY KEY,
                               descricao_comportamento VARCHAR(255) NOT NULL
);

-- Inserções na tabela 'comportamento'
INSERT INTO comportamento (descricao_comportamento) VALUES ('Calmo');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Agitado');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Brincalhão');

-- Criação da tabela 'cirurgia'
CREATE TABLE cirurgia (
                          id BIGSERIAL PRIMARY KEY,
                          descricao_cirurgia VARCHAR(255) NOT NULL
);

-- Inserções na tabela 'cirurgia'
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Castração');
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Retirada de Tumor');
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Amputação');

-- Criação da tabela 'animal'
CREATE TABLE animal (
                        id BIGSERIAL PRIMARY KEY,
                        nome VARCHAR(255) NOT NULL,
                        idade DOUBLE PRECISION NOT NULL,
                        raca_id BIGINT REFERENCES raca(id) ON DELETE SET NULL,
                        comportamento_id BIGINT REFERENCES comportamento(id) ON DELETE SET NULL,
                        cirurgia_id BIGINT REFERENCES cirurgia(id) ON DELETE SET NULL,
                        is_castrado BOOLEAN NOT NULL,
                        is_vermifugado BOOLEAN NOT NULL,
                        is_vacinado BOOLEAN NOT NULL,
                        is_cirurgia BOOLEAN NOT NULL,
                        descricao_animal TEXT,
                        foto TEXT
);

-- Inserindo um Labrador de porte grande e espécie canina
INSERT INTO animal (nome, idade, raca_id, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Rex', 5.0, 1, 1, 1, TRUE, TRUE, TRUE, TRUE, 'Cão muito amigável e treinado', 'https://upload.wikimedia.org/wikipedia/commons/7/70/Serena_REFON.jpg');

-- Inserindo um Poodle de porte médio e espécie canina
INSERT INTO animal (nome, idade, raca_id, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Max', 3.0, 2, 2, 2, TRUE, TRUE, FALSE, FALSE, 'Cachorro agitado e brincalhão', 'https://i0.statig.com.br/bancodeimagens/78/pt/gs/78ptgsfeddfh638dkkzya5p3y.jpg');

-- Inserindo um gato Siamês de porte pequeno e espécie felina
INSERT INTO animal (nome, idade, raca_id, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Mimi', 2.0, 3, 3, NULL, TRUE, TRUE, TRUE, FALSE, 'Gato carinhoso e calmo', 'https://midias.correiobraziliense.com.br/_midias/jpg/2024/01/31/675x450/1_sgrg-34614010.jpg?20240203041551?20240203041551');
