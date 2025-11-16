package api_adocao.Controller;

import api_adocao.Model.Request.RequestSolicitacaoAdocao;
import api_adocao.Model.Response.RetornoPadrao;
import api_adocao.Model.Response.RetornoPaginado;
import api_adocao.Model.Response.RetornoSolicitacao;
import api_adocao.Service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService solicitacaoService;

    @PostMapping("/solicitar/criar")
    public ResponseEntity<RetornoPadrao> solicitarAdocao(@RequestBody RequestSolicitacaoAdocao request){
        return ResponseEntity.ok(solicitacaoService.solicitarAdocao(request));
    }

    @GetMapping("/solicitar/listarTodas")
    public ResponseEntity<RetornoPaginado> solicitarLista(@RequestParam(value = "page") int page, @RequestParam(value="pageSize", defaultValue = "5") int pageSize){
        return ResponseEntity.ok(solicitacaoService.listarTodasAdocoesSolicitadas(page, pageSize));
    }

    @GetMapping("/solicitar/listarTodasSemPaginacao")
    public ResponseEntity<List<RetornoSolicitacao>> listarTodasSemPaginacao(){
        return ResponseEntity.ok(solicitacaoService.listarTodasSemPaginacao());
    }

    @DeleteMapping("/solicitar/apagar/{id}")
    public ResponseEntity<RetornoPadrao> apagarSolicitacao(@PathVariable(value = "id") int id){
        return ResponseEntity.ok(solicitacaoService.apagarSolicitacao(id));
    }

}
