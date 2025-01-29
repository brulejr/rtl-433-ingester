package io.jrb.labs.rtl433.ingester.service.ingester

import io.jrb.labs.commons.logging.LoggerDelegate
import io.jrb.labs.rtl433.ingester.service.mapper.DscSecurityEventMapper
import io.jrb.labs.rtl433.ingester.service.mqtt.MqttManager
import org.springframework.context.SmartLifecycle
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicBoolean

@Service
class DataIngesterService(
    private val mqttManager: MqttManager,
    private val dscSecurityEventMapper: DscSecurityEventMapper
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
            .subscribe { message ->
                log.info("Received: {}", message)
            }
        _running.getAndSet(true)
    }

    override fun stop() {
        log.info("Stopping {}...", _serviceName)
        mqttManager.disconnect()
        _running.getAndSet(false)
    }

    override fun isRunning(): Boolean {
        return _running.get()
    }

}