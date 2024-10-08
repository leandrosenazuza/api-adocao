package api_adocao.Controller;

import api_adocao.Model.DTO.UsuarioDTO;
import api_adocao.Model.Usuario;
import api_adocao.Service.UsuarioService;
import api_adocao.Util.Mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private UsuarioMapper usuarioMapper = new UsuarioMapper();

    @PostMapping("/login")
    public ResponseEntity<String> loginUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuarioService.login(usuario);
        return ResponseEntity.ok("Sucesso");
    }


    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        Usuario savedUsuario = usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(usuarioMapper.toDTO(savedUsuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        return ResponseEntity.ok(usuarioMapper.toDTO(usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarioMapper.toDTOList(usuarios));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario updatedUsuario = usuarioService.updateUsuario(id, usuarioMapper.toEntity(usuarioDTO));
        return ResponseEntity.ok(usuarioMapper.toDTO(updatedUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    // Métodos de mapeamento manual

}