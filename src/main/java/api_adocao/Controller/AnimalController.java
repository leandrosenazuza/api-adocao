package api_adocao.Controller;

import api_adocao.Model.Animal;
import api_adocao.Model.DTO.AnimalDTO;
import api_adocao.Service.AnimalService;
import api_adocao.Util.Mapper.AnimalMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private final AnimalService animalService;
    private final AnimalMapper animalMapper;

    @Autowired
    public AnimalController(AnimalService animalService, AnimalMapper animalMapper) {
        this.animalService = animalService;
        this.animalMapper = animalMapper;
    }

    @GetMapping("/get/all")
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimal();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Animal> buscarAnimalPorId(@PathVariable Long id) {
        try {
            Animal animal = animalService.buscarAnimalPorId(id);
            return ResponseEntity.ok(animal);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Animal criarAnimal(@RequestBody AnimalDTO animalDTO) {
        return animalService.criarAnimal(animalDTO);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Animal>  atualizarAnimal(@PathVariable Long id, @RequestBody AnimalDTO animalDTO) {
        Animal animalAtualizado = animalService.atualizarAnimal(id, animalDTO);
        return ResponseEntity.ok(animalAtualizado);
    }

    @DeleteMapping("/delete/{id}")
    public void deletarAnimal(@PathVariable Long id) {
        animalService.deletarAnimal(id);
    }
}
