package api_adocao.Util.Mapper;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.Animal;
import api_adocao.Model.Cirurgia;
import api_adocao.Model.Comportamento;
import api_adocao.Model.DTO.AnimalDTO;
import api_adocao.Model.Raca;
import api_adocao.Repository.CirurgiaRepository;
import api_adocao.Repository.ComportamentoRepository;
import api_adocao.Repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnimalMapper {

    private final RacaRepository racaRepository;
    private final ComportamentoRepository comportamentoRepository;
    private final CirurgiaRepository cirurgiaRepository;

    @Autowired
    public AnimalMapper(RacaRepository racaRepository, ComportamentoRepository comportamentoRepository, CirurgiaRepository cirurgiaRepository) {
        this.racaRepository = racaRepository;
        this.comportamentoRepository = comportamentoRepository;
        this.cirurgiaRepository = cirurgiaRepository;
    }

    public AnimalDTO toDTO(Animal animal) {
        if(animal != null) {
            AnimalDTO animalDTO = new AnimalDTO();
            animalDTO.setId(animal.getId());
            animalDTO.setNome(animal.getNome());
            animalDTO.setIdade(animal.getIdade());
            animalDTO.setRacaId(animal.getRaca().getId());
            animalDTO.setComportamentoId(animal.getComportamento().getId());
            if(animal.getCirurgia() != null) {
                animalDTO.setCirurgiaId(animal.getCirurgia().getId());
            }
            animalDTO.setCastrado(animal.isCastrado());
            animalDTO.setVermifugado(animal.isVermifugado());
            animalDTO.setVacinado(animal.isVacinado());
            animalDTO.setCirurgia(animal.isCirurgia());
            animalDTO.setDescricaoAnimal(animal.getDescricaoAnimal());
            animalDTO.setFoto(animal.getFoto());
            return animalDTO;
        }
        return null;
    }

    public Animal toEntity(AnimalDTO animalDTO) {
        if(animalDTO != null) {
            Animal animal = new Animal();
            animal.setNome(animalDTO.getNome());
            animal.setIdade(animalDTO.getIdade());

            Raca raca = racaRepository.findById(animalDTO.getRacaId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Raça não encontrada!"));
            animal.setRaca(raca);

            Comportamento comportamento = comportamentoRepository.findById(animalDTO.getComportamentoId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Comportamento não encontrado!"));
            animal.setComportamento(comportamento);

            if (animalDTO.getCirurgiaId() != null) {
                Cirurgia cirurgia = cirurgiaRepository.findById(animalDTO.getCirurgiaId())
                        .orElseThrow(() -> new EntidadeNaoEncontradaException("Cirurgia não encontrada!"));
                animal.setCirurgia(cirurgia);
            }

            animal.setCastrado(animalDTO.isCastrado());
            animal.setVermifugado(animalDTO.isVermifugado());
            animal.setVacinado(animalDTO.isVacinado());
            animal.setCirurgia(animalDTO.isCirurgia());
            animal.setDescricaoAnimal(animalDTO.getDescricaoAnimal());
            animal.setFoto(animalDTO.getFoto());

            return animal;
        }
        return null;
    }
}
