package api_adocao.Model.DTO;

import api_adocao.Model.Cirurgia;
import api_adocao.Model.Comportamento;
import api_adocao.Model.Raca;
import lombok.Data;

@Data
public class AnimalDTO {
    private Long id;
    private String nome;
    private double idade;
    private Long racaId;
    private String sexo;
    private Long comportamentoId;
    private Long cirurgiaId;
    private boolean isCastrado;
    private boolean isVermifugado;
    private boolean isVacinado;
    private boolean isCirurgia;
    private String descricaoAnimal;
    private String foto;
}
