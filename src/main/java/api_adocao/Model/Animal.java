package api_adocao.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private double idade;

    @ManyToOne
    @JoinColumn(name = "porte_id")
    private Porte porte;

    @ManyToOne
    @JoinColumn(name = "raca_id")
    private Raca raca;

    @ManyToOne
    @JoinColumn(name = "especie_id")
    private Especie especie;

    @ManyToOne
    @JoinColumn(name = "comportamento_id")
    private Comportamento comportamento;

    @ManyToOne
    @JoinColumn(name = "descricao_cirurgia_id")
    private Cirurgia descricaoCirurgia;

    private boolean isCastrado;

    private boolean isVermifugado;

    private boolean isVacinado;

    private boolean isCirurgia;

    private String descricaoAnimal;

    private String foto;
}

