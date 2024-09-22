package api_adocao.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Porte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao_porte", nullable = false)
    private String descricaoPorte;
}
