package api_adocao.Model.Response;

import lombok.Data;

@Data
public class RetornoPadrao {
    private boolean sucesso = false;
    private String mensagem = "";
}
