package api_adocao.Model.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetornoNumeroTotalAdocao {

    public RetornoNumeroTotalAdocao(int numeroAnimalAdocao) {
        this.numeroAnimalAdocao = numeroAnimalAdocao;
    }

    private int numeroAnimalAdocao;
}
