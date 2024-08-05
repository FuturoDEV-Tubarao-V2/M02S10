package br.com.futurodev.project_utilities.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI configureOpenAPI() {
        Contact contact = new Contact()
                .name("Ronyeri Marinho")
                .email("ronyerimarinho19@gmail.com")
                .url("https://www.linkedin.com/in/ronyeri-marinho/");

        Info info = new Info()
                .title("Minha API")
                .description("Uma descrição especial.")
                .version("1.0.0")
                .contact(contact);

        return new OpenAPI().components(new Components()).info(info);
    }
}
