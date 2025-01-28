package io.jrb.labs.rtl433.ingester.datafill

import io.jrb.labs.rtl433.ingester.model.Rtl433Data
import org.springframework.stereotype.Component

@Component
class EventMapper(
    private val datafill: MapperDatafill
) {

    fun map(inbound: Rtl433Data): Rtl433Data {
        return if (datafill.catalog.containsKey(inbound.id)) {
            inbound.copy(deviceName = datafill.catalog[inbound.id]!!)
        } else {
            inbound
        }
    }

}