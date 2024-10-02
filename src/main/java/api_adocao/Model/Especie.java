package api_adocao.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "especie") // Nome da tabela correspondente
public class Especie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "especie_id_seq")
    @SequenceGenerator(name = "especie_id_seq", sequenceName = "especie_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "descricao_especie", nullable = false)
    private String descricaoEspecie;
}
