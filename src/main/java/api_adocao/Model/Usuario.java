package api_adocao.Model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_porte", nullable = false)
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "usario_sistema")
    private String usarioSistema;

    @Column(name = "senha")
    private String senha;

    @Column(name = "isAdministrador")
    private Boolean isAdministrador;

    @Column(name = "isDoador")
    private Boolean isDoador;

    @Column(name = "isAdotador")
    private Boolean isAdotador;

}
