package io.jrb.labs.rtl433.ingester.service

import io.jrb.labs.commons.logging.LoggerDelegate
import io.jrb.labs.rtl433.ingester.datafill.EventMapper
import org.springframework.context.SmartLifecycle
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicBoolean

@Service
class DataIngesterService(
    private val mqttIngester: MqttIngester,
    private val eventMapper: EventMapper
) : SmartLifecycle {

    private val log by LoggerDelegate()

    private val _serviceName = javaClass.simpleName
    private val _running: AtomicBoolean = AtomicBoolean()

    init {
        log.info("Initializing {}...", _serviceName)
    }

    override fun start() {
        log.info("Starting {}...", _serviceName)
        mqttIngester.connect()
        mqttIngester.subscribe().subscribe { message ->
            log.info("Received: {}", message)
            val mapped = eventMapper.map(message)
            log.info("Mapped: {}", mapped)
        }
        _running.getAndSet(true)
    }

    override fun stop() {
        log.info("Stopping {}...", _serviceName)
        mqttIngester.disconnect()
        _running.getAndSet(false)
    }

    override fun isRunning(): Boolean {
        return _running.get()
    }

}