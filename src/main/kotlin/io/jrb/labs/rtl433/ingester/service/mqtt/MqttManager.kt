package io.jrb.labs.rtl433.ingester.service.mqtt

import com.fasterxml.jackson.databind.ObjectMapper
import io.jrb.labs.commons.logging.LoggerDelegate
import io.jrb.labs.rtl433.ingester.datafill.MqttDatafill
import io.jrb.labs.rtl433.ingester.model.Rtl433Data
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class MqttManager(
    private val datafill: MqttDatafill,
    private val objectMapper: ObjectMapper
) {

    private val log by LoggerDelegate()

    private var mqttClient: MqttClient? = null

    fun connect() {
        mqttClient = MqttClient(datafill.brokerUrl, datafill.clientId)
        val options = MqttConnectOptions()
        mqttClient?.connect(options)
    }

    fun disconnect() {
        mqttClient?.disconnect()
    }

    fun source(): String {
        return "MQTT"
    }

    fun subscribe(): Flux<Rtl433Data> {
        return Flux.create { sink ->
            mqttClient?.subscribe(datafill.topic) { _, message ->
                try {
                    val payload = String(message.payload)
                    val data = objectMapper.readValue(payload, Rtl433Data::class.java)
                    sink.next(data)
                } catch (e: Exception) {
                    log.error(e.message, e)
                }
            }
        }
    }

    fun topic(): String {
        return datafill.topic
    }

}