package io.jrb.labs.rtl433.ingester.service.aggregator

import io.jrb.labs.rtl433.ingester.model.DscSecurity
import io.jrb.labs.rtl433.ingester.model.Rtl433Data

class DataSummary {

    val dscSecurity: CollectionSummary = CollectionSummary()

    fun aggregate(data: Rtl433Data) {
        when (data) {
            is DscSecurity -> processDscSecurity(data)
        }
    }

    private fun processDscSecurity(message: DscSecurity) {
        if (message.device?.type == "UNKNOWN") {
            dscSecurity.unknown(message.id!!)
        } else {
            dscSecurity.known(message.device?.name!!)
        }
    }

}