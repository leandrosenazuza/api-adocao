package api_adocao.Controller;

import api_adocao.Model.DTO.IotDataDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/iot")
public class IotController {

    private final Random random = new Random();
    
    private final String[] localizacoes = {
        "Abrigo Central - Setor A",
        "Abrigo Central - Setor B",
            "Abrigo Central - Setor C",
    };

    @GetMapping("/dados")
    public ResponseEntity<IotDataDTO> getDadosIot() {
        IotDataDTO dados = new IotDataDTO();
        
        double temperatura = 18.0 + (random.nextDouble() * 10.0);
        dados.setTemperatura(Math.round(temperatura * 100.0) / 100.0);
        
        double umidade = 40.0 + (random.nextDouble() * 40.0);
        dados.setUmidade(Math.round(umidade * 100.0) / 100.0);
        
        String localizacao = localizacoes[random.nextInt(localizacoes.length)];
        dados.setLocalizacao(localizacao);
        
        dados.setTimestamp(System.currentTimeMillis());
        
        return ResponseEntity.ok(dados);
    }

    @GetMapping("/dados/multiplos")
    public ResponseEntity<List<IotDataDTO>> getDadosIotMultiplos(@RequestParam(defaultValue = "3") int quantidade) {
        List<IotDataDTO> listaDados = new ArrayList<>();
        
        for (int i = 0; i < quantidade; i++) {
            IotDataDTO dados = new IotDataDTO();
            
            double temperatura = 18.0 + (random.nextDouble() * 10.0);
            dados.setTemperatura(Math.round(temperatura * 100.0) / 100.0);
            
            double umidade = 40.0 + (random.nextDouble() * 40.0);
            dados.setUmidade(Math.round(umidade * 100.0) / 100.0);
            
            String localizacao = localizacoes[random.nextInt(localizacoes.length)];
            dados.setLocalizacao(localizacao);
            
            dados.setTimestamp(System.currentTimeMillis());
            
            listaDados.add(dados);
        }
        
        return ResponseEntity.ok(listaDados);
    }
}

