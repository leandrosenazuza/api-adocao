package api_adocao.Service;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.Especie;
import api_adocao.Repository.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class EspecieService {

    @Autowired
    private EspecieRepository especieRepository;

    public Especie buscarEspeciePorId(Long id) {
        return especieRepository.findById(id)
              .orElseThrow(() -> new EntidadeNaoEncontradaException("Espécie não encontrada com o ID: " + id));
    }

    public Especie criarEspecie(Especie especie) {
        return especieRepository.save(especie);
    }

    public Especie atualizarEspecie(Long id, Especie especieAtualizada) {
        Especie especieExistente = buscarEspeciePorId(id);
        especieExistente.setDescricaoEspecie(especieAtualizada.getDescricaoEspecie());
        return especieRepository.save(especieExistente);
    }

    public void deletarEspecie(Long id) {
        Especie especie = buscarEspeciePorId(id);
        especieRepository.delete(especie);
    }

    public List<Especie> getAllEspecie() {
        return especieRepository.findAll();
    }
}
