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

-- Criação da tabela 'raca'
CREATE TABLE raca (
                      id BIGSERIAL PRIMARY KEY,
                      descricao_raca VARCHAR(255) NOT NULL,
                      porte_id BIGINT NOT NULL REFERENCES porte(id) ON DELETE RESTRICT,
                      especie_id BIGINT NOT NULL REFERENCES especie(id) ON DELETE RESTRICT
);

-- Inserções na tabela 'raca'
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Labrador', 3, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Poodle', 2, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Siamês', 1, 1);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Persa', 1, 1);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Vira-lata', 1, 1);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('SRD', 2, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Pastor Alemão', 3, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Golden Retriever', 3, 2);


-- Criação da tabela 'comportamento'
CREATE TABLE comportamento (
                               id BIGSERIAL PRIMARY KEY,
                               descricao_comportamento VARCHAR(255) NOT NULL
);

-- Inserções na tabela 'comportamento'
INSERT INTO comportamento (descricao_comportamento) VALUES ('Calmo');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Agitado');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Brincalhão');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Tímido');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Dengoso');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Amoroso');

-- Criação da tabela 'cirurgia'
CREATE TABLE cirurgia (
                          id BIGSERIAL PRIMARY KEY,
                          descricao_cirurgia VARCHAR(255) NOT NULL
);

-- Inserções na tabela 'cirurgia'
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Castração');
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Retirada de Tumor');
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Amputação');
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('sem cirurgia');


-- Criação da tabela 'animal' (com sexo como VARCHAR e restrição CHECK)
CREATE TABLE animal (
                        id BIGSERIAL PRIMARY KEY,
                        nome VARCHAR(255) NOT NULL,
                        idade DOUBLE PRECISION NOT NULL,
                        raca_id BIGINT REFERENCES raca(id) ON DELETE SET NULL,
                        sexo VARCHAR(255) NOT NULL,  -- sexo agora é enum
                        comportamento_id BIGINT REFERENCES comportamento(id) ON DELETE SET NULL,
                        cirurgia_id BIGINT REFERENCES cirurgia(id) ON DELETE SET NULL,
                        is_castrado BOOLEAN NOT NULL,
                        is_vermifugado BOOLEAN NOT NULL,
                        is_vacinado BOOLEAN NOT NULL,
                        is_cirurgia BOOLEAN NOT NULL,  -- indica se teve cirurgia
                        descricao_animal TEXT,
                        foto TEXT,
                        CONSTRAINT sexo_check CHECK (sexo IN ('MACHO', 'FEMEA', 'DESCONHECIDO')) -- Restrição CHECK para sexo
);

CREATE TABLE usuario (
                         id BIGSERIAL PRIMARY KEY,
                         nome VARCHAR(100),
                         email VARCHAR(100),
                         usuario_sistema VARCHAR(100),
                         senha VARCHAR(100)
);

create TABLE solicitacao(
                            id BIGSERIAL PRIMARY KEY,
                            nome_interessado VARCHAR(100) NOT NULL,
                            email_interessado VARCHAR(100) NOT NULL,
                            telefone_interessado VARCHAR(100) NOT NULL,
                            animal_id BIGINT NOT NULL REFERENCES animal(id) ON DELETE RESTRICT
);

-- Inserções na tabela 'animal' (com sexo como enum)

INSERT INTO usuario (nome, email, usuario_sistema, senha) VALUES ('Leandro Zuza', 'leandrosenazuza@gmail.com', 'zuza', '123');
INSERT INTO usuario (nome, email, usuario_sistema, senha) VALUES ('Thiago', 'thiago@gmail.com', 'thiago', '123');
INSERT INTO usuario (nome, email, usuario_sistema, senha) VALUES ('Wilson', 'will@gmail.com', 'will', '123');

-- Inserindo um Labrador de porte grande e espécie canina
INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Rex', 5.0, 1, 'MACHO', 1, 1, TRUE, TRUE, TRUE, TRUE, 'Cão muito amigável e treinado', 'https://upload.wikimedia.org/wikipedia/commons/7/70/Serena_REFON.jpg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Max', 3.0, 2, 'MACHO', 2, 2, TRUE, TRUE, FALSE, FALSE, 'Cachorro agitado e brincalhão', 'https://i0.statig.com.br/bancodeimagens/78/pt/gs/78ptgsfeddfh638dkkzya5p3y.jpg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Mimi', 2.0, 3, 'FEMEA', 3, NULL, TRUE, TRUE, TRUE, FALSE, 'Gato carinhoso e calmo', 'https://midias.correiobraziliense.com.br/_midias/jpg/2024/01/31/675x450/1_sgrg-34614010.jpg?20240203041551?20240203041551');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Luna', 1.5, 4, 'FEMEA', 6, 3, TRUE, TRUE, TRUE, TRUE, 'Cachorrinha dócil e brincalhona', 'https://f.i.uol.com.br/fotografia/2022/07/14/165785281162d0d38b9f973_1657852811_3x2_rt.jpg');


--INSERTS PARA SOLICITACAO
INSERT INTO solicitacao (id, nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES
                                                                                                       (1, 'Ana Souza', 'ana.souza@example.com', '11987654321', 1),
                                                                                                       (3, 'Carlos Lima', 'carlos.lima@example.com', '21987654321', 2),
                                                                                                       (4, 'Mariana Silva', 'mariana.silva@example.com', '31987654321', 3),
                                                                                                       (5, 'Paulo Oliveira', 'paulo.oliveira@example.com', '41987654321', 1),
                                                                                                       (6, 'Fernanda Costa', 'fernanda.costa@example.com', '51987654321', 2),
                                                                                                       (7, 'Ricardo Almeida', 'ricardo.almeida@example.com', '61987654321', 3),
                                                                                                       (8, 'Juliana Pereira', 'juliana.pereira@example.com', '71987654321', 1);