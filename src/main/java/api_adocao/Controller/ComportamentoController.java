package api_adocao.Controller;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.Comportamento;
import api_adocao.Model.DTO.ComportamentoDTO;
import api_adocao.Service.ComportamentoService;
import api_adocao.Util.Mapper.ComportamentoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comportamento")
public class ComportamentoController {

    @Autowired
    private ComportamentoService comportamentoService;

    private ComportamentoMapper comportamentoMapper = new ComportamentoMapper();

    @GetMapping("/get/all")
    public List<Comportamento> getAllAnimais() {
        return comportamentoService.getAllComportamentos();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Comportamento> buscarComportamenPorById(@PathVariable Long id) {
        try {
            Comportamento comportamento = comportamentoService.buscarComportamentoPorId(id);
            return ResponseEntity.ok(comportamento);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Comportamento criarComportamento(@RequestBody ComportamentoDTO comportamentoDTO) {
        return comportamentoService.criarComportamento(comportamentoMapper.toEntity(comportamentoDTO));
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Comportamento> atualizarComportamento(@PathVariable Long id, @RequestBody ComportamentoDTO comportamentoDTO) {
        Comportamento comportamentoAtualizado = comportamentoService.atualizarComportamento(id, comportamentoMapper.toEntity(comportamentoDTO));
        return ResponseEntity.ok(comportamentoAtualizado);
    }

    @DeleteMapping("/delete/{id}")
    public void deletarComportamento(@PathVariable Long id) {
        comportamentoService.deletarComportamento(id);
    }
}
