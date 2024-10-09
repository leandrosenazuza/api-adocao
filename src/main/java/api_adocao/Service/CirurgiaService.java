package api_adocao.Service;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.Cirurgia;
import api_adocao.Repository.CirurgiaRepository;
import api_adocao.Util.Mapper.CirurgiaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CirurgiaService {
    @Autowired
    private CirurgiaRepository cirurgiaRepository;

    private CirurgiaMapper cirurgiaMapper = new CirurgiaMapper();

    public List<Cirurgia> getAllCirurgia() {
        return cirurgiaRepository.findAll();
    }

    public Cirurgia buscarCirurgiaPorId(Long id) {
        return cirurgiaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cirurgia não encontrada com o ID " + id));
    }

    public Cirurgia criarCirurgia(Cirurgia cirurgia) {
        Long maxId = cirurgiaRepository.findMaxId();
        cirurgia.setId(maxId + 1);
        return cirurgiaRepository.save(cirurgia);
    }

    public Cirurgia atualizarCirurgia(Long id, Cirurgia cirurgiaAtualizada) {
        Cirurgia cirurgiaExistente = buscarCirurgiaPorId(id);
        cirurgiaExistente.setDescricaoCirurgia(cirurgiaAtualizada.getDescricaoCirurgia());
        return cirurgiaRepository.save(cirurgiaExistente);
    }

    public void deletarCirurgia(Long id) {
        Cirurgia cirurgia = buscarCirurgiaPorId(id);
        cirurgiaRepository.delete(cirurgia);
    }
}
