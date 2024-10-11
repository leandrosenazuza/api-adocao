package api_adocao.Util.Mapper;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.DTO.RacaDTO;
import api_adocao.Model.Especie;
import api_adocao.Model.Porte;
import api_adocao.Model.Raca;
import api_adocao.Repository.EspecieRepository;
import api_adocao.Repository.PorteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RacaMapper {

    private PorteRepository porteRepository;
    private EspecieRepository especieRepository;

    @Autowired
    public RacaMapper(PorteRepository porteRepository, EspecieRepository especieRepository) {
        this.porteRepository = porteRepository;
        this.especieRepository = especieRepository;
    }

    public RacaDTO toDTO(Raca raca) {
        if(raca != null) {
            RacaDTO racaDTO = new RacaDTO();
            raca.setId(raca.getId());
            racaDTO.setDescricaoRaca(raca.getDescricaoRaca());
            return racaDTO;
        }
        return null;
    }

    public Raca toEntity(RacaDTO racaDTO) {
        if(racaDTO != null) {
            Raca raca = new Raca();
            raca.setDescricaoRaca(racaDTO.getDescricaoRaca());

            // Obtém as entidades Porte e Especie do banco
            Porte porte = porteRepository.findById(racaDTO.getPorteId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Porte não encontrado!"));
            Especie especie = especieRepository.findById(racaDTO.getEspecieId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Especie não encontrado!"));

            // Associa o Porte e a Especie à Raca
            raca.setPorte(porte);
            raca.setEspecie(especie);

            return raca;
        }
        return null;
    }
}
