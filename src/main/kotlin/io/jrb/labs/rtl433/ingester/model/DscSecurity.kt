package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class DscSecurity(

    val device: Device?,

    val time: Instant?,

    override val model: String = MODEL,

    override val id: String?,

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

) : Rtl433Data {
    companion object {
        const val MODEL: String = "DSC-Security"
    }
}
