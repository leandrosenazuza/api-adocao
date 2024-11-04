package api_adocao.Service;

import api_adocao.Exceptions.EntidadeNaoEncontradaException;
import api_adocao.Model.*;
import api_adocao.Model.DTO.AnimalDTO;
import api_adocao.Model.Request.SolicitacaoAdocaoRequest;
import api_adocao.Model.Response.RetornoNumeroTotalAdocao;
import api_adocao.Model.Response.RetornoPadrao;
import api_adocao.Repository.*;
import api_adocao.Util.Mapper.AnimalMapper;
import api_adocao.Util.Mapper.SolicitacaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service para gerenciar as operações relacionadas a animais.
@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AnimalMapper animalMapper;

    @Autowired
    private SolicitacaoMapper solicitacaoMapper;

    @Autowired
    private RacaRepository raceRepository;

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private ComportamentoRepository comportamentoRepository;

    @Autowired
    private CirurgiaRepository cirurgiaRepository;

    @Autowired
    private RacaRepository racaRepository;

    public Animal buscarAnimalPorId(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Animal não encontrado com ID: " + id));
    }

    public List<Animal> buscarAnimaisPorEspecie(Long especieId) {
        return animalRepository.findByRacaEspecieId(especieId);
    }

    public Animal criarAnimal(AnimalDTO animalDTO) {
        Animal animal = animalMapper.toEntity(animalDTO);
        return animalRepository.save(animal);
    }

    public Animal atualizarAnimal(Long id, AnimalDTO animalDTO) {
        Animal animalExistente = buscarAnimalPorId(id);

        //animalExistente.setDescricaoAnimal(animalAtualizado.getDescricaoAnimal());

        // Atualiza os atributos simples
        animalExistente.setNome(animalDTO.getNome());
        animalExistente.setIdade(animalDTO.getIdade());
        animalExistente.setCastrado(animalDTO.isCastrado());
        animalExistente.setVermifugado(animalDTO.isVermifugado());
        animalExistente.setVacinado(animalDTO.isVacinado());
        if(animalDTO.getCirurgiaId() != null) {
            Cirurgia novaCirurgia = cirurgiaRepository.findById(animalDTO.getCirurgiaId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Cirurgia não encontrada!"));
            animalExistente.setCirurgia(novaCirurgia);
        } else {
            animalExistente.setCirurgia(null);
        }
        animalExistente.setDescricaoAnimal(animalDTO.getDescricaoAnimal());
        animalExistente.setFoto(animalDTO.getFoto());

        // Atualiza as entidades relacionadas (Raca, Comportamento, Cirurgia)
        atualizarEntidadesRelacionadas(animalExistente, animalDTO);
        return animalRepository.save(animalExistente);
    }

    //Métodp auxiliar com visibilidade "protect"
    protected void atualizarEntidadesRelacionadas(Animal animal, AnimalDTO animalDTO) {
        Raca novaRaca = racaRepository.findById(animalDTO.getRacaId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Raça não encontrada!"));
        animal.setRaca(novaRaca);

        Comportamento novoComportamento = comportamentoRepository.findById(animalDTO.getComportamentoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Comportamento não encontrada!"));
        animal.setComportamento(novoComportamento);

        if(animalDTO.getCirurgiaId() != null) {
            Cirurgia novaCirurgia = cirurgiaRepository.findById(animalDTO.getCirurgiaId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Cirurgia não encontrada!"));
            animal.setCirurgia(novaCirurgia);
        } else {
            animal.setCirurgia(null);
        }
    }

    public void deletarAnimal(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Animal não encontrado com ID: " + id);
        }
        animalRepository.deleteById(id);
    }

    public List<Animal> getAllAnimal(){
        return animalRepository.findAll();
    }

    public RetornoNumeroTotalAdocao recuperarNumeroAniamisAdocao(){
        try{
            return new RetornoNumeroTotalAdocao(animalRepository.getNumeroAnimaisEsperandoAdocao());
        }catch (Error e){
            System.out.println("Erro ao buscar os animais");
            e.printStackTrace();
        }
        return new RetornoNumeroTotalAdocao(0);
    }

    public RetornoPadrao solicitarAdocao(SolicitacaoAdocaoRequest request) {
        Solicitacao solicitacao = solicitacaoMapper.requestToEntity(request);
        try{
            solicitacaoRepository.save(solicitacao);
            return new RetornoPadrao(true, "Solicitação realizada com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
