package rh.javapleno.colaborador.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info =
@io.swagger.v3.oas.annotations.info.Info(
        title = "RH Colaborador API", version = "v1",
        description = "Documentação Serviço de Colaboradores"))
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info());
    }

}
