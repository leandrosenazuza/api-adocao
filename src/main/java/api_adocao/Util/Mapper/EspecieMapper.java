package api_adocao.Util.Mapper;

import api_adocao.Model.DTO.EspecieDTO;
import api_adocao.Model.Especie;

public class EspecieMapper {
    public EspecieDTO toDTO(Especie especie) {
        if(especie != null) {
            EspecieDTO especieDTO = new EspecieDTO();
            especie.setId(especie.getId());
            especieDTO.setDescricaoEspecie(especie.getDescricaoEspecie());
            return especieDTO;
        }
        return null;
    }

    public Especie toEntity(EspecieDTO especieDTO) {
        if(especieDTO != null) {
            Especie especie = new Especie();
            especie.setDescricaoEspecie(especieDTO.getDescricaoEspecie());
            return especie;
        }
        return null;
    }
    
}
