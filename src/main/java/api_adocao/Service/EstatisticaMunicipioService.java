package api_adocao.Service;

import api_adocao.Model.EstatisticaMunicipio;
import api_adocao.Repository.EstatisticaMunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatisticaMunicipioService {

    @Autowired
    private EstatisticaMunicipioRepository repository;

    public List<EstatisticaMunicipio> getAllEstatisticas() {
        return repository.findAll();
    }

    public EstatisticaMunicipio saveEstatistica(EstatisticaMunicipio estatistica) {
        return repository.save(estatistica);
    }

    public void saveAll(List<EstatisticaMunicipio> estatisticas) {
        repository.saveAll(estatisticas);
    }
}

