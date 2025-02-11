package io.jrb.labs.commons.eventbus

import app.cash.turbine.test
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class EventBusTest : EventUtils {

    private lateinit var eventBus: EventBus

    @BeforeEach
    fun setup() {
        eventBus = EventBus()
    }

    @Test
    fun testEventBus_SingleEvent_SUCCESS() = runBlocking {
        val flow = eventBus.events().map { it.data }

        flow.test {
            val event = createDataEvent()
            eventBus.sendEvent(event)

            assertThat(awaitItem()).isEqualTo(event.data)
        }
    }

    @Test
    fun testEventBus_MultipleEvents_SUCCESS() = runBlocking {
        val flow = eventBus.events().map { it.data }

        flow.test {
            val event1 = createDataEvent()
            eventBus.sendEvent(event1)

            val event2 = createDataEvent()
            eventBus.sendEvent(event2)

            val event3 = createDataEvent()
            eventBus.sendEvent(event3)

            assertThat(awaitItem()).isEqualTo(event1.data)
            assertThat(awaitItem()).isEqualTo(event2.data)
            assertThat(awaitItem()).isEqualTo(event3.data)
        }
    }

    @Test
    fun testEventBus_MultipleEventsFiltered_SUCCESS() = runBlocking {
        val flow = eventBus.events(DataEvent::class).map { it.data }

        flow.test {
            val event1 = createDataEvent()
            eventBus.sendEvent(event1)

            val event2 = createSystemEvent()
            eventBus.sendEvent(event2)

            val event3 = createDataEvent()
            eventBus.sendEvent(event3)

            assertThat(awaitItem()).isEqualTo(event1.data)
            assertThat(awaitItem()).isEqualTo(event3.data)
        }
    }

}