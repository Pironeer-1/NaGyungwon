package week3.week3.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Pironeer Week3 hw API 명세서",
                description = "API 명세서",
                version = "v1",
                contact = @Contact(
                        name = "나경원",
                        email = "nkw601@gmail.com"
                )
        )
)
@Configuration
public class OpenApiConfig {
}
