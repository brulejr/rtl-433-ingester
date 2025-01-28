package io.jrb.labs.rtl433.ingester.datafill

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "application.ingester.mapper")
data class MapperDatafill(
    val catalog: Map<String, String>
)
