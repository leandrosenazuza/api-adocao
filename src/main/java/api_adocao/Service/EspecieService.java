package api_adocao.Service;

import api_adocao.Model.Especie;
import api_adocao.Repository.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecieService {

    @Autowired
    private EspecieRepository especieRepository;

    public List<Especie> getAllEspecie() {
        return especieRepository.findAll();
    }
}
