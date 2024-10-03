package api_adocao.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Porte {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao_porte", nullable = false)
    private String descricaoPorte;

    @Column(nullable = false, unique = true)
    private String nome;
}
