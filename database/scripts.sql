-- Quando começar o projeto, executar esse script para criar as tabelas.

-- Criação da tabela 'especie'
CREATE TABLE especie (
                         id BIGSERIAL PRIMARY KEY,
                         descricao_especie VARCHAR(255) NOT NULL
);

-- Inserções na tabela 'especie'
INSERT INTO especie (id, descricao_especie) VALUES (1, 'Gato');
INSERT INTO especie (id, descricao_especie) VALUES (2, 'Cachorro');
INSERT INTO especie (id, descricao_especie) VALUES (3, 'Pássaro');

-- Criação da tabela 'porte'
CREATE TABLE porte (
                       id BIGSERIAL PRIMARY KEY,
                       descricao_porte VARCHAR(255) NOT NULL
);

-- Inserções na tabela 'porte'
INSERT INTO porte (id, descricao_porte) VALUES (1, 'Pequeno');
INSERT INTO porte (id, descricao_porte) VALUES (2, 'Médio');
INSERT INTO porte (id, descricao_porte) VALUES (3, 'Grande');

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
INSERT INTO comportamento (id, descricao_comportamento) VALUES (1, 'Calmo');
INSERT INTO comportamento (id, descricao_comportamento) VALUES (2, 'Agitado');
INSERT INTO comportamento (id, descricao_comportamento) VALUES (3, 'Brincalhão');

-- Criação da tabela 'cirurgia'
CREATE TABLE cirurgia (
                          id BIGSERIAL PRIMARY KEY,
                          descricao_cirurgia VARCHAR(255) NOT NULL
);
-- Inserções na tabela 'cirurgia'
INSERT INTO cirurgia (id, descricao_cirurgia) VALUES (1, 'Castração');
INSERT INTO cirurgia (id, descricao_cirurgia) VALUES (2, 'Retirada de Tumor');
INSERT INTO cirurgia (id, descricao_cirurgia) VALUES (3, 'Amputação');


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
VALUES ('Rex', 5.0, 1, 1, 1, TRUE, TRUE, TRUE, TRUE, 'Cão muito amigável e treinado', 'https://img.freepik.com/fotos-gratis/cao-pug-isolado-em-um-fundo-branco_2829-11416.jpg?w=740&t=st=1727745940~exp=1727746540~hmac=7c8c3c49b915704d67ed2cb8539df735d5b2d1d3f7f75ea0717e2c7b553e176a');

-- Inserindo um Poodle de porte médio e espécie canina
INSERT INTO animal (nome, idade, raca_id, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Max', 3.0, 2, 2, 2, TRUE, TRUE, FALSE, FALSE, 'Cachorro agitado e brincalhão', 'https://img.freepik.com/psd-gratuitas/cena-fofa-de-cachorro-marrom-e-branco_23-2150179279.jpg?w=360&t=st=1727745887~exp=1727746487~hmac=a959ec9ad996d51c0873e5f5c4326f427ca6e6557f0ed969604eb97332d3b02a');

-- Inserindo um gato Siamês de porte pequeno e espécie felina
INSERT INTO animal (nome, idade, raca_id, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Mimi', 2.0, 3, 3, NULL, TRUE, TRUE, TRUE, FALSE, 'Gato carinhoso e calmo', 'https://png.pngtree.com/png-clipart/20210822/original/pngtree-cat-striped-whiskers-png-image_6651811.jpg');
