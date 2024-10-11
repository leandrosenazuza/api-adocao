package api_adocao.Util.Mapper;

import api_adocao.Model.Comportamento;
import api_adocao.Model.DTO.ComportamentoDTO;

public class ComportamentoMapper {
    public ComportamentoDTO toDTO(Comportamento comportamento) {
        if(comportamento != null) {
            ComportamentoDTO comportamentoDTO = new ComportamentoDTO();
            comportamento.setId(comportamento.getId());
            comportamentoDTO.setDescricaoComportamento(comportamento.getDescricaoComportamento());
            return comportamentoDTO;
        }
        return null;
    }

    public Comportamento toEntity(ComportamentoDTO comportamentoDTO) {
        if(comportamentoDTO != null) {
            Comportamento comportamento = new Comportamento();
            comportamento.setDescricaoComportamento(comportamentoDTO.getDescricaoComportamento());
            return comportamento;
        }
        return null;
    }
}
