package api_adocao.Service;

import api_adocao.Model.Request.RequestLogin;
import api_adocao.Model.Usuario;
import api_adocao.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new RuntimeException("Usuário não encontrado com id " + id));
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario updateUsuario(Long id, Usuario usuario) {
        Usuario existingUsuario = getUsuarioById(id);
        existingUsuario.setNome(usuario.getNome());
        existingUsuario.setEmail(usuario.getEmail());
        existingUsuario.setSenha(usuario.getSenha());
        return usuarioRepository.save(existingUsuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public boolean login(RequestLogin requestLogin) {
        Usuario usuario = usuarioRepository.buscarPorUsuario(requestLogin.getUsarioSistema());
        if(usuario != null && requestLogin.getSenha().equals(usuario.getSenha())) {
            return true;
        } else return false;
    }

    public Usuario loginComUsuario(RequestLogin requestLogin) {
        Usuario usuario = usuarioRepository.buscarPorUsuario(requestLogin.getUsarioSistema());
        if(usuario != null && requestLogin.getSenha().equals(usuario.getSenha())) {
            return usuario;
        }
        return null;
    }

}
