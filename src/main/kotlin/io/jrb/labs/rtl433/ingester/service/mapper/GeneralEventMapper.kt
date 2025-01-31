package io.jrb.labs.rtl433.ingester.service.mapper

import io.jrb.labs.rtl433.ingester.datafill.MapperDatafill
import io.jrb.labs.rtl433.ingester.model.Device
import io.jrb.labs.rtl433.ingester.model.DscSecurity
import io.jrb.labs.rtl433.ingester.model.Rtl433Data
import io.jrb.labs.rtl433.ingester.model.SchraderTpms
import org.springframework.stereotype.Component

@Component
class GeneralEventMapper(
    private val datafill: MapperDatafill
): EventMapper {

    override fun map(inbound: Rtl433Data): Rtl433Data {
        return when (inbound) {
            is DscSecurity -> map(inbound)
            is SchraderTpms -> map(inbound)
            else -> inbound
        }
    }

    private fun map(inbound: DscSecurity): Rtl433Data {
        return if (datafill.dscSecurity.containsKey(inbound.id)) {
            inbound.copy(device = datafill.dscSecurity[inbound.id])
        } else {
            inbound.copy(device = Device.UNKNOWN_DEVICE)
        }
    }

    private fun map(inbound: SchraderTpms): Rtl433Data {
        return if (datafill.schraderTpms.containsKey(inbound.id)) {
            inbound.copy(device = datafill.dscSecurity[inbound.id])
        } else {
            inbound.copy(device = Device.UNKNOWN_DEVICE)
        }
    }

}