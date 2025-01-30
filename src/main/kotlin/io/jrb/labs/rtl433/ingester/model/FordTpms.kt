package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class FordTpms(

    val device: Device?,

    val time: Instant?,

    override val model: String = "Ford",

    val type: String?,

    override val id: String?,

    @JsonProperty("pressure_PSI")
    val pressureKpa: Double?,

    @JsonProperty("temperature_C")
    val temperatureC: Double?,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val moving: Boolean?,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val learn: Boolean?,

    val code: String?,

    val unknown: String?,

    @JsonProperty("unknown_3")
    val unknown3: String?,

    val mic: String?

) : Rtl433Data
