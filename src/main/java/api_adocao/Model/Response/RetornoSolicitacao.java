package api_adocao.Model.Response;

import api_adocao.Model.DTO.AnimalDTO;
import lombok.Data;

@Data
public class RetornoSolicitacao {
    private Long id;
    private String nomeInteressado;
    private String telefoneInteressado;
    private String emailInteressado;
    private AnimalDTO animalDTO;
}
