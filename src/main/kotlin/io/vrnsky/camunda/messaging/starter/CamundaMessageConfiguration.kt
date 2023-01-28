package io.vrnsky.camunda.messaging.starter

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "camunda")
data class CamundaMessageConfiguration(
    val baseUrl: String = ""
)
