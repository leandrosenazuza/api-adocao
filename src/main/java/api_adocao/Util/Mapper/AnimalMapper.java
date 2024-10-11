package api_adocao.Util.Mapper;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.Animal;
import api_adocao.Model.Cirurgia;
import api_adocao.Model.Comportamento;
import api_adocao.Model.DTO.AnimalDTO;
import api_adocao.Model.Raca;
import api_adocao.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            animalDTO.setComportamentoId(animal.getComportamento().getId());

            // Verificando se há cirurgia associada
            if (animal.getCirurgia() != null) {
                animalDTO.setCirurgiaId(animal.getCirurgia().getId());
            }

            animalDTO.setCastrado(animal.isCastrado());
            animalDTO.setVermifugado(animal.isVermifugado());
            animalDTO.setVacinado(animal.isVacinado());

            // Definindo isCirurgia no DTO com base na existência da Cirurgia
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

            // Busca e associa as entidades relacionadas
            Raca raca = racaRepository.findById(animalDTO.getRacaId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Raça não encontrada!"));
            animal.setRaca(raca);

            Comportamento comportamento = comportamentoRepository.findById(animalDTO.getComportamentoId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Comportamento não encontrado!"));
            animal.setComportamento(comportamento);

            // Correção: Busca a Cirurgia pelo ID (se houver)
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
