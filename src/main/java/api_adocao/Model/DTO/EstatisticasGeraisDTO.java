package api_adocao.Model.DTO;

import lombok.Data;

@Data
public class EstatisticasGeraisDTO {
    private Double totalAdocoes;
    private Double totalCastracoes;
    private Double totalRecolhimentos;
    private Double mediaTaxaAbandono;
}

