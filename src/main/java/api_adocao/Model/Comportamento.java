package api_adocao.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Comportamento {
    @Id
    private Long id;

}
