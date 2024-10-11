package api_adocao.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
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
