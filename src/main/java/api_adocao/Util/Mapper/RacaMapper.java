package api_adocao.Util.Mapper;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.DTO.RacaDTO;
import api_adocao.Model.Especie;
import api_adocao.Model.Porte;
import api_adocao.Model.Raca;
import api_adocao.Repository.EspecieRepository;
import api_adocao.Repository.PorteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RacaMapper {

    private static final Logger log = LoggerFactory.getLogger(RacaMapper.class);
    private final PorteRepository porteRepository;
    private final EspecieRepository especieRepository;

    @Autowired
    public RacaMapper(PorteRepository porteRepository, EspecieRepository especieRepository) {
        this.porteRepository = porteRepository;
        this.especieRepository = especieRepository;
    }

    public RacaDTO toDTO(Raca raca) {
        log.debug("Convertendo Raça para DTO: {}", raca);
        if (raca != null) {
        }
        return null;
    }

    public Raca toEntity(RacaDTO racaDTO) {
        log.debug("Convertendo DTO para Raça: {}", racaDTO);

        if (racaDTO != null) {

            log.debug("Valores Porte e Espécie ID: {} {}", racaDTO.getPorteId(), racaDTO.getEspecieId());

            Raca raca = new Raca();
            raca.setDescricaoRaca(racaDTO.getDescricaoRaca());



            Porte porte = porteRepository.findById(racaDTO.getPorteId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Porte não encontrado!"));
            log.debug("Porte encontrado no mapeamento: {}", porte);


            Especie especie = especieRepository.findById(racaDTO.getEspecieId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Espécie não encontrada!"));
            log.debug("Espécie encontrada no mapeamento: {}", especie);


            raca.setPorte(porte);
            raca.setEspecie(especie);


            return raca;
        }
        return null;
    }
}