package api_adocao.Model.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AnimalDTO {
    private Long id;
    private String nome;
    @Min(value = 0, message = "A idade deve ser não negativa") // validação no backend
    private double idade;
    private Long racaId;
    @NotBlank(message = "O sexo do animal é obrigatório") // NotBlank valida se compo não está vazio
    private String sexo; // Mantém como String para facilitar o recebimento do JSON
    private Long comportamentoId;
    private Long cirurgiaId;
    private boolean isCastrado;
    private boolean isVermifugado;
    private boolean isVacinado;
    private boolean isCirurgia;
    private String descricaoAnimal;
    private String foto;
}
