package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class AcuriteTower(

    override val device: Device? = null,

    override val model: String = MODEL,

    val time: Instant? = null,

    override val id: String? = null,

    val channel: String? = null,

    @JsonProperty("battery_ok")
    val batteryOk: Boolean? = null,

    @JsonProperty("temperature_C")
    val temperatureC: Double? = null,

    val humidity: Int? = null,

    val mic: String? = null

) : Rtl433Data {
    companion object {
        const val MODEL: String = "Acurite-Tower"
    }
}
