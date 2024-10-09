package api_adocao.Controller;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.Cirurgia;
import api_adocao.Model.DTO.CirurgiaDTO;
import api_adocao.Service.CirurgiaService;
import api_adocao.Util.Mapper.CirurgiaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cirurgia")
public class CirurgiaController {
    @Autowired
    private CirurgiaService cirurgiaService;

    private CirurgiaMapper cirurgiaMapper = new CirurgiaMapper();

    @GetMapping("/get/all")
    public List<Cirurgia> getAllAnimals() {
        return cirurgiaService.getAllCirurgia();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Cirurgia> buscarCirurgiaPorId(@PathVariable Long id) {
        try {
            Cirurgia cirurgia = cirurgiaService.buscarCirurgiaPorId(id);
            return ResponseEntity.ok(cirurgia);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Cirurgia criarCirurgia(@RequestBody CirurgiaDTO cirurgiaDTO) {
        return cirurgiaService.criarCirurgia(cirurgiaMapper.toEntity(cirurgiaDTO));
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Cirurgia> atualizarCirurgia(@PathVariable Long id, @RequestBody CirurgiaDTO cirurgiaDTO) {
        Cirurgia cirurgiaAtualizada = cirurgiaService.atualizarCirurgia(id, cirurgiaMapper.toEntity(cirurgiaDTO));
        return ResponseEntity.ok(cirurgiaAtualizada);
    }

    @DeleteMapping("/delete/{id}")
    public void deletarCirurgia(@PathVariable Long id) {
        cirurgiaService.deletarCirurgia(id);
    }
}
