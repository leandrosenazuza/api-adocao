package api_adocao.Controller;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.DTO.PorteDTO;
import api_adocao.Model.Porte;
import api_adocao.Service.PorteService;
import api_adocao.Util.Mapper.PorteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/porte")
public class PorteController {

    @Autowired
    private PorteService porteService;

    private PorteMapper porteMapper = new PorteMapper();

    @GetMapping("/get/all")
    public List<Porte> getAllAnimals() {
        return porteService.getAllPorte();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Porte> buscarPortePorId(@PathVariable Long id) {
        try {
            Porte porte = porteService.buscarPortePorId(id);
            return ResponseEntity.ok(porte);
        } catch(EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Porte criarPorte(@RequestBody PorteDTO porteDTO) {

        return porteService.criarPorte(porteMapper.toEntity(porteDTO));
    }

    @PutMapping("put/{id}")
    public ResponseEntity<Porte> atualizarPorte(@PathVariable Long id, @RequestBody PorteDTO porteDTO) {
        Porte porteAtualizada = porteService.atualizarPorte(id, porteMapper.toEntity(porteDTO));
        return ResponseEntity.ok(porteAtualizada);
    }

    @DeleteMapping("/delete/{id}")
    public void deletarPorte(@PathVariable Long id) {
        porteService.deletarPorte(id);
    }
}
