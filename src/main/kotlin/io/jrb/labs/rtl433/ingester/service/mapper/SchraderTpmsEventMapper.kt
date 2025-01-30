package io.jrb.labs.rtl433.ingester.service.mapper

import io.jrb.labs.rtl433.ingester.datafill.MapperDatafill
import io.jrb.labs.rtl433.ingester.model.Device
import io.jrb.labs.rtl433.ingester.model.Rtl433Data
import io.jrb.labs.rtl433.ingester.model.SchraderTpms
import org.springframework.stereotype.Component

@Component
class SchraderTpmsEventMapper(
    private val datafill: MapperDatafill
) : EventMapper {

    override fun map(inbound: Rtl433Data): Rtl433Data {
        return if (inbound is SchraderTpms) {
            if (datafill.schraderTpms.containsKey(inbound.id)) {
                inbound.copy(device = datafill.dscSecurity[inbound.id])
            } else {
                inbound.copy(device = Device.UNKNOWN_DEVICE)
            }
        } else {
            inbound
        }
    }

}