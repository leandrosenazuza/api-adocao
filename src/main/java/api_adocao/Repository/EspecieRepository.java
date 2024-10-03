package api_adocao.Repository;

import api_adocao.Model.Animal;
import api_adocao.Model.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {

    @Query("SELECT COALESCE(MAX(e.id), 0) FROM Especie e")
    Long findMaxId();
}
