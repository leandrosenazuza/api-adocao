package api_adocao.Service;

import api_adocao.Model.Request.RequestSolicitacaoAdocao;
import api_adocao.Model.Response.RetornoPadrao;
import api_adocao.Model.Response.RetornoPaginado;
import api_adocao.Model.Response.RetornoSolicitacao;
import api_adocao.Model.Solicitacao;
import api_adocao.Repository.SolicitacaoRepository;
import api_adocao.Util.Mapper.SolicitacaoMapper;
import api_adocao.Util.Paginacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public RetornoPaginado listarTodasAdocoesSolicitadas(int page, int pageSize) {
        try{
            Pageable pageable = PageRequest.of(page, pageSize);
            Page<Solicitacao> listaSolicitacao = this.solicitacaoRepository.listaSolicitacoes(pageable);
            List<RetornoSolicitacao> retornoListaSolicitacao = this.solicitacaoMapper.entityListToResponseList(listaSolicitacao.getContent());
            int totalPages = Paginacao.getTotalPages(pageSize, solicitacaoRepository.getTotalSolicitacoes());
            return new RetornoPaginado(retornoListaSolicitacao, pageable.getPageNumber(), pageable.getPageSize(), totalPages, retornoListaSolicitacao.size());

        }catch (Exception e){
            e.printStackTrace();
        }
        return new RetornoPaginado();
    }


    public RetornoPadrao apagarSolicitacao(int id) {
        try {
            if(solicitacaoRepository.existsById(id)){
                solicitacaoRepository.deleteById(id);
                return new RetornoPadrao(true, "Registro apagado com sucesso!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new RetornoPadrao(false, "Erro ao apagar registro");
    }
}
