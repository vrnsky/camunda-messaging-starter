package io.vrnsky.camunda.messaging.starter.model

data class ProcessVariable(
    val value: String,
    val type: VariableType
) {
}