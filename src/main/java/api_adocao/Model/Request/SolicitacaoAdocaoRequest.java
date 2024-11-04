package api_adocao.Model.Request;

import lombok.Data;

@Data
public class SolicitacaoAdocaoRequest {

    private String nomeInteressado;

    private String telefoneInteressado;

    private String emailInteressado;

    private Long animalId;
}
