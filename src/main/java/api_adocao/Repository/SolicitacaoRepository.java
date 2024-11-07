package api_adocao.Repository;

import api_adocao.Model.Solicitacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Integer> {

    @Query(value = "SELECT * FROM Solicitacao", nativeQuery = true)
    Page<Solicitacao> listaSolicitacoes(Pageable pageable);

    @Query(value = "SELECT count(*) FROM Solicitacao", nativeQuery = true)
    int getTotalSolicitacoes();
}
