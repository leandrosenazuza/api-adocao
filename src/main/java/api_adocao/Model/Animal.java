package api_adocao.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "idade", nullable = false)
    private double idade;

    @ManyToOne
    @JoinColumn(name = "raca_id", nullable = false)
    private Raca raca;

    @ManyToOne
    @JoinColumn(name = "comportamento_id", nullable = false)
    private Comportamento comportamento;

    @ManyToOne
    @JoinColumn(name = "cirurgia_id")
    private Cirurgia cirurgia;

    @Column(name = "is_castrado", nullable = false)
    private boolean isCastrado;

    @Column(name = "is_vermifugado", nullable = false)
    private boolean isVermifugado;

    @Column(name = "is_vacinado", nullable = false)
    private boolean isVacinado;

    @Column(name = "is_cirurgia", nullable = false)
    private boolean isCirurgia;

    @Column(name = "descricao_animal")
    private String descricaoAnimal;

    @Column(name = "foto")
    private String foto;
}
