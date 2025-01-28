package io.jrb.labs.rtl433.ingester.model

import java.time.Instant

data class RegencyRemote(

    override val model: String = "Regency-Remote",

    override val id: String?,

    val time: Instant?,

    val deviceName: String?,

    val channel: Int?,

    val command: String?,

    val value: String?,

    val mic: String?

) : Rtl433Data
