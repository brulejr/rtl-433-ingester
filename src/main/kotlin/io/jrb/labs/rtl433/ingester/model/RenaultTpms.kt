package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class RenaultTpms(

    val device: Device?,

    val time: Instant?,

    override val model: String = MODEL,

    val type: String?,

    override val id: String?,

    val flags: String?,

    @JsonProperty("pressure_kPa")
    val pressureKpa: Double?,

    @JsonProperty("temperature_C")
    val temperatureC: Double?,

    val mic: String?

) : Rtl433Data {
    companion object {
        const val MODEL: String = "Renault"
    }
}
