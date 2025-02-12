package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class BmwGen3Tpms(

    override val device: Device? = null,

    override val model: String = MODEL,

    override val id: String? = null,

    val time: Instant? = null,

    val type: String? = null,

    val flags: String? = null,

    @JsonProperty("pressure_kPa")
    val pressureKpa: Double? = null,

    @JsonProperty("temperature_C")
    val temperatureC: Double? = null,

    val flags1: Int? = null,

    val flags2: Int? = null,

    val flags3: Int? = null,

    val msg: String? = null,

    val mic: String? = null

) : Rtl433Data {
    companion object {
        const val MODEL: String = "BMW-GEN3"
    }
}
