package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant
import java.util.*

data class DscSecurity(

    override val model: String = "DSC-Security",

    override val id: String?,

    val time: Instant?,

    val deviceName: String?,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val closed: Boolean?,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val event: Boolean?,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val tamper: Boolean?,

    @JsonProperty("battery_ok")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val batteryOk: Boolean?,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val xactivity: Boolean?,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val xtamper1: Boolean?,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val xtamper2: Boolean?,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val exception: Boolean?,

    val esn: String?,

    val status: Int?,

    @JsonProperty("status_hex")
    val statusHex: String?,

    val mic: String?

) : Rtl433Data
