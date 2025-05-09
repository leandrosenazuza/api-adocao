package api_adocao.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Raca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "descricao_raca", nullable = false)
    private String descricaoRaca;

    @ManyToOne
    @JoinColumn(name = "porte_id", nullable = false)
    private Porte porte;

    @ManyToOne
    @JoinColumn(name = "especie_id", nullable = false)
    private Especie especie;
}
