package api_adocao.Util.Mapper;

import api_adocao.Model.DTO.RacaDTO;
import api_adocao.Model.Raca;

public class RacaMapper {

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
            return raca;
        }
        return null;
    }
}
