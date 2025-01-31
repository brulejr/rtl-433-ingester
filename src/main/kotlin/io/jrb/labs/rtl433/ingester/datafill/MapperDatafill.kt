package io.jrb.labs.rtl433.ingester.datafill

import io.jrb.labs.rtl433.ingester.model.Device
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "application.ingester.mapper")
data class MapperDatafill(
    val dscSecurity: Map<String, Device>?,
    val schraderEG53MA4Tpms: Map<String, Device>?
)
