package api_adocao.Model;

import api_adocao.Model.Interface.IAnimal;
import api_adocao.Util.AnimalEnums;
import api_adocao.Util.Raca;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Animal implements IAnimal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double idade;
    private String porte;
    private String raca;
    private String especie;
    private String comportamento;
    private boolean isCastrado;
    private boolean isVermifugado;
    private boolean isVacinado;
    private boolean isCirurgia;
    private String descricaoCirurgia;
    private String descricaoAnimal;
    private String foto;
}

