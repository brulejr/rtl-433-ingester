package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class SchraderTpms(

    override val model: String = "Schrader-EG53MA4",

    override val id: String?,

    val time: Instant?,

    val deviceName: String?,

    val type: String?,

    val flags: String?,

    @JsonProperty("pressure_kPa")
    val pressureKpa: Double,

    @JsonProperty("temperature_F")
    val temperatureF: Double,

    val mic: String?

) : Rtl433Data
