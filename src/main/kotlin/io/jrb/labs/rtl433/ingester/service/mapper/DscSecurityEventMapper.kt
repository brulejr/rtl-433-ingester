package io.jrb.labs.rtl433.ingester.service.mapper

import io.jrb.labs.rtl433.ingester.datafill.MapperDatafill
import io.jrb.labs.rtl433.ingester.model.Device
import io.jrb.labs.rtl433.ingester.model.DscSecurity
import io.jrb.labs.rtl433.ingester.model.Rtl433Data
import org.springframework.stereotype.Component

@Component
class DscSecurityEventMapper(
    private val datafill: MapperDatafill
) : EventMapper {

    override fun map(inbound: Rtl433Data): Rtl433Data {
        return if (inbound is DscSecurity) {
            if (datafill.dscSecurity.containsKey(inbound.id)) {
                inbound.copy(device = datafill.dscSecurity[inbound.id])
            } else {
                inbound.copy(device = Device.UNKNOWN_DEVICE)
            }
        } else {
            inbound
        }
    }

}