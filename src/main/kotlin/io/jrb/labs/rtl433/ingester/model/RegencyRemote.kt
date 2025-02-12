package io.jrb.labs.rtl433.ingester.model

import java.time.Instant

data class RegencyRemote(

    override val device: Device? = null,

    val time: Instant? = null,

    override val model: String = MODEL,

    override val id: String? = null,

    val channel: Int? = null,

    val command: String? = null,

    val value: String? = null,

    val mic: String? = null

) : Rtl433Data {
    companion object {
        const val MODEL: String = "Regency-Remote"
    }
}
