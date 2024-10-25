package api_adocao.Controller;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.DTO.RacaDTO;
import api_adocao.Model.Especie;
import api_adocao.Model.Porte;
import api_adocao.Model.Raca;
import api_adocao.Repository.EspecieRepository;
import api_adocao.Repository.PorteRepository;
import api_adocao.Service.RacaService;
import api_adocao.Util.Mapper.RacaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/raca")
public class RacaController {

    private final RacaService racaService;
    private final RacaMapper racaMapper;
    private final EspecieRepository especieRepository;
    private final PorteRepository porteRepository;

    @Autowired
    public RacaController(RacaService racaService, RacaMapper racaMapper, EspecieRepository especieRepository, PorteRepository porteRepository) {
        this.racaService = racaService;
        this.racaMapper = racaMapper;
        this.especieRepository = especieRepository;
        this.porteRepository = porteRepository;
    }

    //private RacaMapper racaMapper = new RacaMapper();

    @GetMapping("/get/all")
    public List<Raca> getAllAnimals() {
        return racaService.getAllRaca();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Raca> buscarRacaPorId(@PathVariable Long id) {
        try {
            Raca raca = racaService.buscarRacaPorId(id);
            return ResponseEntity.ok(raca);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }
    /*
    @GetMapping("/get/especie/{especieId}")
    public List<Raca> buscarRacasPorEspecie(@PathVariable Long especieId) {
        return racaService.buscarRacasPorEspecie(especieId);
    }
    */
    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Raca criarRaca(@RequestBody RacaDTO racaDTO) {
        // Converte RacaDTO para Raca
        Raca raca = racaMapper.toEntity(racaDTO);

        // Busca a Especie e o Porte a partir dos IDs recebidos no DTO
        Especie especie = especieRepository.findById(racaDTO.getEspecieId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Espécie não encontrada"));

        Porte porte = porteRepository.findById(racaDTO.getPorteId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Porte não encontrado"));

        // Cria uma instância de Porte e define o ID
       // Porte porte = new Porte();
       // porte.setId(raca.getPorte().getId()); // Define o ID do Porte

        // Busca a Especie a partir do ID recebido
       // Especie especie = especieRepository.findById(raca.getEspecie().getId())
               // .orElseThrow(() -> new EntidadeNaoEncontradaException("Espécie não encontrada!"));

        // Associa a Especie e o Porte à Raca
        //raca.setEspecie(especie);
       // raca.setPorte(porte); // Associa o objeto Porte à raça

        // Cria uma instancia de Raca e define os atributos
        raca.setDescricaoRaca(racaDTO.getDescricaoRaca());
        raca.setEspecie(especie);
        raca.setPorte(porte);

        return racaService.criarRaca(raca);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Raca> atualizarRaca(@PathVariable Long id, @RequestBody RacaDTO racaDTO) {
            Raca racaAtualizada = racaService.atualizarRaca(id, racaMapper.toEntity(racaDTO));
            return ResponseEntity.ok(racaAtualizada);
    }

    @DeleteMapping("/delete/{id}")
    public void deletarRaca(@PathVariable Long id) {
        racaService.deletarRaca(id);
    }

    @GetMapping("/get/especie/{especieId}")
    public ResponseEntity<List<Raca>> buscarRacasPorEspecie(@PathVariable Long especieId) {
        List<Raca> racas  = racaService.buscarRacasPorEspecie(especieId);
        if (racas == null) {
            racas = new ArrayList<>();
        }
        return ResponseEntity.ok(racas);
    }
}
