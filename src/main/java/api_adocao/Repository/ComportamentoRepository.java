package api_adocao.Repository;

import api_adocao.Model.Animal;
import api_adocao.Model.Comportamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComportamentoRepository extends JpaRepository<Comportamento, Long> {

    @Query("SELECT COALESCE(MAX (e.id), 0) FROM Comportamento e")
    Long findMaxId();
}
