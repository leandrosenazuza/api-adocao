package api_adocao.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estatistica_municipio")
public class EstatisticaMunicipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "municipio", nullable = false, unique = true)
    private String municipio;

    @Column(name = "adocoes_anuais", nullable = false)
    private Double adocoesAnuais;

    @Column(name = "castracoes_anuais", nullable = false)
    private Double castracoesAnuais;

    @Column(name = "recolhimentos", nullable = false)
    private Double recolhimentos;

    @Column(name = "taxa_abandono", nullable = false)
    private Double taxaAbandono;
}

