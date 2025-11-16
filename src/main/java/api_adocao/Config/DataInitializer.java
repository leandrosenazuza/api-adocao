package api_adocao.Config;

import api_adocao.Repository.EspecieRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.Connection;

@Configuration
public class DataInitializer {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EspecieRepository especieRepository;

    @PostConstruct
    public void init() {
        if (especieRepository.count() > 0) {
            return;
        }

        try {
            ClassPathResource script = new ClassPathResource("database/scripts.sql");
            try (Connection connection = dataSource.getConnection()) {
                ScriptUtils.executeSqlScript(connection, script);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao executar script de inicialização", e);
        }
    }
}

