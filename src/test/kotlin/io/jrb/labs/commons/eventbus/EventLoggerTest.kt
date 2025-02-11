package io.jrb.labs.commons.eventbus

import app.cash.turbine.test
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.system.CapturedOutput
import org.springframework.boot.test.system.OutputCaptureExtension

@ExtendWith(OutputCaptureExtension::class)
class EventLoggerTest : EventUtils {

    private lateinit var eventBus: EventBus
    private lateinit var eventLogger: EventLogger

    @BeforeEach
    fun setup() {
        eventBus = EventBus()
        eventLogger = EventLogger(eventBus)
    }

    @Test
    fun testEventLogger_SUCCESS(output: CapturedOutput) = runBlocking {
        val flow = eventBus.events().map { it.data }

        flow.test {
            val event1 = createDataEvent()
            eventBus.sendEvent(event1)

            val event2 = createSystemEvent()
            eventBus.sendEvent(event2)

            assertThat(awaitItem()).isEqualTo(event1.data)
            assertThat(output.all).contains("INFO io.jrb.labs.commons.eventbus.EventLogger -- DataEvent::$event1")

            assertThat(awaitItem()).isEqualTo(event2.data)
            assertThat(output.all).contains("WARN io.jrb.labs.commons.eventbus.EventLogger -- $event2")
        }
    }

}