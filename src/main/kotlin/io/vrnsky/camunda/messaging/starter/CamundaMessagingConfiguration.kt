package io.vrnsky.camunda.messaging.starter

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "camunda")
class CamundaMessagingConfiguration {
    var baseUrl: String = ""


    @Bean
    fun createTemplate(): CamundaMessageTemplate {
        return CamundaMessageTemplate(baseUrl)
    }

}