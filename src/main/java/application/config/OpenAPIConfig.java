package application.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenApi(@Value("${custom-docs.title}")String apiTitle,
                                 @Value("${custom-docs.version}")String apiVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title(apiTitle)
                        .version(apiVersion));

    }

}
