package meemo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authorization.AuthorizationDecision
import org.springframework.security.authorization.ReactiveAuthorizationManager
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authorization.AuthorizationContext
import reactor.core.publisher.Mono


@Configuration
@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    fun authentication(): ReactiveUserDetailsService? {
        val builder: User.UserBuilder = User.withDefaultPasswordEncoder()
        return MapReactiveUserDetailsService(
                builder.username("john").password("pw").roles("ADMIN").build(),
                builder.username("maggie").password("pw").roles().build(),
                builder.username("lenny").password("pw").roles().build(),
                builder.username("roger").password("pw").roles("ADMIN").build())
    }

    @Bean
    fun authorization(http: ServerHttpSecurity) : SecurityWebFilterChain {
        val am = ReactiveAuthorizationManager { auth: Mono<Authentication>, ctx: AuthorizationContext ->
            auth
                    .map { authentication: Authentication ->
                        val author = ctx.variables["author"]
                        val matchesAuthor = authentication.name == author
                        val isAdmin = authentication.authorities.stream()
                                .anyMatch { ga: GrantedAuthority? -> ga!!.authority.contains("ROLE_ADMIN") }
                        matchesAuthor || isAdmin
                    }
                    .map { granted: Boolean? -> AuthorizationDecision(granted!!) }
        }
        return http
                .httpBasic()
                .and()
                .authorizeExchange()
                .pathMatchers("/books/{author}").access(am)
                .anyExchange().hasRole("ADMIN")
                .and()
                .build()
    }
}