package api_adocao.Service;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.Animal;
import api_adocao.Model.DTO.AnimalDTO;
import api_adocao.Repository.AnimalRepository;
import api_adocao.Util.Mapper.AnimalMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

    @Mock
    private AnimalRepository animalRepository;

    @Mock
    private AnimalMapper animalMapper;

    @InjectMocks
    private AnimalService animalService;

    private Animal animal;
    private AnimalDTO animalDTO;

    @BeforeEach
    void setUp() {
        animal = new Animal();
        animal.setId(1L);
        animal.setNome("Rex");
        animal.setIdade(3);

        animalDTO = new AnimalDTO();
        animalDTO.setNome("Rex");
        animalDTO.setIdade(3);
        animalDTO.setRacaId(1L);
        animalDTO.setComportamentoId(1L);
    }

    @Test
    void testBuscarAnimalPorId_Success() {
        when(animalRepository.findById(1L)).thenReturn(Optional.of(animal));

        Animal resultado = animalService.buscarAnimalPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Rex", resultado.getNome());
        verify(animalRepository, times(1)).findById(1L);
    }

    @Test
    void testBuscarAnimalPorId_NotFound() {
        when(animalRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(EntidadeNaoEncontradaException.class, () -> {
            animalService.buscarAnimalPorId(999L);
        });
    }

    @Test
    void testGetAllAnimal() {
        Animal animal2 = new Animal();
        animal2.setId(2L);
        animal2.setNome("Luna");

        List<Animal> animais = Arrays.asList(animal, animal2);
        when(animalRepository.findAll()).thenReturn(animais);

        List<Animal> resultado = animalService.getAllAnimal();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(animalRepository, times(1)).findAll();
    }

    @Test
    void testDeletarAnimal_Success() {
        when(animalRepository.existsById(1L)).thenReturn(true);
        doNothing().when(animalRepository).deleteById(1L);

        animalService.deletarAnimal(1L);

        verify(animalRepository, times(1)).existsById(1L);
        verify(animalRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeletarAnimal_NotFound() {
        when(animalRepository.existsById(999L)).thenReturn(false);

        assertThrows(EntidadeNaoEncontradaException.class, () -> {
            animalService.deletarAnimal(999L);
        });
    }
}

