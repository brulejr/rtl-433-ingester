package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class SchraderEG53MA4Tpms(

    override val device: Device? = null,

    val time: Instant? = null,

    override val model: String = MODEL,

    val type: String? = null,

    val flags: String? = null,

    override val id: String? = null,

    @JsonProperty("pressure_kPa")
    val pressureKpa: Double? = null,

    @JsonProperty("temperature_F")
    val temperatureF: Double? = null,

    val mic: String? = null

) : Rtl433Data {
    companion object {
        const val MODEL: String = "Schrader-EG53MA4"
    }
}
