package api_adocao.Model.DTO;

import lombok.Data;

@Data
public class IotDataDTO {
    private Double temperatura;
    private Double umidade;
    private String localizacao;
    private Long timestamp;
}

