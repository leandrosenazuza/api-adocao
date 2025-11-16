package api_adocao.Model.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetornoPadrao {
    private boolean sucesso = false;
    private String mensagem = "";
    private Long usuarioId;
}
