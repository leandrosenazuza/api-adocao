package api_adocao.Util.Mapper;

import api_adocao.Model.DTO.PorteDTO;
import api_adocao.Model.Porte;

public class PorteMapper {
    public PorteDTO toDTO(Porte porte) {
        if(porte != null) {
            PorteDTO porteDTO = new PorteDTO();
            porte.setId(porte.getId());
            porteDTO.setDescricaoPorte(porte.getDescricaoPorte());
            return porteDTO;
        }
        return null;
    }

    public Porte toEntity(PorteDTO porteDTO) {
        if(porteDTO != null) {
            Porte porte = new Porte();
            porte.setDescricaoPorte(porteDTO.getDescricaoPorte());
            return porte;
        }
        return null;
    }
}
