package api_adocao.Controller;

import api_adocao.Model.EstatisticaMunicipio;
import api_adocao.Model.DTO.EstatisticaMunicipioDTO;
import api_adocao.Model.DTO.EstatisticasGeraisDTO;
import api_adocao.Service.EstatisticaMunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {

    @Autowired
    private EstatisticaMunicipioService estatisticaMunicipioService;

    @GetMapping("/municipios")
    public ResponseEntity<List<EstatisticaMunicipioDTO>> getEstatisticasMunicipios() {
        List<EstatisticaMunicipio> estatisticas = estatisticaMunicipioService.getAllEstatisticas();
        List<EstatisticaMunicipioDTO> dtos = estatisticas.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/gerais")
    public ResponseEntity<EstatisticasGeraisDTO> getEstatisticasGerais() {
        List<EstatisticaMunicipio> estatisticas = estatisticaMunicipioService.getAllEstatisticas();
        
        EstatisticasGeraisDTO gerais = new EstatisticasGeraisDTO();
        
        double totalAdocoes = estatisticas.stream()
                .mapToDouble(EstatisticaMunicipio::getAdocoesAnuais)
                .sum();
        
        double totalCastracoes = estatisticas.stream()
                .mapToDouble(EstatisticaMunicipio::getCastracoesAnuais)
                .sum();
        
        double totalRecolhimentos = estatisticas.stream()
                .mapToDouble(EstatisticaMunicipio::getRecolhimentos)
                .sum();
        
        double mediaTaxaAbandono = estatisticas.stream()
                .mapToDouble(EstatisticaMunicipio::getTaxaAbandono)
                .average()
                .orElse(0.0);
        
        gerais.setTotalAdocoes(totalAdocoes);
        gerais.setTotalCastracoes(totalCastracoes);
        gerais.setTotalRecolhimentos(totalRecolhimentos);
        gerais.setMediaTaxaAbandono(mediaTaxaAbandono);
        
        return ResponseEntity.ok(gerais);
    }

    private EstatisticaMunicipioDTO toDTO(EstatisticaMunicipio estatistica) {
        EstatisticaMunicipioDTO dto = new EstatisticaMunicipioDTO();
        dto.setMunicipio(estatistica.getMunicipio());
        dto.setAdocoesAnuais(estatistica.getAdocoesAnuais());
        dto.setCastracoesAnuais(estatistica.getCastracoesAnuais());
        dto.setRecolhimentos(estatistica.getRecolhimentos());
        dto.setTaxaAbandono(estatistica.getTaxaAbandono());
        return dto;
    }
}
