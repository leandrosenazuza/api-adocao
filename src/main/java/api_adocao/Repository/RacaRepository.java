package api_adocao.Repository;

import api_adocao.Model.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Long> {

    List<Raca> findByEspecieId(Long especieId);
}
