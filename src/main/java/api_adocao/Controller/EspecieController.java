package api_adocao.Controller;

import api_adocao.Model.Animal;
import api_adocao.Model.Especie;
import api_adocao.Service.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/especie")
public class EspecieController {

    @Autowired
    private EspecieService especieService;

    @GetMapping("/all")
    public List<Especie> getAllAnimals() {
        return especieService.getAllEspecie();
    }
}
