package io.jrb.labs.rtl433.ingester.service.aggregator

import io.jrb.labs.commons.eventbus.DataEvent
import io.jrb.labs.commons.eventbus.EventBus
import io.jrb.labs.commons.eventbus.SystemEvent
import io.jrb.labs.commons.logging.LoggerDelegate
import io.jrb.labs.rtl433.ingester.messages.DataMessage
import io.jrb.labs.rtl433.ingester.model.Rtl433Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.springframework.context.SmartLifecycle
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicBoolean

@Service
class DataAggregatorService(
    private val eventBus: EventBus
): SmartLifecycle {

    private val log by LoggerDelegate()

    private val _serviceName = javaClass.simpleName
    private val _running: AtomicBoolean = AtomicBoolean()

    private val _scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    private val dataSummary: DataSummary = DataSummary()

    init {
        log.info("Initializing {}...", _serviceName)
        _scope.launch {
            eventBus.events(DataEvent::class)
                .filter { it.data is DataMessage }
                .map { processEvent(it.data as DataMessage) }
                .collectLatest { log.info("Aggregated: {}", it) }
        }
    }

    override fun start() {
        log.info("Starting {}...", _serviceName)
        eventBus.sendEvent(SystemEvent("service.start", _serviceName))
        _running.getAndSet(true)
    }

    override fun stop() {
        log.info("Stopping {}...", _serviceName)
        eventBus.sendEvent(SystemEvent("service.stop", _serviceName))
        _running.getAndSet(false)
    }

    override fun isRunning(): Boolean {
        return _running.get()
    }

    fun getDataSummary(): DataSummary {
        return dataSummary
    }

    private fun processEvent(message: DataMessage): DataMessage {
        dataSummary.aggregate(message.payload as Rtl433Data)
        return message
    }

}