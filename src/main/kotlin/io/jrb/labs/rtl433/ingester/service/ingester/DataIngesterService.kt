package io.jrb.labs.rtl433.ingester.service.ingester

import io.jrb.labs.commons.eventbus.DataEvent
import io.jrb.labs.commons.eventbus.EventBus
import io.jrb.labs.commons.eventbus.SystemEvent
import io.jrb.labs.commons.logging.LoggerDelegate
import io.jrb.labs.rtl433.ingester.messages.DataMessage
import io.jrb.labs.rtl433.ingester.messages.DataMessageType
import io.jrb.labs.rtl433.ingester.model.Rtl433Data
import io.jrb.labs.rtl433.ingester.service.mapper.DscSecurityEventMapper
import io.jrb.labs.rtl433.ingester.service.mqtt.MqttManager
import org.springframework.context.SmartLifecycle
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicBoolean

@Service
class DataIngesterService(
    private val mqttManager: MqttManager,
    private val dscSecurityEventMapper: DscSecurityEventMapper,
    private val eventBus: EventBus
) : SmartLifecycle {

    private val log by LoggerDelegate()

    private val _serviceName = javaClass.simpleName
    private val _running: AtomicBoolean = AtomicBoolean()

    init {
        log.info("Initializing {}...", _serviceName)
    }

    override fun start() {
        log.info("Starting {}...", _serviceName)
        mqttManager.connect()
        mqttManager.subscribe()
            .map { dscSecurityEventMapper.map(it) }
            .subscribe { data -> processMessage(data) }
        eventBus.sendEvent(SystemEvent("service.start", _serviceName))
        _running.getAndSet(true)
    }

    override fun stop() {
        log.info("Stopping {}...", _serviceName)
        mqttManager.disconnect()
        eventBus.sendEvent(SystemEvent("service.stop", _serviceName))
        _running.getAndSet(false)
    }

    override fun isRunning(): Boolean {
        return _running.get()
    }

    private fun processMessage(data: Rtl433Data) {
        val message = DataMessage(
            type = DataMessageType.DATA,
            source = mqttManager.source(),
            topic = mqttManager.topic(),
            payload = data
        )
        eventBus.sendEvent(DataEvent(message.source, message.getPayloadType(), message))
    }

}