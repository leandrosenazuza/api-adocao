package api_adocao.Repository;

import api_adocao.Model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query(value = "select count(*) from Animal", nativeQuery = true)
    int getNumeroAnimaisEsperandoAdocao();

    List<Animal> findByRacaEspecieId(Long especieId);
}
