package api_adocao.Repository;

import api_adocao.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select * from usuario where usuario_sistema like :usuario", nativeQuery = true)
    Usuario buscarPorUsuario(@Param("usuario") String usarioSistema);
}
