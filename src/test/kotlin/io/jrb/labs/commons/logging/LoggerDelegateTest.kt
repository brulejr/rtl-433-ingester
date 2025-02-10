package io.jrb.labs.commons.logging

import io.jrb.labs.common.test.TestUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.system.CapturedOutput
import org.springframework.boot.test.system.OutputCaptureExtension

@ExtendWith(OutputCaptureExtension::class)
class LoggerDelegateTest : TestUtils {

    private val log by LoggerDelegate()

    @Test
    fun testLoggerDelegate(output: CapturedOutput) {
        log.info("TEST")

        assertThat(output.all).contains("[Test worker] INFO io.jrb.labs.commons.logging.LoggerDelegateTest -- TEST")
    }

}