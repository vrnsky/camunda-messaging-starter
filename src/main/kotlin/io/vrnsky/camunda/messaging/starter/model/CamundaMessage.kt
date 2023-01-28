package io.vrnsky.camunda.messaging.starter.model

data class CamundaMessage(
    val businessKey: String,
    val messageName: String,
    val correlationKeys: Map<String, VariableType>,
    val processVariables: Map<String, VariableType>
) {
}