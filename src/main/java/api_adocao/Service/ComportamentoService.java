package api_adocao.Service;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.Comportamento;
import api_adocao.Repository.ComportamentoRepository;
import api_adocao.Util.Mapper.ComportamentoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComportamentoService {

    @Autowired
    private ComportamentoRepository comportamentoRepository;

    private ComportamentoMapper comportamentoMapper = new ComportamentoMapper();

    public List<Comportamento> getAllComportamentos() {
        return comportamentoRepository.findAll();
    }

    public Comportamento buscarComportamentoPorId(Long id) {
        return comportamentoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Comportamento não encontrado!"));
    }

    public Comportamento criarComportamento(Comportamento comportamento) {
        //Long maxId = comportamentoRepository.findMaxId();
        //comportamento.setId(maxId + 1);
        return comportamentoRepository.save(comportamento);
    }

    public Comportamento atualizarComportamento(Long id, Comportamento comportamentoAtualizado) {
        Comportamento comportamentoExistente = buscarComportamentoPorId(id);
        comportamentoExistente.setDescricaoComportamento(comportamentoAtualizado.getDescricaoComportamento());
        return comportamentoRepository.save(comportamentoExistente);
    }

    public void deletarComportamento(Long id) {
        Comportamento comportamento = buscarComportamentoPorId(id);
        comportamentoRepository.delete(comportamento);
    }
}
