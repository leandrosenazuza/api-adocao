package api_adocao.Service;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.Especie;
import api_adocao.Model.Porte;
import api_adocao.Model.Raca;
import api_adocao.Repository.EspecieRepository;
import api_adocao.Repository.PorteRepository;
import api_adocao.Repository.RacaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RacaService {

    private static final Logger log = LoggerFactory.getLogger(RacaService.class);

    private final RacaRepository racaRepository;
    private final PorteRepository porteRepository;
    private final EspecieRepository especieRepository;

    @Autowired
    public RacaService(RacaRepository racaRepository, PorteRepository porteRepository, EspecieRepository especieRepository) {
        this.racaRepository = racaRepository;
        this.porteRepository = porteRepository;
        this.especieRepository = especieRepository;
    }


    public Raca buscarRacaPorId(Long id) {
        log.info("Buscando raça por ID no Service: {}", id);
        return racaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Raça não encontrada com ID: " + id));
    }


    public Raca criarRaca(Raca raca) {
        log.info("Criando nova raça: {}", raca.getDescricaoRaca()); // Log com a descrição da raça
        return racaRepository.save(raca);
    }


    public Raca atualizarRaca(Long id, Raca racaAtualizada) {
        log.info("Atualizando raça com ID {}: {}", id, racaAtualizada.getDescricaoRaca()); // Log com ID e descrição
        Raca racaExistente = buscarRacaPorId(id);
        // ... (código para atualizar os dados da raça)
        return racaRepository.save(racaExistente);
    }


    public void deletarRaca(Long id) {
        log.info("Deletando raça com ID: {}", id); // Log com o ID deletado
        Raca raca = buscarRacaPorId(id);
        racaRepository.delete(raca);
    }


    public List<Raca> getAllRaca() {
        log.info("Buscando todas as raças no Service");
        return racaRepository.findAll();
    }


    public List<Raca> buscarRacasPorEspecie(Long especieId) {
        log.info("Buscando raças por espécie no Service: {}", especieId);
        return racaRepository.findByEspecieId(especieId);
    }
}