package api_adocao.Model.Request;

import lombok.Data;

@Data
public class RequestLogin {
    private String usarioSistema;
    private String senha;
}
