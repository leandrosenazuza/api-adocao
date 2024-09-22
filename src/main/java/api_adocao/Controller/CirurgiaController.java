package api_adocao.Controller;

import api_adocao.Model.Cirurgia;
import api_adocao.Service.CirurgiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cirurgia")
public class CirurgiaController {
    @Autowired
    private CirurgiaService cirurgiaService;

    @GetMapping("/all")
    public List<Cirurgia> getAllCirurgias() {
        return cirurgiaService.getAllCirurgias();
    }

    @GetMapping("/{id}")
    public Cirurgia getCirurgiaById(@PathVariable Long id) {
        return cirurgiaService.getCirurgiaById(id);
    }

    @PostMapping
    public Cirurgia createCirurgia(@RequestBody Cirurgia cirurgia) {
        return cirurgiaService.createCirurgia(cirurgia);
    }

    @PutMapping("/{id}")
    public Cirurgia updateCirurgia(@PathVariable Long id, @RequestBody Cirurgia cirurgia) {
        return cirurgiaService.updateCirurgia(id, cirurgia);
    }

    @DeleteMapping("/{id}")
    public void deleteCirurgia(@PathVariable Long id) {
        cirurgiaService.deleteCirurgia(id);
    }
}
