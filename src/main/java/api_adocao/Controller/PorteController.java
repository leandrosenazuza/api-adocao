package api_adocao.Controller;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.Porte;
import api_adocao.Service.PorteService;
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

    @GetMapping("/all")
    public List<Porte> getAllAnimals() {
        return porteService.getAllPorte();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Porte> buscarPortePorId(@PathVariable Long id) {
        try {
            Porte porte = porteService.buscarPortePorId(id);
            return ResponseEntity.ok(porte);
        } catch(EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Porte criarPorte(@RequestBody Porte porte) {
        return porteService.criarPorte(porte);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Porte> atualizarPorte(@PathVariable Long id, @RequestBody Porte porte) {
        try {
            Porte porteAtualizado = porteService.atualizarPorte(id, porte);
            return  ResponseEntity.ok(porteAtualizado);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorte(@PathVariable Long id) {
        porteService.deletarPorte(id);
    }
}
