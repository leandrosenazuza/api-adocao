package api_adocao.Controller;

import api_adocao.Model.Animal;
import api_adocao.Model.DTO.AnimalDTO;
import api_adocao.Model.Response.RetornoNumeroTotalAdocao;
import api_adocao.Service.AnimalService;
import api_adocao.Util.Mapper.AnimalMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/animal")
public class AnimalController {


    private final AnimalService animalService;

    private final AnimalMapper animalMapper;


    public AnimalController(AnimalService animalService, AnimalMapper animalMapper) {
        this.animalService = animalService;
        this.animalMapper = animalMapper;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<AnimalDTO>> getAllAnimals() {
        List<Animal> animais = animalService.getAllAnimal();
        List<AnimalDTO> animaisDTO = animais.stream()
                .map(animal -> animalMapper.toDTO(animal))
                .collect(Collectors.toList());
        return ResponseEntity.ok(animaisDTO);
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

    @GetMapping("/get/especie/{especieId}")
    public ResponseEntity<List<Animal>> buscarAnimalPorEspecie(@PathVariable Long especieId) {
        try {
            List<Animal> animais = animalService.buscarAnimaisPorEspecie(especieId);
            return ResponseEntity.ok(animais);
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

    @GetMapping("/animaisAdocao")
    public ResponseEntity<RetornoNumeroTotalAdocao> getAnimaisAdocao(){
        return ResponseEntity.ok(animalService.recuperarNumeroAniamisAdocao());
    }


}
