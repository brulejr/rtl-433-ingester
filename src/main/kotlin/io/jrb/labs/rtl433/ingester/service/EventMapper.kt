package io.jrb.labs.rtl433.ingester.service

import io.jrb.labs.rtl433.ingester.model.Rtl433Data

interface EventMapper {

    fun map(inbound: Rtl433Data): Rtl433Data

}