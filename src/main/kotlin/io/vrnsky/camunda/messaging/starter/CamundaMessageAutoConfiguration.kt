package io.vrnsky.camunda.messaging.starter

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(CamundaMessageConfiguration::class)
class CamundaMessageAutoConfiguration {

    @Bean
    fun createTemplate(properties: CamundaMessageConfiguration): CamundaMessageTemplate {
        return CamundaMessageTemplate(properties)
    }
}