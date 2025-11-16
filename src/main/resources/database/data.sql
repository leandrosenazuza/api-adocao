-- Dados iniciais para apresentação
-- As tabelas serão criadas automaticamente pelo Hibernate

-- Inserções na tabela 'especie' (precisa ser primeiro)
INSERT INTO especie (descricao_especie) VALUES ('Gato');
INSERT INTO especie (descricao_especie) VALUES ('Cachorro');
INSERT INTO especie (descricao_especie) VALUES ('Pássaro');

-- Inserções na tabela 'porte' (precisa ser antes de raca)
INSERT INTO porte (descricao_porte) VALUES ('Pequeno');
INSERT INTO porte (descricao_porte) VALUES ('Médio');
INSERT INTO porte (descricao_porte) VALUES ('Grande');

-- Inserções na tabela 'raca' (precisa ser antes de animal)
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Labrador', 3, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Poodle', 2, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Siamês', 1, 1);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Persa', 1, 1);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Vira-lata', 1, 1);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('SRD', 2, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Pastor Alemão', 3, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Golden Retriever', 3, 2);

-- Inserções na tabela 'comportamento' (precisa ser antes de animal)
INSERT INTO comportamento (descricao_comportamento) VALUES ('Calmo');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Agitado');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Brincalhão');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Tímido');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Dengoso');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Amoroso');

-- Inserções na tabela 'cirurgia' (precisa ser antes de animal)
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Castração');
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Retirada de Tumor');
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Amputação');
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('sem cirurgia');

-- Inserções na tabela 'usuario'
INSERT INTO usuario (nome, email, usuario_sistema, senha) VALUES ('Leandro Zuza', 'leandrosenazuza@gmail.com', 'zuza', '123');
INSERT INTO usuario (nome, email, usuario_sistema, senha) VALUES ('Thiago', 'thiago@gmail.com', 'thiago', '123');
INSERT INTO usuario (nome, email, usuario_sistema, senha) VALUES ('Wilson', 'will@gmail.com', 'will', '123');

-- Inserções na tabela 'animal' (deve ser por último devido às foreign keys)
INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Rex', 5.0, 1, 'MACHO', 1, 1, true, true, true, true, 'Cão muito amigável e treinado', 'https://upload.wikimedia.org/wikipedia/commons/7/70/Serena_REFON.jpg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Max', 3.0, 2, 'MACHO', 2, 2, true, true, false, false, 'Cachorro agitado e brincalhão', 'https://i0.statig.com.br/bancodeimagens/78/pt/gs/78ptgsfeddfh638dkkzya5p3y.jpg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Mimi', 2.0, 3, 'FEMEA', 3, NULL, true, true, true, false, 'Gato carinhoso e calmo', 'https://midias.correiobraziliense.com.br/_midias/jpg/2024/01/31/675x450/1_sgrg-34614010.jpg?20240203041551?20240203041551');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Luna', 1.5, 4, 'FEMEA', 6, 3, true, true, true, true, 'Cachorrinha dócil e brincalhona', 'https://f.i.uol.com.br/fotografia/2022/07/14/165785281162d0d38b9f973_1657852811_3x2_rt.jpg');

