package api_adocao.Service;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.Raca;
import api_adocao.Repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RacaService {

    @Autowired
    private RacaRepository racaRepository;

    public List<Raca> listarTodasRacas() {
        return racaRepository.findAll();
    }

    public Raca buscarRacaPorId(Long id) {
        return racaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Raça não encontrada com ID: " + id));
    }

    public Raca criarRaca(Raca raca) {
        return racaRepository.save(raca);
    }

    public Raca atualizarRaca(Long id, Raca racaAtualizada) {
        Raca racaExistente = buscarRacaPorId(id);
        racaExistente.setNome(racaAtualizada.getNome());
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
