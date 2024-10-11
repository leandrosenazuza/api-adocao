package api_adocao.Util.Mapper;

import api_adocao.Model.Cirurgia;
import api_adocao.Model.DTO.CirurgiaDTO;

public class CirurgiaMapper {
   public CirurgiaDTO toDTO(Cirurgia cirurgia) {
        if(cirurgia != null) {
            CirurgiaDTO cirurgiaDTO = new CirurgiaDTO();
            cirurgia.setId(cirurgia.getId());
            cirurgiaDTO.setDescricaoCirurgia(cirurgia.getDescricaoCirurgia());
            return cirurgiaDTO;
        }
        return null;
    }

    public Cirurgia toEntity(CirurgiaDTO cirurgiaDTO) {
        if(cirurgiaDTO != null) {
            Cirurgia cirurgia = new Cirurgia();
            cirurgia.setDescricaoCirurgia(cirurgiaDTO.getDescricaoCirurgia());
            return cirurgia;
        }
        return null;
    }
}
