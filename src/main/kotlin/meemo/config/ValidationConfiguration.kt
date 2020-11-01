package meemo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.StandardReflectionParameterNameDiscoverer
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

// Workaround: https://github.com/spring-projects/spring-framework/issues/23152
// Bean Validation does not work with coroutines yet
@Configuration
class ValidationConfiguration {

    companion object {
        @Bean
        @Primary
        fun validator(): LocalValidatorFactoryBean {
            val factoryBean = LocalValidatorFactoryBean()
            factoryBean.setParameterNameDiscoverer(StandardReflectionParameterNameDiscoverer())
            return factoryBean
        }
    }
}
