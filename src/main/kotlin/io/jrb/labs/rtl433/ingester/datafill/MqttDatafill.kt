package io.jrb.labs.rtl433.ingester.datafill

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "application.ingester.mqtt")
data class MqttDatafill(
    val brokerUrl: String,
    val clientId: String,
    val topic: String
)
