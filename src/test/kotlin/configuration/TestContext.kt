package configuration

import app.theone.service.UserService
import org.mockito.Mockito
import org.springframework.context.annotation.Bean
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Configuration


@Configuration
open class TestContext {

    @Bean
    open fun messageSource(): MessageSource {
        val messageSource = ResourceBundleMessageSource()

        messageSource.setBasename("i18n/messages")
        messageSource.setUseCodeAsDefaultMessage(true)

        return messageSource
    }

    @Bean
    open fun userService(): UserService {
        return Mockito.mock(UserService::class.java)
    }
}