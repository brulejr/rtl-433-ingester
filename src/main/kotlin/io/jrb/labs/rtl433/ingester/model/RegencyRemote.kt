package io.jrb.labs.rtl433.ingester.model

import java.time.Instant

data class RegencyRemote(

    val device: Device?,

    val time: Instant?,

    override val model: String = MODEL,

    override val id: String?,

    val channel: Int?,

    val command: String?,

    val value: String?,

    val mic: String?

) : Rtl433Data {
    companion object {
        const val MODEL: String = "Regency-Remote"
    }
}
