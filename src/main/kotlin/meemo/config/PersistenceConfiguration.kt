package meemo.config

import org.mariadb.r2dbc.MariadbConnectionConfiguration
import org.mariadb.r2dbc.MariadbConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories


@Configuration
@EnableR2dbcRepositories
class PersistenceConfiguration(
        @Value("\${database.host}") private val databaseHostname: String,
        @Value("\${database.port}") private val databasePort: String,
        @Value("\${database.name}") private val databaseName: String,
        @Value("\${database.username}") private val databaseUsername: String,
        @Value("\${database.password}") private val databasePassword: String
) : AbstractR2dbcConfiguration() {

    @Bean
    override fun connectionFactory(): MariadbConnectionFactory {
        return MariadbConnectionFactory(MariadbConnectionConfiguration.builder()
                .host(databaseHostname)
                .port(databasePort.toInt())
                .username(databaseUsername)
                .password(databasePassword)
                .database(databaseName)
                .build())
    }

}
