package api_adocao.Controller;

import api_adocao.Model.DTO.IotDataDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/iot")
public class IotController {

    private final Random random = new Random();
    
    // Localizações possíveis para os sensores
    private final String[] localizacoes = {
        "Abrigo Central - Setor A",
        "Abrigo Central - Setor B",
        "Abrigo Norte",
        "Abrigo Sul",
        "Centro de Triagem",
        "Quarentena - Bloco 1",
        "Quarentena - Bloco 2",
        "Área de Recuperação"
    };

    @GetMapping("/dados")
    public ResponseEntity<IotDataDTO> getDadosIot() {
        IotDataDTO dados = new IotDataDTO();
        
        // Gerar temperatura aleatória entre 18°C e 28°C
        double temperatura = 18.0 + (random.nextDouble() * 10.0);
        dados.setTemperatura(Math.round(temperatura * 100.0) / 100.0);
        
        // Gerar umidade aleatória entre 40% e 80%
        double umidade = 40.0 + (random.nextDouble() * 40.0);
        dados.setUmidade(Math.round(umidade * 100.0) / 100.0);
        
        // Selecionar localização aleatória
        String localizacao = localizacoes[random.nextInt(localizacoes.length)];
        dados.setLocalizacao(localizacao);
        
        // Timestamp atual
        dados.setTimestamp(System.currentTimeMillis());
        
        return ResponseEntity.ok(dados);
    }

    @GetMapping("/dados/multiplos")
    public ResponseEntity<List<IotDataDTO>> getDadosIotMultiplos(@RequestParam(defaultValue = "3") int quantidade) {
        List<IotDataDTO> listaDados = new ArrayList<>();
        
        for (int i = 0; i < quantidade; i++) {
            IotDataDTO dados = new IotDataDTO();
            
            // Gerar temperatura aleatória entre 18°C e 28°C
            double temperatura = 18.0 + (random.nextDouble() * 10.0);
            dados.setTemperatura(Math.round(temperatura * 100.0) / 100.0);
            
            // Gerar umidade aleatória entre 40% e 80%
            double umidade = 40.0 + (random.nextDouble() * 40.0);
            dados.setUmidade(Math.round(umidade * 100.0) / 100.0);
            
            // Selecionar localização aleatória
            String localizacao = localizacoes[random.nextInt(localizacoes.length)];
            dados.setLocalizacao(localizacao);
            
            // Timestamp atual
            dados.setTimestamp(System.currentTimeMillis());
            
            listaDados.add(dados);
        }
        
        return ResponseEntity.ok(listaDados);
    }
}

