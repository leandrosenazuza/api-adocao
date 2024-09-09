package api_adocao.Service;

import api_adocao.Model.Animal;
import api_adocao.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado!"));
    }

    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Long id, Animal animal) {
        if (animalRepository.existsById(id)) {
            animal.setId(id);
            return animalRepository.save(animal);
        } else {
            throw new RuntimeException("Animal não encontrado!");
        }
    }

    public void deleteAnimal(Long id) {
        if (animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
        } else {
            throw new RuntimeException("Animal não encontrado!");
        }
    }
}
