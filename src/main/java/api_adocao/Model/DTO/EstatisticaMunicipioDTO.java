package api_adocao.Model.DTO;

import lombok.Data;

@Data
public class EstatisticaMunicipioDTO {
    private String municipio;
    private Double adocoesAnuais;
    private Double castracoesAnuais;
    private Double recolhimentos;
    private Double taxaAbandono;
}

