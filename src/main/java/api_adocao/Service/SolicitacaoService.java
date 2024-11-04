package api_adocao.Service;

import api_adocao.Model.Request.RequestSolicitacaoAdocao;
import api_adocao.Model.Response.RetornoPadrao;
import api_adocao.Model.Response.RetornoSolicitacao;
import api_adocao.Model.Solicitacao;
import api_adocao.Repository.SolicitacaoRepository;
import api_adocao.Util.Mapper.SolicitacaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private SolicitacaoMapper solicitacaoMapper;

    public RetornoPadrao solicitarAdocao(RequestSolicitacaoAdocao request) {
        Solicitacao solicitacao = solicitacaoMapper.requestToEntity(request);
        try{
            solicitacaoRepository.save(solicitacao);
            return new RetornoPadrao(true, "Solicitação realizada com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<RetornoSolicitacao> listarTodasAdocoesSolicitadas() {
        try{
            List<Solicitacao> listaSolicitacao = this.solicitacaoRepository.findAll();
            List<RetornoSolicitacao> retornoListaSolicitacao = this.solicitacaoMapper.entityListToResponseList(listaSolicitacao);
            return retornoListaSolicitacao;

        }catch (Exception e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
