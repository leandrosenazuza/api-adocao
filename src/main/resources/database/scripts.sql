-- Script de inicialização de dados
-- As tabelas são criadas automaticamente pelo Hibernate
-- Este script apenas insere os dados iniciais

-- Inserções na tabela 'especie'
INSERT INTO especie (descricao_especie) VALUES ('Gato');
INSERT INTO especie (descricao_especie) VALUES ('Cachorro');
INSERT INTO especie (descricao_especie) VALUES ('Pássaro');

-- Inserções na tabela 'porte'
INSERT INTO porte (descricao_porte) VALUES ('Pequeno');
INSERT INTO porte (descricao_porte) VALUES ('Médio');
INSERT INTO porte (descricao_porte) VALUES ('Grande');

-- Inserções na tabela 'raca'
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Labrador', 3, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Poodle', 2, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Siamês', 1, 1);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Persa', 1, 1);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Vira-lata', 1, 1);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('SRD', 2, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Pastor Alemão', 3, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Golden Retriever', 3, 2);

-- Inserções na tabela 'comportamento'
INSERT INTO comportamento (descricao_comportamento) VALUES ('Calmo');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Agitado');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Brincalhão');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Tímido');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Dengoso');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Amoroso');

-- Inserções na tabela 'cirurgia'
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Castração');
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Retirada de Tumor');
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Amputação');
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('sem cirurgia');

-- Inserções na tabela 'usuario' (usando a sequência criada pelo Hibernate)
-- No PostgreSQL, usa-se nextval('sequence_name') para obter o próximo valor da sequência
INSERT INTO usuario (id, nome, email, usuario_sistema, senha) VALUES (nextval('usuario_seq'), 'Leandro Zuza', 'leandrosenazuza@gmail.com', 'zuza', '123');
INSERT INTO usuario (id, nome, email, usuario_sistema, senha) VALUES (nextval('usuario_seq'), 'Thiago', 'thiago@gmail.com', 'thiago', '123');
INSERT INTO usuario (id, nome, email, usuario_sistema, senha) VALUES (nextval('usuario_seq'), 'Wilson', 'will@gmail.com', 'will', '123');

-- Inserções na tabela 'animal'
INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Rex', 5.0, 1, 'MACHO', 1, 1, TRUE, TRUE, TRUE, TRUE, 'Cão muito amigável e treinado', 'https://upload.wikimedia.org/wikipedia/commons/7/70/Serena_REFON.jpg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Max', 3.0, 2, 'MACHO', 2, 2, TRUE, TRUE, FALSE, FALSE, 'Cachorro agitado e brincalhão', 'https://i0.statig.com.br/bancodeimagens/78/pt/gs/78ptgsfeddfh638dkkzya5p3y.jpg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Mimi', 2.0, 3, 'FEMEA', 3, NULL, TRUE, TRUE, TRUE, FALSE, 'Gato carinhoso e calmo', 'https://midias.correiobraziliense.com.br/_midias/jpg/2024/01/31/675x450/1_sgrg-34614010.jpg?20240203041551?20240203041551');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Luna', 1.5, 4, 'FEMEA', 6, 3, TRUE, TRUE, TRUE, TRUE, 'Cachorrinha dócil e brincalhona', 'https://f.i.uol.com.br/fotografia/2022/07/14/165785281162d0d38b9f973_1657852811_3x2_rt.jpg');

-- Mais animais para demonstração
INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Thor', 4.0, 7, 'MACHO', 1, 1, TRUE, TRUE, TRUE, TRUE, 'Cão grande e protetor', NULL);

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Bella', 2.5, 8, 'FEMEA', 5, 1, TRUE, TRUE, TRUE, TRUE, 'Cachorrinha muito carinhosa', NULL);

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Felix', 1.0, 5, 'MACHO', 3, NULL, FALSE, TRUE, TRUE, FALSE, 'Gatinho jovem e brincalhão', NULL);

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Nina', 3.5, 6, 'FEMEA', 4, 1, TRUE, TRUE, TRUE, TRUE, 'Cachorrinha tímida mas muito doce', NULL);

-- Inserções na tabela 'estatistica_municipio'
INSERT INTO estatistica_municipio (municipio, adocoes_anuais, castracoes_anuais, recolhimentos, taxa_abandono) VALUES ('São Carlos', 498.00, 5011.00, 486.00, 97.59);
INSERT INTO estatistica_municipio (municipio, adocoes_anuais, castracoes_anuais, recolhimentos, taxa_abandono) VALUES ('Araraquara', 472.00, 4757.00, 460.00, 97.46);
INSERT INTO estatistica_municipio (municipio, adocoes_anuais, castracoes_anuais, recolhimentos, taxa_abandono) VALUES ('Franca', 699.00, 7049.00, 681.00, 97.42);
INSERT INTO estatistica_municipio (municipio, adocoes_anuais, castracoes_anuais, recolhimentos, taxa_abandono) VALUES ('Ribeirão Preto', 1371.00, 13834.00, 1336.00, 97.45);
INSERT INTO estatistica_municipio (municipio, adocoes_anuais, castracoes_anuais, recolhimentos, taxa_abandono) VALUES ('Bauru', 744.00, 7508.00, 725.00, 97.45);
INSERT INTO estatistica_municipio (municipio, adocoes_anuais, castracoes_anuais, recolhimentos, taxa_abandono) VALUES ('Piracicaba', 794.00, 8012.00, 774.00, 97.48);
INSERT INTO estatistica_municipio (municipio, adocoes_anuais, castracoes_anuais, recolhimentos, taxa_abandono) VALUES ('Rio Claro', 403.00, 4062.00, 392.00, 97.27);
INSERT INTO estatistica_municipio (municipio, adocoes_anuais, castracoes_anuais, recolhimentos, taxa_abandono) VALUES ('Jaboticabal', 150.00, 1514.00, 146.00, 97.33);
INSERT INTO estatistica_municipio (municipio, adocoes_anuais, castracoes_anuais, recolhimentos, taxa_abandono) VALUES ('Batatais', 125.00, 1257.00, 121.00, 96.80);
INSERT INTO estatistica_municipio (municipio, adocoes_anuais, castracoes_anuais, recolhimentos, taxa_abandono) VALUES ('Brodowski', 49.00, 492.00, 48.00, 97.96);

-- Inserções na tabela 'solicitacao'
INSERT INTO solicitacao (nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES ('Ana Souza', 'ana.souza@example.com', '11987654321', 1);
INSERT INTO solicitacao (nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES ('Carlos Lima', 'carlos.lima@example.com', '21987654321', 2);
INSERT INTO solicitacao (nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES ('Mariana Silva', 'mariana.silva@example.com', '31987654321', 3);
INSERT INTO solicitacao (nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES ('Paulo Oliveira', 'paulo.oliveira@example.com', '41987654321', 1);
INSERT INTO solicitacao (nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES ('Fernanda Costa', 'fernanda.costa@example.com', '51987654321', 2);
INSERT INTO solicitacao (nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES ('Ricardo Almeida', 'ricardo.almeida@example.com', '61987654321', 3);
INSERT INTO solicitacao (nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES ('Juliana Pereira', 'juliana.pereira@example.com', '71987654321', 1);
