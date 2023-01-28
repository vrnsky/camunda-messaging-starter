package io.vrnsky.camunda.messaging.starter

import io.vrnsky.camunda.messaging.starter.model.CamundaMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.DefaultUriBuilderFactory


class CamundaMessageTemplate(
    properties: CamundaMessageConfiguration
) {
    val logger: Logger = LoggerFactory.getLogger(CamundaMessageTemplate::class.java)

    var restTemplate: RestTemplate? = null

    init {
        logger.info("baseUrl obtained from configs = {}", properties.baseUrl)
        restTemplate = RestTemplateBuilder()
            .uriTemplateHandler(DefaultUriBuilderFactory(properties.baseUrl))
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()
    }

    fun message(message: CamundaMessage) {
        val httpEntity: HttpEntity<CamundaMessage> = HttpEntity<CamundaMessage>(message)
        restTemplate?.postForObject("/message", httpEntity, Unit.javaClass)
    }
}