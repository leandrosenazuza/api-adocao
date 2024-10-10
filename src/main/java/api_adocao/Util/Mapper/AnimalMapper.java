package api_adocao.Util.Mapper;

import api_adocao.Repository.CirurgiaRepository;
import api_adocao.Repository.ComportamentoRepository;
import api_adocao.Repository.RacaRepository;
import org.springframework.stereotype.Component;

@Component
public class AnimalMapper {

    private RacaRepository racaRepository;
    private ComportamentoRepository comportamentoRepository;
    private CirurgiaRepository cirurgiaRepository;


}
