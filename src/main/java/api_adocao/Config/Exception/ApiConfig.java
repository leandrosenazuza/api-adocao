package api_adocao.Config.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class ApiConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(ApiConfig.class);

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String currentDir = System.getProperty("user.dir");
        String separator = File.separator;
        
        String staticImagesPath = "file:" + currentDir + separator + "src" + separator + "main" + separator + "resources" + separator + "static" + separator + "images" + separator;
        String assetsPath = "file:" + currentDir + separator + "assets" + separator;
        
        logger.info("Configurando handlers de recursos estáticos:");
        logger.info("Diretório atual: {}", currentDir);
        logger.info("Caminho imagens estáticas: {}", staticImagesPath);
        logger.info("Caminho assets: {}", assetsPath);
        
        File assetsDir = new File(currentDir + separator + "assets");
        File staticImagesDir = new File(currentDir + separator + "src" + separator + "main" + separator + "resources" + separator + "static" + separator + "images");
        
        logger.info("Diretório assets existe: {}", assetsDir.exists());
        logger.info("Diretório static/images existe: {}", staticImagesDir.exists());
        
        registry.addResourceHandler("/images/**")
                .addResourceLocations(
                    "classpath:/static/images/", 
                    staticImagesPath,
                    assetsPath
                )
                .setCachePeriod(3600);
        
        registry.addResourceHandler("/assets/**")
                .addResourceLocations(assetsPath)
                .setCachePeriod(3600);
    }
}
