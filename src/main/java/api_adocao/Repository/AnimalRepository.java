package api_adocao.Repository;

import api_adocao.Model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT COALESCE(MAX (e.id), 0) FROM Animal e")
    Long findMaxId();
}
