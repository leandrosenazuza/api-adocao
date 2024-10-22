package api_adocao.Controller;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.DTO.RacaDTO;
import api_adocao.Model.Raca;
import api_adocao.Service.RacaService;
import api_adocao.Util.Mapper.RacaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/raca")
public class RacaController {

    private final RacaService racaService;
    private final RacaMapper racaMapper;

    @Autowired
    public RacaController(RacaService racaService, RacaMapper racaMapper) {
        this.racaService = racaService;
        this.racaMapper = racaMapper;
    }

    //private RacaMapper racaMapper = new RacaMapper();

    @GetMapping("/get/all")
    public List<Raca> getAllAnimals() {
        return racaService.getAllRaca();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Raca> buscarRacaPorId(@PathVariable Long id) {
        try {
            Raca raca = racaService.buscarRacaPorId(id);
            return ResponseEntity.ok(raca);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get/especie/{especieId}")
    public List<Raca> buscarRacasPorEspecie(@PathVariable Long especieId) {
        return racaService.buscarRacasPorEspecie(especieId);
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Raca criarRaca(@RequestBody Raca raca) {

        return racaService.criarRaca(raca);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Raca> atualizarRaca(@PathVariable Long id, @RequestBody RacaDTO racaDTO) {
            Raca racaAtualizada = racaService.atualizarRaca(id, racaMapper.toEntity(racaDTO));
            return ResponseEntity.ok(racaAtualizada);
    }

    @DeleteMapping("/delete/{id}")
    public void deletarRaca(@PathVariable Long id) {
        racaService.deletarRaca(id);
    }
}
