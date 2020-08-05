package meemo.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.tags.Tag
import org.springdoc.core.GroupedOpenApi
import org.springframework.boot.info.BuildProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfiguration {

    @Bean
    fun meemoOpenApiInfo(buildProperties: BuildProperties) : OpenAPI? {
        return OpenAPI().info(
            Info()
                    .title("Meemo API")
                    .description("API description of the Meemo Service")
                    .license(License()
                            .name("GPLv3")
                            .url("https://www.gnu.org/licenses/gpl-3.0.txt")
                    )
                    .version(buildProperties.version)
                    .contact(Contact()
                            .name("Jens Meinecke")
                            .url("https://jensmeinecke.de")
                            .email("mail@jensmeinecke.de")
                    )
        )
    }
}
