package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class HyundaiTpms(

    override val device: Device? = null,

    val time: Instant? = null,

    override val model: String = MODEL,

    val type: String? = null,

    override val id: String? = null,

    val state: Int? = null,

    val flags: Int? = null,

    val repeat: Int? = null,

    @JsonProperty("pressure_kPa")
    val pressureKpa: Double? = null,

    @JsonProperty("temperature_C")
    val temperatureC: Double? = null,

    @JsonProperty("maybe_battery")
    val maybeBattery: Int? = null,

    val mic: String? = null

) : Rtl433Data {
    companion object {
        const val MODEL: String = "Hyundai-VDO"
    }
}
