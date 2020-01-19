package meemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .description("Meemo Service API")
                        .title("Meemo Service API")
                        .description("API for controlling Meemo")
                        .version("0.2.0")
                        .contact(new Contact("Jens Meinecke", "https://jensmeinecke.de", "mail@jensmeinecke.de"))
                        .build())
                .genericModelSubstitutes(Mono.class)
                .ignoredParameterTypes(ServerWebExchange.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("meemo"))
                .paths(PathSelectors.any())
                .build();
    }
}
