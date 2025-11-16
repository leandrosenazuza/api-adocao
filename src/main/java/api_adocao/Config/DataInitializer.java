package api_adocao.Config;

import api_adocao.Model.*;
import api_adocao.Repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;

@Configuration
public class DataInitializer {

    @Autowired
    private EspecieRepository especieRepository;

    @Autowired
    private PorteRepository porteRepository;

    @Autowired
    private RacaRepository racaRepository;

    @Autowired
    private ComportamentoRepository comportamentoRepository;

    @Autowired
    private CirurgiaRepository cirurgiaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @PostConstruct
    @Transactional
    public void init() {
        // Verifica se já existem dados para não duplicar
        if (especieRepository.count() > 0) {
            return;
        }

        // Criar Espécies
        Especie gato = new Especie(null, "Gato");
        Especie cachorro = new Especie(null, "Cachorro");
        Especie passaro = new Especie(null, "Pássaro");
        especieRepository.save(gato);
        especieRepository.save(cachorro);
        especieRepository.save(passaro);

        // Criar Portes
        Porte pequeno = new Porte(null, "Pequeno");
        Porte medio = new Porte(null, "Médio");
        Porte grande = new Porte(null, "Grande");
        porteRepository.save(pequeno);
        porteRepository.save(medio);
        porteRepository.save(grande);

        // Criar Raças
        Raca labrador = new Raca(null, "Labrador", grande, cachorro);
        Raca poodle = new Raca(null, "Poodle", medio, cachorro);
        Raca siames = new Raca(null, "Siamês", pequeno, gato);
        Raca persa = new Raca(null, "Persa", pequeno, gato);
        Raca viraLata = new Raca(null, "Vira-lata", pequeno, gato);
        Raca srd = new Raca(null, "SRD", medio, cachorro);
        Raca pastorAlemao = new Raca(null, "Pastor Alemão", grande, cachorro);
        Raca goldenRetriever = new Raca(null, "Golden Retriever", grande, cachorro);
        racaRepository.save(labrador);
        racaRepository.save(poodle);
        racaRepository.save(siames);
        racaRepository.save(persa);
        racaRepository.save(viraLata);
        racaRepository.save(srd);
        racaRepository.save(pastorAlemao);
        racaRepository.save(goldenRetriever);

        // Criar Comportamentos
        Comportamento calmo = new Comportamento(null, "Calmo");
        Comportamento agitado = new Comportamento(null, "Agitado");
        Comportamento brincalhao = new Comportamento(null, "Brincalhão");
        Comportamento timido = new Comportamento(null, "Tímido");
        Comportamento dengoso = new Comportamento(null, "Dengoso");
        Comportamento amoroso = new Comportamento(null, "Amoroso");
        comportamentoRepository.save(calmo);
        comportamentoRepository.save(agitado);
        comportamentoRepository.save(brincalhao);
        comportamentoRepository.save(timido);
        comportamentoRepository.save(dengoso);
        comportamentoRepository.save(amoroso);

        // Criar Cirurgias
        Cirurgia castracao = new Cirurgia(null, "Castração");
        Cirurgia retiradaTumor = new Cirurgia(null, "Retirada de Tumor");
        Cirurgia amputacao = new Cirurgia(null, "Amputação");
        Cirurgia semCirurgia = new Cirurgia(null, "sem cirurgia");
        cirurgiaRepository.save(castracao);
        cirurgiaRepository.save(retiradaTumor);
        cirurgiaRepository.save(amputacao);
        cirurgiaRepository.save(semCirurgia);

        // Criar Usuários
        Usuario usuario1 = new Usuario();
        usuario1.setNome("Leandro Zuza");
        usuario1.setEmail("leandrosenazuza@gmail.com");
        usuario1.setUsarioSistema("zuza");
        usuario1.setSenha("123");
        usuarioRepository.save(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Thiago");
        usuario2.setEmail("thiago@gmail.com");
        usuario2.setUsarioSistema("thiago");
        usuario2.setSenha("123");
        usuarioRepository.save(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.setNome("Wilson");
        usuario3.setEmail("will@gmail.com");
        usuario3.setUsarioSistema("will");
        usuario3.setSenha("123");
        usuarioRepository.save(usuario3);

        // Criar Animais
        Animal rex = new Animal();
        rex.setNome("Rex");
        rex.setIdade(5.0);
        rex.setRaca(labrador);
        rex.setSexo(Sexo.MACHO);
        rex.setComportamento(calmo);
        rex.setCirurgia(castracao);
        rex.setCastrado(true);
        rex.setVermifugado(true);
        rex.setVacinado(true);
        setIsCirurgia(rex, true);
        rex.setDescricaoAnimal("Cão muito amigável e treinado");
        rex.setFoto("https://upload.wikimedia.org/wikipedia/commons/7/70/Serena_REFON.jpg");
        animalRepository.save(rex);

        Animal max = new Animal();
        max.setNome("Max");
        max.setIdade(3.0);
        max.setRaca(poodle);
        max.setSexo(Sexo.MACHO);
        max.setComportamento(agitado);
        max.setCirurgia(retiradaTumor);
        max.setCastrado(true);
        max.setVermifugado(true);
        max.setVacinado(false);
        setIsCirurgia(max, false);
        max.setDescricaoAnimal("Cachorro agitado e brincalhão");
        max.setFoto("https://i0.statig.com.br/bancodeimagens/78/pt/gs/78ptgsfeddfh638dkkzya5p3y.jpg");
        animalRepository.save(max);

        Animal mimi = new Animal();
        mimi.setNome("Mimi");
        mimi.setIdade(2.0);
        mimi.setRaca(siames);
        mimi.setSexo(Sexo.FEMEA);
        mimi.setComportamento(brincalhao);
        mimi.setCirurgia(null);
        mimi.setCastrado(true);
        mimi.setVermifugado(true);
        mimi.setVacinado(true);
        setIsCirurgia(mimi, false);
        mimi.setDescricaoAnimal("Gato carinhoso e calmo");
        mimi.setFoto("https://midias.correiobraziliense.com.br/_midias/jpg/2024/01/31/675x450/1_sgrg-34614010.jpg?20240203041551?20240203041551");
        animalRepository.save(mimi);

        Animal luna = new Animal();
        luna.setNome("Luna");
        luna.setIdade(1.5);
        luna.setRaca(persa);
        luna.setSexo(Sexo.FEMEA);
        luna.setComportamento(amoroso);
        luna.setCirurgia(amputacao);
        luna.setCastrado(true);
        luna.setVermifugado(true);
        luna.setVacinado(true);
        setIsCirurgia(luna, true);
        luna.setDescricaoAnimal("Cachorrinha dócil e brincalhona");
        luna.setFoto("https://f.i.uol.com.br/fotografia/2022/07/14/165785281162d0d38b9f973_1657852811_3x2_rt.jpg");
        animalRepository.save(luna);

        // Mais animais para demonstração
        Animal thor = new Animal();
        thor.setNome("Thor");
        thor.setIdade(4.0);
        thor.setRaca(pastorAlemao);
        thor.setSexo(Sexo.MACHO);
        thor.setComportamento(calmo);
        thor.setCirurgia(castracao);
        thor.setCastrado(true);
        thor.setVermifugado(true);
        thor.setVacinado(true);
        setIsCirurgia(thor, true);
        thor.setDescricaoAnimal("Cão grande e protetor");
        animalRepository.save(thor);

        Animal bella = new Animal();
        bella.setNome("Bella");
        bella.setIdade(2.5);
        bella.setRaca(goldenRetriever);
        bella.setSexo(Sexo.FEMEA);
        bella.setComportamento(dengoso);
        bella.setCirurgia(castracao);
        bella.setCastrado(true);
        bella.setVermifugado(true);
        bella.setVacinado(true);
        setIsCirurgia(bella, true);
        bella.setDescricaoAnimal("Cachorrinha muito carinhosa");
        animalRepository.save(bella);

        Animal felix = new Animal();
        felix.setNome("Felix");
        felix.setIdade(1.0);
        felix.setRaca(viraLata);
        felix.setSexo(Sexo.MACHO);
        felix.setComportamento(brincalhao);
        felix.setCirurgia(null);
        felix.setCastrado(false);
        felix.setVermifugado(true);
        felix.setVacinado(true);
        setIsCirurgia(felix, false);
        felix.setDescricaoAnimal("Gatinho jovem e brincalhão");
        animalRepository.save(felix);

        Animal nina = new Animal();
        nina.setNome("Nina");
        nina.setIdade(3.5);
        nina.setRaca(srd);
        nina.setSexo(Sexo.FEMEA);
        nina.setComportamento(timido);
        nina.setCirurgia(castracao);
        nina.setCastrado(true);
        nina.setVermifugado(true);
        nina.setVacinado(true);
        setIsCirurgia(nina, true);
        nina.setDescricaoAnimal("Cachorrinha tímida mas muito doce");
        animalRepository.save(nina);
    }

    private void setIsCirurgia(Animal animal, boolean value) {
        try {
            Field field = Animal.class.getDeclaredField("isCirurgia");
            field.setAccessible(true);
            field.setBoolean(animal, value);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao definir isCirurgia", e);
        }
    }
}

