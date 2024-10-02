package api_adocao.Controller;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.DTO.EspecieDTO;
import api_adocao.Model.Especie;
import api_adocao.Service.EspecieService;
import api_adocao.Util.Mapper.EspecieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especie")
public class EspecieController {

    @Autowired
    private EspecieService especieService;

    private EspecieMapper especieMapper = new EspecieMapper();

    @GetMapping("/all")
    public List<Especie> getAllAnimals() {
        return especieService.getAllEspecie();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especie> buscarEspeciePorId(@PathVariable Long id) {
        try {
            Especie especie = especieService.buscarEspeciePorId(id);
            return ResponseEntity.ok(especie);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Especie criarEspecie(@RequestBody EspecieDTO especieDTO) {
        return especieService.criarEspecie(especieMapper.toEntity(especieDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especie> atualizarEspecie(@PathVariable Long id, @RequestBody Especie especie) {
        try {
            Especie especieAtualizada = especieService.atualizarEspecie(id, especie);
            return ResponseEntity.ok(especieAtualizada);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void deletarEspecie(@PathVariable Long id) {
        especieService.deletarEspecie(id);
    }
}
