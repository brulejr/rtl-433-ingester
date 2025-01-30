package io.jrb.labs.rtl433.ingester.config

import io.jrb.labs.commons.eventbus.EventBus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationJavaConfig {

    @Bean
    fun eventBus() = EventBus()

}