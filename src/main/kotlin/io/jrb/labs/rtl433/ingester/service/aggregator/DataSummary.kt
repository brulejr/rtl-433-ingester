package io.jrb.labs.rtl433.ingester.service.aggregator

import io.jrb.labs.rtl433.ingester.model.DscSecurity
import io.jrb.labs.rtl433.ingester.model.Rtl433Data
import io.jrb.labs.rtl433.ingester.model.SchraderTpms

class DataSummary {

    val dscSecurity: CollectionSummary = CollectionSummary()
    val schraderTpms: CollectionSummary = CollectionSummary()

    fun aggregate(data: Rtl433Data) {
        when (data) {
            is DscSecurity -> processData(data)
            is SchraderTpms -> processData(data)
        }
    }

    private fun processData(message: DscSecurity) {
        if (message.device?.type == "UNKNOWN") {
            dscSecurity.unknown(message.id!!)
        } else {
            dscSecurity.known(message.device?.name!!)
        }
    }

    private fun processData(message: SchraderTpms) {
        if (message.device?.type == "UNKNOWN") {
            schraderTpms.unknown(message.id!!)
        } else {
            schraderTpms.known(message.device?.name!!)
        }
    }

}