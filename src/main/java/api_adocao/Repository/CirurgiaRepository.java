package api_adocao.Repository;

import api_adocao.Model.Cirurgia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CirurgiaRepository extends JpaRepository<Cirurgia, Long> {
}