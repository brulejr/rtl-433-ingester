package io.jrb.labs.commons.eventbus

import io.jrb.labs.commons.test.TestUtils

interface EventUtils : TestUtils {

    fun createDataEvent(): DataEvent<String> {
        return DataEvent(
            source = randomString(),
            name = randomString(),
            data = randomString()
        )
    }

    fun createSystemEvent(): SystemEvent {
        return SystemEvent(name = randomString())
    }

}