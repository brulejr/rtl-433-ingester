package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class BmwGen3Tpms(

    override val model: String = "BMW-GEN3",

    override val id: String?,

    val time: Instant?,

    val deviceName: String?,

    val type: String?,

    val flags: String?,

    @JsonProperty("pressure_kPa")
    val pressureKpa: Double?,

    @JsonProperty("temperature_C")
    val temperatureC: Double?,

    val flags1: Int?,

    val flags2: Int?,

    val flags3: Int?,

    val msg: String?,

    val mic: String?

) : Rtl433Data
