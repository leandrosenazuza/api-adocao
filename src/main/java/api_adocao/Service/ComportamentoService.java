package api_adocao.Service;

import api_adocao.Model.Comportamento;
import api_adocao.Repository.ComportamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComportamentoService {
    @Autowired
    private ComportamentoRepository comportamentoRepository;

    public List<Comportamento> getAllComportamentos() {
        return comportamentoRepository.findAll();
    }

    public Comportamento getComportamentoById(Long id) {
        return comportamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comportamento não encontrado!"));
    }

    public Comportamento createComportamento(Comportamento comportamento) {
        return comportamentoRepository.save(comportamento);
    }

    public Comportamento updateComportamento(Long id, Comportamento comportamento) {
        if (comportamentoRepository.existsById(id)) {
            comportamento.setId(id);
            return comportamentoRepository.save(comportamento);
        } else {
            throw new RuntimeException("Comportamento não encontrado!");
        }
    }

    public void deleteComportamento(Long id) {
        if (comportamentoRepository.existsById(id)) {
            comportamentoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Comportamento não encontrado!");
        }
    }
}
