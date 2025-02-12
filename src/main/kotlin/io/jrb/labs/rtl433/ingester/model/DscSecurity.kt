package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class DscSecurity(

    override val device: Device? = null,

    val time: Instant? = null,

    override val model: String = MODEL,

    override val id: String? = null,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val closed: Boolean? = null,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val event: Boolean? = null,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val tamper: Boolean? = null,

    @JsonProperty("battery_ok")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val batteryOk: Boolean? = null,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val xactivity: Boolean? = null,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val xtamper1: Boolean? = null,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val xtamper2: Boolean? = null,

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    val exception: Boolean? = null,

    val esn: String? = null,

    val status: Int? = null,

    @JsonProperty("status_hex")
    val statusHex: String? = null,

    val mic: String? = null

) : Rtl433Data {
    companion object {
        const val MODEL: String = "DSC-Security"
    }
}
