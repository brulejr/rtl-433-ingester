package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class SchraderEG53MA4Tpms(

    override val device: Device?,

    val time: Instant?,

    override val model: String = MODEL,

    val type: String?,

    val flags: String?,

    override val id: String?,

    @JsonProperty("pressure_kPa")
    val pressureKpa: Double,

    @JsonProperty("temperature_F")
    val temperatureF: Double,

    val mic: String?

) : Rtl433Data {
    companion object {
        const val MODEL: String = "Schrader-EG53MA4"
    }
}
