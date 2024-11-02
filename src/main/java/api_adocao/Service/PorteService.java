package api_adocao.Service;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.Porte;
import api_adocao.Repository.PorteRepository;
import api_adocao.Util.Mapper.PorteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorteService {

    @Autowired
    private PorteRepository porteRepository;

    private PorteMapper porteMapper = new PorteMapper();

    public List<Porte> listarTodosPortes() {
        return porteRepository.findAll();
    }

    public Porte buscarPortePorId(Long id) {
        return porteRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Porte não encontrado com o ID: " + id));
    }

    public Porte criarPorte(Porte porte) {
       //Long maxId = porteRepository.findMaxId();
      // porte.setId(maxId + 1);
       return porteRepository.save(porte);
   }

    public Porte atualizarPorte(Long id, Porte porteAtualizado) {
        Porte porteExistente = buscarPortePorId(id);
        porteExistente.setDescricaoPorte(porteAtualizado.getDescricaoPorte());
        return porteRepository.save(porteExistente);
    }

    public void deletarPorte(Long id) {
        Porte porte = buscarPortePorId(id);
        porteRepository.delete(porte);
    }

    public List<Porte> getAllPorte() {
        return porteRepository.findAll();
    }
}
