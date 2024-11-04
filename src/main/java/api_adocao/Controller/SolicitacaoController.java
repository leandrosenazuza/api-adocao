package api_adocao.Controller;

import api_adocao.Model.Request.RequestSolicitacaoAdocao;
import api_adocao.Model.Response.RetornoPadrao;
import api_adocao.Model.Response.RetornoSolicitacao;
import api_adocao.Service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<RetornoSolicitacao>> solicitarLista(){
        return ResponseEntity.ok(solicitacaoService.listarTodasAdocoesSolicitadas());
    }

}
