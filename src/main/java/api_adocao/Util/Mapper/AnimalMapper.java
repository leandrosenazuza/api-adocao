package api_adocao.Util.Mapper;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.*;
import api_adocao.Model.DTO.AnimalDTO;
import api_adocao.Repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnimalMapper {

    private final RacaRepository racaRepository;
    private final ComportamentoRepository comportamentoRepository;
    private final CirurgiaRepository cirurgiaRepository;
    private final EspecieRepository especieRepository;
    private final PorteRepository porteRepository;

    @Autowired
    public AnimalMapper(RacaRepository racaRepository, ComportamentoRepository comportamentoRepository,
                        CirurgiaRepository cirurgiaRepository, EspecieRepository especieRepository,
                        PorteRepository porteRepository) {
        this.racaRepository = racaRepository;
        this.comportamentoRepository = comportamentoRepository;
        this.cirurgiaRepository = cirurgiaRepository;
        this.especieRepository = especieRepository;
        this.porteRepository = porteRepository;
    }

    public AnimalDTO toDTO(Animal animal) {
        if (animal != null) {
            AnimalDTO animalDTO = new AnimalDTO();
            animalDTO.setId(animal.getId());
            animalDTO.setNome(animal.getNome());
            animalDTO.setIdade(animal.getIdade());
            animalDTO.setRacaId(animal.getRaca().getId());
            animalDTO.setSexo(animal.getSexo().name());
            animalDTO.setComportamentoId(animal.getComportamento().getId());

            if (animal.getCirurgia() != null) {
                animalDTO.setCirurgiaId(animal.getCirurgia().getId());
            }

            animalDTO.setCastrado(animal.isCastrado());
            animalDTO.setVermifugado(animal.isVermifugado());
            animalDTO.setVacinado(animal.isVacinado());

            animalDTO.setCirurgia(animal.getCirurgia() != null);

            animalDTO.setDescricaoAnimal(animal.getDescricaoAnimal());
            animalDTO.setFoto(animal.getFoto());
            return animalDTO;
        }
        return null;
    }

    public Animal toEntity(AnimalDTO animalDTO) {
        if (animalDTO != null) {
            Animal animal = new Animal();
            animal.setNome(animalDTO.getNome());
            animal.setIdade(animalDTO.getIdade());
            animal.setCastrado(animalDTO.isCastrado());
            animal.setVermifugado(animalDTO.isVermifugado());
            animal.setVacinado(animalDTO.isVacinado());
            animalDTO.setCirurgia(animal.getCirurgia() != null);
            animal.setDescricaoAnimal(animalDTO.getDescricaoAnimal());
            animal.setFoto(animalDTO.getFoto());

            Raca raca = racaRepository.findById(animalDTO.getRacaId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Raça não encontrada!"));
            animal.setRaca(raca);

            try {
                Sexo sexoEnum = Sexo.valueOf(animalDTO.getSexo());
                animal.setSexo(sexoEnum);
            } catch (IllegalArgumentException e) {
                log.error("Valor inválido para sexo: {}", animalDTO.getSexo(), e);
                throw new EntidadeNaoEncontradaException("Valor de sexo inválido");
            }

            Comportamento comportamento = comportamentoRepository.findById(animalDTO.getComportamentoId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Comportamento não encontrado!"));
            animal.setComportamento(comportamento);

            if (animalDTO.getCirurgiaId() != null) {
                Cirurgia cirurgia = cirurgiaRepository.findById(animalDTO.getCirurgiaId())
                        .orElseThrow(() -> new EntidadeNaoEncontradaException("Cirurgia não encontrada!"));
                animal.setCirurgia(cirurgia);
            }

            return animal;
        }
        return null;
    }
}
