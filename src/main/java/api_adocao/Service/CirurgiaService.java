package api_adocao.Service;

import api_adocao.Model.Cirurgia;
import api_adocao.Repository.CirurgiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CirurgiaService {
    @Autowired
    private CirurgiaRepository cirurgiaRepository;

    public List<Cirurgia> getAllCirurgias() {
        return cirurgiaRepository.findAll();
    }

    public Cirurgia getCirurgiaById(Long id) {
        return cirurgiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cirurgia não encontrado!"));
    }

    public Cirurgia createCirurgia(Cirurgia cirurgia) {
        return cirurgiaRepository.save(cirurgia);
    }

    public Cirurgia updateCirurgia(Long id, Cirurgia cirurgia) {
        if (cirurgiaRepository.existsById(id)) {
            cirurgia.setId(id);
            return cirurgiaRepository.save(cirurgia);
        } else {
            throw new RuntimeException("Cirurgia não encontrado!");
        }
    }

    public void deleteCirurgia(Long id) {
        if (cirurgiaRepository.existsById(id)) {
            cirurgiaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cirurgia não encontrada!");
        }
    }
}
