package api_adocao.Repository;

import api_adocao.Model.EstatisticaMunicipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstatisticaMunicipioRepository extends JpaRepository<EstatisticaMunicipio, Long> {
    Optional<EstatisticaMunicipio> findByMunicipio(String municipio);
}

