package api_adocao.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Comportamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao_comportamento", nullable = false)
    private String descricaoComportamento;
}
