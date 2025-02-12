package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class FordTpms(

    override val device: Device? = null,

    val time: Instant? = null,

    override val model: String = MODEL,

    val type: String? = null,

    override val id: String? = null,

    @JsonProperty("pressure_PSI")
    val pressureKpa: Double? = null,

    @JsonProperty("temperature_C")
    val temperatureC: Double? = null,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val moving: Boolean? = null,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val learn: Boolean? = null,

    val code: String? = null,

    val unknown: String? = null,

    @JsonProperty("unknown_3")
    val unknown3: String? = null,

    val mic: String? = null

) : Rtl433Data {
    companion object {
        const val MODEL: String = "Ford"
    }
}
