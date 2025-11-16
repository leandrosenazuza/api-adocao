package api_adocao.Config.Exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Configuração para servir imagens estáticas
        // Primeiro tenta do classpath (quando roda como JAR)
        // Depois tenta do sistema de arquivos (desenvolvimento)
        String currentDir = System.getProperty("user.dir");
        String filePath = "file:" + currentDir + "/src/main/resources/static/images/";
        
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images/", filePath)
                .setCachePeriod(3600);
    }
}
