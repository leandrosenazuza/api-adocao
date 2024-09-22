package api_adocao.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Especie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao_especie", nullable = false)
    private String descricaoEspecie;
}
