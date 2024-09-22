package api_adocao.Controller;

import api_adocao.Model.Comportamento;
import api_adocao.Service.ComportamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comportamento")
public class ComportamentoController {
    @Autowired
    private ComportamentoService comportamentoService;

    @GetMapping("/all")
    public List<Comportamento> getAllComportamentos() {
        return comportamentoService.getAllComportamentos();
    }

    @GetMapping("/{id}")
    public Comportamento getComportamentoById(@PathVariable Long id) {
        return comportamentoService.getComportamentoById(id);
    }

    @PostMapping
    public Comportamento createComportamento(@RequestBody Comportamento comportamento) {
        return comportamentoService.createComportamento(comportamento);
    }

    @PutMapping("/{id}")
    public Comportamento updateComportamento(@PathVariable Long id, @RequestBody Comportamento comportamento) {
        return comportamentoService.updateComportamento(id, comportamento);
    }

    @DeleteMapping("/{id}")
    public void deleteComportamento(@PathVariable Long id) {
        comportamentoService.deleteComportamento(id);
    }
}
