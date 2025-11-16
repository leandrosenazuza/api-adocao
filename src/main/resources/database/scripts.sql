INSERT INTO especie (descricao_especie) VALUES ('Gato');
INSERT INTO especie (descricao_especie) VALUES ('Cachorro');
INSERT INTO especie (descricao_especie) VALUES ('Pássaro');

INSERT INTO porte (descricao_porte) VALUES ('Pequeno');
INSERT INTO porte (descricao_porte) VALUES ('Médio');
INSERT INTO porte (descricao_porte) VALUES ('Grande');

INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Labrador', 3, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Poodle', 2, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Siamês', 1, 1);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Persa', 1, 1);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Vira-lata', 1, 1);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('SRD', 2, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Pastor Alemão', 3, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Golden Retriever', 3, 2);
INSERT INTO raca (descricao_raca, porte_id, especie_id) VALUES ('Galinha', 1, 3);

INSERT INTO comportamento (descricao_comportamento) VALUES ('Calmo');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Agitado');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Brincalhão');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Tímido');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Dengoso');
INSERT INTO comportamento (descricao_comportamento) VALUES ('Amoroso');

INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Castração');
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Retirada de Tumor');
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('Amputação');
INSERT INTO cirurgia (descricao_cirurgia) VALUES ('sem cirurgia');

INSERT INTO usuario (id, nome, email, usuario_sistema, senha) VALUES (nextval('usuario_seq'), 'Leandro Zuza', 'leandrosenazuza@gmail.com', 'zuza', '123');
INSERT INTO usuario (id, nome, email, usuario_sistema, senha) VALUES (nextval('usuario_seq'), 'Thiago', 'thiago@gmail.com', 'thiago', '123');
INSERT INTO usuario (id, nome, email, usuario_sistema, senha) VALUES (nextval('usuario_seq'), 'Wilson', 'will@gmail.com', 'will', '123');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Mel', 2.0, 5, 'FEMEA', 5, 1, TRUE, TRUE, TRUE, TRUE, 'Gatinha muito carinhosa e brincalhona', 'cat_1.jpg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Bolinha', 1.5, 3, 'MACHO', 3, NULL, FALSE, TRUE, TRUE, FALSE, 'Gatinho jovem e muito ativo', 'cat_2.jpg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Luna', 3.0, 4, 'FEMEA', 6, 1, TRUE, TRUE, TRUE, TRUE, 'Gata persa muito tranquila e amorosa', 'cat_3.jpg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Simba', 4.5, 5, 'MACHO', 1, 1, TRUE, TRUE, TRUE, TRUE, 'Gato adulto calmo e companheiro', 'cat_4.jpg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Chico', 1.0, 5, 'MACHO', 3, NULL, FALSE, TRUE, FALSE, FALSE, 'Gatinho filhote muito brincalhão', 'cat_5.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Nina', 2.5, 3, 'FEMEA', 5, 1, TRUE, TRUE, TRUE, TRUE, 'Gata siamesa dengosa e carinhosa', 'cat_6.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Tigre', 5.0, 5, 'MACHO', 1, 1, TRUE, TRUE, TRUE, TRUE, 'Gato adulto muito tranquilo e amigável', 'cat_7.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Toby', 2.0, 1, 'MACHO', 2, 1, TRUE, TRUE, TRUE, TRUE, 'Labrador muito brincalhão e energético', 'dog_1.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Lola', 3.5, 2, 'FEMEA', 5, 1, TRUE, TRUE, TRUE, TRUE, 'Poodle muito carinhosa e inteligente', 'dog_2.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Zeus', 4.0, 7, 'MACHO', 1, 1, TRUE, TRUE, TRUE, TRUE, 'Pastor Alemão protetor e leal', 'dog_3.jpg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Daisy', 1.5, 8, 'FEMEA', 6, NULL, FALSE, TRUE, TRUE, FALSE, 'Golden Retriever filhote muito doce', 'dog_4.jpg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Rocky', 3.0, 6, 'MACHO', 2, 2, TRUE, TRUE, FALSE, FALSE, 'Cachorro SRD muito ativo e brincalhão', 'dog_5.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Maya', 2.5, 1, 'FEMEA', 5, 1, TRUE, TRUE, TRUE, TRUE, 'Labradora muito amigável e carinhosa', 'dog_6.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Jack', 4.5, 6, 'MACHO', 1, 1, TRUE, TRUE, TRUE, TRUE, 'Cachorro SRD adulto muito tranquilo', 'dog_7.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Sophia', 1.0, 2, 'FEMEA', 3, NULL, FALSE, TRUE, TRUE, FALSE, 'Poodle filhote muito brincalhona', 'dog_8.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Charlie', 3.0, 8, 'MACHO', 6, 1, TRUE, TRUE, TRUE, TRUE, 'Golden Retriever muito amoroso e dócil', 'dog_9.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Lily', 2.0, 1, 'FEMEA', 5, 1, TRUE, TRUE, TRUE, TRUE, 'Labradora jovem muito carinhosa', 'dog_10.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Maximus', 5.0, 7, 'MACHO', 1, 1, TRUE, TRUE, TRUE, TRUE, 'Pastor Alemão adulto muito protetor', 'dog_11.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Bella', 1.5, 2, 'FEMEA', 6, NULL, FALSE, TRUE, TRUE, FALSE, 'Poodle filhote muito doce e amorosa', 'dog_12.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Duke', 3.5, 6, 'MACHO', 2, 1, TRUE, TRUE, FALSE, TRUE, 'Cachorro SRD muito ativo e brincalhão', 'dog_13.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Princess', 2.5, 8, 'FEMEA', 5, 1, TRUE, TRUE, TRUE, TRUE, 'Golden Retriever muito carinhosa e dócil', 'dog_14.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Buddy', 4.0, 1, 'MACHO', 6, 1, TRUE, TRUE, TRUE, TRUE, 'Labrador muito amigável e companheiro', 'dog_15.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Rosie', 1.5, 2, 'FEMEA', 3, NULL, FALSE, TRUE, TRUE, FALSE, 'Poodle filhote muito brincalhona e alegre', 'dog_16.jpeg');

INSERT INTO animal (nome, idade, raca_id, sexo, comportamento_id, cirurgia_id, is_castrado, is_vermifugado, is_vacinado, is_cirurgia, descricao_animal, foto)
VALUES ('Penelope', 1.0, 9, 'FEMEA', 1, NULL, FALSE, TRUE, TRUE, FALSE, 'Galinha muito dócil e amigável', 'chicken_1.jpeg');

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

INSERT INTO solicitacao (nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES ('Ana Souza', 'ana.souza@example.com', '11987654321', 1);
INSERT INTO solicitacao (nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES ('Carlos Lima', 'carlos.lima@example.com', '21987654321', 2);
INSERT INTO solicitacao (nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES ('Mariana Silva', 'mariana.silva@example.com', '31987654321', 3);
INSERT INTO solicitacao (nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES ('Paulo Oliveira', 'paulo.oliveira@example.com', '41987654321', 1);
INSERT INTO solicitacao (nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES ('Fernanda Costa', 'fernanda.costa@example.com', '51987654321', 2);
INSERT INTO solicitacao (nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES ('Ricardo Almeida', 'ricardo.almeida@example.com', '61987654321', 3);
INSERT INTO solicitacao (nome_interessado, email_interessado, telefone_interessado, animal_id) VALUES ('Juliana Pereira', 'juliana.pereira@example.com', '71987654321', 1);
