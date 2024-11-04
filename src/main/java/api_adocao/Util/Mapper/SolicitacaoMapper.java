package api_adocao.Util.Mapper;

import api_adocao.Model.Animal;
import api_adocao.Model.DTO.AnimalDTO;
import api_adocao.Model.Request.RequestSolicitacaoAdocao;
import api_adocao.Model.Response.RetornoSolicitacao;
import api_adocao.Model.Solicitacao;
import api_adocao.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SolicitacaoMapper {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private AnimalMapper animalMapper;

    public Solicitacao requestToEntity(RequestSolicitacaoAdocao request) {
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setTelefoneInteressado(request.getTelefoneInteressado());
        solicitacao.setEmailInteressado(request.getEmailInteressado());
        solicitacao.setNomeInteressado(request.getNomeInteressado());

        Animal animal = animalRepository.findById(request.getAnimalId()).orElse(null);

        if(animal != null) {
            solicitacao.setAnimal(animal);
        }

        return solicitacao;
    }

    public RetornoSolicitacao entityToResponse(Solicitacao solicitacao) {
        RetornoSolicitacao retornoSolicitacao = new RetornoSolicitacao();
        retornoSolicitacao.setId(solicitacao.getId());
        retornoSolicitacao.setEmailInteressado(solicitacao.getEmailInteressado());
        retornoSolicitacao.setTelefoneInteressado(solicitacao.getTelefoneInteressado());
        retornoSolicitacao.setNomeInteressado(solicitacao.getNomeInteressado());
        Animal animal = animalRepository.findById(solicitacao.getAnimal().getId()).orElse(null);
        AnimalDTO animalDTO = animalMapper.toDTO(animal);
        retornoSolicitacao.setAnimalDTO(animalDTO);

        return retornoSolicitacao;
    }

    public List<RetornoSolicitacao> entityListToResponseList(List<Solicitacao> listaSolicitacao) {
        List<RetornoSolicitacao> listaRetornoSolicitacao = listaSolicitacao.stream().map(
                solicitacao -> {
                    return entityToResponse(solicitacao);
                }
        ).toList();
        return listaRetornoSolicitacao;
    }
}
