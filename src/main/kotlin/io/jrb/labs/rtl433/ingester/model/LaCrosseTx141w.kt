package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class LaCrosseTx141w(

    override val device: Device? = null,

    override val model: String = MODEL,

    val time: Instant? = null,

    override val id: String? = null,

    val channel: String? = null,

    @JsonProperty("battery_ok")
    val batteryOk: Boolean? = null,

    @JsonProperty("wind_avg_km_h")
    val windAvgKmH: Int? = null,

    @JsonProperty("wind_dir_deg")
    val windDirDeg: Int? = null,

    val test: Int? = null,

    val mic: String? = null

) : Rtl433Data {
    companion object {
        const val MODEL: String = "LaCrosse-TX141W"
    }
}
