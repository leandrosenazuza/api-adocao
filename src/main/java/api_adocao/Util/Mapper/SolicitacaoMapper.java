package api_adocao.Util.Mapper;

import api_adocao.Model.Animal;
import api_adocao.Model.Request.SolicitacaoAdocaoRequest;
import api_adocao.Model.Solicitacao;
import api_adocao.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolicitacaoMapper {

    @Autowired
    private AnimalRepository animalRepository;

    public Solicitacao requestToEntity(SolicitacaoAdocaoRequest request) {
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
}
