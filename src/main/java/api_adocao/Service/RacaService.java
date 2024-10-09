package api_adocao.Service;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.Especie;
import api_adocao.Model.Porte;
import api_adocao.Model.Raca;
import api_adocao.Repository.EspecieRepository;
import api_adocao.Repository.PorteRepository;
import api_adocao.Repository.RacaRepository;
import api_adocao.Util.Mapper.RacaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RacaService {

    @Autowired
    private RacaRepository racaRepository;

    @Autowired
    private RacaMapper racaMapper;

    @Autowired  // Injeção do PorteRepository
    private PorteRepository porteRepository;

    @Autowired
    private EspecieRepository especieRepository;

    //private RacaMapper racaMapper = new RacaMapper();


    public Raca buscarRacaPorId(Long id) {
        return racaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Raça não encontrada com ID: " + id));
    }

    public Raca criarRaca(Raca raca) {
        Long maxId = racaRepository.findMaxId();
        raca.setId(maxId + 1);
        return racaRepository.save(raca);
    }

    public Raca atualizarRaca(Long id, Raca racaAtualizada) {
        Raca racaExistente = buscarRacaPorId(id);

        racaExistente.setDescricaoRaca(racaAtualizada.getDescricaoRaca());

        Porte novoPorte = porteRepository.findById(racaAtualizada.getPorte().getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Porte não encontrado!"));
        Especie novaEspecie = especieRepository.findById(racaAtualizada.getEspecie().getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Espécie não encontrada!"));

        racaExistente.setPorte(novoPorte);
        racaExistente.setEspecie(novaEspecie);

        return racaRepository.save(racaExistente);
    }

    public void deletarRaca(Long id) {
        Raca raca = buscarRacaPorId(id);
        racaRepository.delete(raca);
    }

    public List<Raca> getAllRaca() {
        return racaRepository.findAll();
    }
}
