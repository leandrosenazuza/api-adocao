package api_adocao.Service;

import api_adocao.Model.Request.RequestLogin;
import api_adocao.Model.Usuario;
import api_adocao.Repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;
    private RequestLogin requestLogin;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("João Silva");
        usuario.setEmail("joao@email.com");
        usuario.setUsarioSistema("joao");
        usuario.setSenha("senha123");

        requestLogin = new RequestLogin();
        requestLogin.setUsarioSistema("joao");
        requestLogin.setSenha("senha123");
    }

    @Test
    void testSaveUsuario() {
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario resultado = usuarioService.saveUsuario(usuario);

        assertNotNull(resultado);
        assertEquals("João Silva", resultado.getNome());
        assertEquals("joao@email.com", resultado.getEmail());
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void testGetUsuarioById_Success() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Usuario resultado = usuarioService.getUsuarioById(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("João Silva", resultado.getNome());
    }

    @Test
    void testGetUsuarioById_NotFound() {
        when(usuarioRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            usuarioService.getUsuarioById(999L);
        });
    }

    @Test
    void testGetAllUsuarios() {
        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNome("Maria Santos");

        List<Usuario> usuarios = Arrays.asList(usuario, usuario2);
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> resultado = usuarioService.getAllUsuarios();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void testUpdateUsuario() {
        Usuario usuarioAtualizado = new Usuario();
        usuarioAtualizado.setNome("João Silva Atualizado");
        usuarioAtualizado.setEmail("joao.novo@email.com");
        usuarioAtualizado.setSenha("novaSenha123");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario resultado = usuarioService.updateUsuario(1L, usuarioAtualizado);

        assertNotNull(resultado);
        verify(usuarioRepository, times(1)).findById(1L);
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }

    @Test
    void testDeleteUsuario() {
        doNothing().when(usuarioRepository).deleteById(anyLong());

        usuarioService.deleteUsuario(1L);

        verify(usuarioRepository, times(1)).deleteById(1L);
    }

    @Test
    void testLogin_Success() {
        when(usuarioRepository.buscarPorUsuario("joao")).thenReturn(usuario);

        boolean resultado = usuarioService.login(requestLogin);

        assertTrue(resultado);
        verify(usuarioRepository, times(1)).buscarPorUsuario("joao");
    }

    @Test
    void testLogin_WrongPassword() {
        requestLogin.setSenha("senhaErrada");
        when(usuarioRepository.buscarPorUsuario("joao")).thenReturn(usuario);

        boolean resultado = usuarioService.login(requestLogin);

        assertFalse(resultado);
    }

    @Test
    void testLoginComUsuario_Success() {
        when(usuarioRepository.buscarPorUsuario("joao")).thenReturn(usuario);

        Usuario resultado = usuarioService.loginComUsuario(requestLogin);

        assertNotNull(resultado);
        assertEquals("joao", resultado.getUsarioSistema());
    }

    @Test
    void testLoginComUsuario_Failure() {
        requestLogin.setSenha("senhaErrada");
        when(usuarioRepository.buscarPorUsuario("joao")).thenReturn(usuario);

        Usuario resultado = usuarioService.loginComUsuario(requestLogin);

        assertNull(resultado);
    }
}

