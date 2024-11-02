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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/raca")
public class RacaController {

    private static final Logger log = LoggerFactory.getLogger(RacaController.class);

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

    @GetMapping("/get/all")
    public List<Raca> getAllRacas() {
        log.info("Buscando todas as raças"); // Log para registrar a ação
        return racaService.getAllRaca();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Raca> buscarRacaPorId(@PathVariable Long id) {
        try {
            log.info("Buscando raça por ID: {}", id); // Log com o ID buscado
            Raca raca = racaService.buscarRacaPorId(id);
            return ResponseEntity.ok(raca);
        } catch (EntidadeNaoEncontradaException e) {
            log.warn("Raça com ID {} não encontrada", id); // Log de aviso
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Raca criarRaca(@RequestBody RacaDTO racaDTO) {
        try {
            log.debug("Dados da raça recebidos no Controller: {}", racaDTO);

            Raca raca = racaMapper.toEntity(racaDTO);

            log.debug("Entidade Raça após o mapeamento: {}", raca);

            Especie especie = especieRepository.findById(racaDTO.getEspecieId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Espécie não encontrada"));
            log.debug("Espécie encontrada: {}", especie);

            Porte porte = porteRepository.findById(racaDTO.getPorteId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Porte não encontrado"));
            log.debug("Porte encontrado: {}", porte);

            raca.setEspecie(especie);
            raca.setPorte(porte);

            Raca racaSalva = racaService.criarRaca(raca);
            log.debug("Raça criada no banco: {}", racaSalva);

            return racaSalva;
        } catch (Exception e) {
            log.error("Erro ao criar raça", e); // Log do erro com stack trace
            throw e; // Relança a exceção para o GlobalExceptionHandler
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Raca> atualizarRaca(@PathVariable Long id, @RequestBody RacaDTO racaDTO) {
        try {
            log.info("Atualizando raça com ID: {}", id); // Log com o ID atualizado
            Raca racaAtualizada = racaService.atualizarRaca(id, racaMapper.toEntity(racaDTO));
            return ResponseEntity.ok(racaAtualizada);
        } catch (EntidadeNaoEncontradaException e) {
            log.warn("Raça com ID {} não encontrada para atualização", id); // Log de aviso
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/delete/{id}")
    public void deletarRaca(@PathVariable Long id) {
        racaService.deletarRaca(id);
    }


    @GetMapping("/get/especie/{especieId}")
    public ResponseEntity<List<Raca>> buscarRacasPorEspecie(@PathVariable Long especieId) {
        List<Raca> racas = racaService.buscarRacasPorEspecie(especieId);
        return ResponseEntity.ok(racas);
    }
}