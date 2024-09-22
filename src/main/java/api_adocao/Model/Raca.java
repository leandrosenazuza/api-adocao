package api_adocao.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Raca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao_raca", nullable = false)
    private String descricaoRaca;

    @ManyToOne
    @JoinColumn(name = "porte_id", nullable = false)
    private Porte porte;

    @ManyToOne
    @JoinColumn(name = "especie_id", nullable = false)
    private Especie especie;
}
