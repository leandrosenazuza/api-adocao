package api_adocao.Controller;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.Raca;
import api_adocao.Service.RacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/raca")
public class RacaController {

    @Autowired
    private RacaService racaService;

    @GetMapping("/all")
    public List<Raca> getAllAnimals() {
        return racaService.getAllRaca();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Raca> buscarRacaPorId(@PathVariable Long id) {
        try {
            Raca raca = racaService.buscarRacaPorId(id);
            return ResponseEntity.ok(raca);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Raca criarRaca(@RequestBody Raca raca) {
        return racaService.criarRaca(raca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Raca> atualizarRaca(@PathVariable Long id, @RequestBody Raca raca) {
        try {
            Raca racaAtualizada = racaService.atualizarRaca(id, raca);
            return ResponseEntity.ok(racaAtualizada);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarRaca(@PathVariable Long id) {
        racaService.deletarRaca(id);
    }
}
