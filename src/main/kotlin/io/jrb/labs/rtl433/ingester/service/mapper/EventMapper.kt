package io.jrb.labs.rtl433.ingester.service.mapper

import io.jrb.labs.rtl433.ingester.model.Rtl433Data

interface EventMapper {

    fun map(inbound: Rtl433Data): Rtl433Data

}