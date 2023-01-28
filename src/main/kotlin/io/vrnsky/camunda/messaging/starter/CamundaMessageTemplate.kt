package io.vrnsky.camunda.messaging.starter

import io.vrnsky.camunda.messaging.starter.model.CamundaMessage
import lombok.extern.slf4j.Slf4j
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.DefaultUriBuilderFactory

class CamundaMessageTemplate(
    baseUrl: String
) {
    private val log = LoggerFactory.getLogger(this.javaClass)

    var restTemplate: RestTemplate? = null

    init {
        restTemplate = RestTemplateBuilder()
            .uriTemplateHandler(DefaultUriBuilderFactory(baseUrl))
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()
    }

    fun message(message: CamundaMessage) {
        log.info("Sending message {}", message)
        val httpEntity: HttpEntity<CamundaMessage> = HttpEntity<CamundaMessage>(message)
        restTemplate?.postForObject("/message", httpEntity, Unit.javaClass)
    }
}