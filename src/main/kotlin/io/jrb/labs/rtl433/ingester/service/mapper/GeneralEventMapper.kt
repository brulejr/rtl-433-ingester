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
        val myDatafill = datafill.dscSecurity
        return if (myDatafill != null && myDatafill.containsKey(inbound.id)) {
            inbound.copy(device = myDatafill[inbound.id])
        } else {
            inbound.copy(device = Device.UNKNOWN_DEVICE)
        }
    }

    private fun map(inbound: SchraderTpms): Rtl433Data {
        val myDatafill = datafill.schraderEG53MA4Tpms
        return if (myDatafill != null && myDatafill.containsKey(inbound.id)) {
            inbound.copy(device = myDatafill[inbound.id])
        } else {
            inbound.copy(device = Device.UNKNOWN_DEVICE)
        }
    }

}