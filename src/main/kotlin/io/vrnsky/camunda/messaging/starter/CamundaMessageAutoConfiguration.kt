package io.vrnsky.camunda.messaging.starter

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

@AutoConfiguration
@ConditionalOnClass(CamundaMessageTemplate::class)
@EnableConfigurationProperties(CamundaMessageConfiguration::class)
class CamundaMessageAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    fun createTemplate(properties: CamundaMessageConfiguration): CamundaMessageTemplate {
        return CamundaMessageTemplate(properties)
    }
}