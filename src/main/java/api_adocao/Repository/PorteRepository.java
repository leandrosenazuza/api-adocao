package api_adocao.Repository;

import api_adocao.Model.Animal;
import api_adocao.Model.Porte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorteRepository extends JpaRepository<Porte, Long> {
}
