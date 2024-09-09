package api_adocao.Controller;

import api_adocao.Model.Animal;
import api_adocao.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal not found"));
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        if (animalRepository.existsById(id)) {
            animal.setId(id);
            return animalRepository.save(animal);
        } else {
            throw new RuntimeException("Animal not found");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        if (animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
        } else {
            throw new RuntimeException("Animal not found");
        }
    }
}