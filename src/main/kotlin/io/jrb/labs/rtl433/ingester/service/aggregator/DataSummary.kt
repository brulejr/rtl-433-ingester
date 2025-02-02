package io.jrb.labs.rtl433.ingester.service.aggregator

import io.jrb.labs.rtl433.ingester.model.Rtl433Data

class DataSummary {

    val summary: MutableMap<String, CollectionSummary> = mutableMapOf()

    fun aggregate(data: Rtl433Data) {
        val model = data.model
        if (!summary.containsKey(model)) { summary[model] = CollectionSummary() }
        if (data.device?.type == null || data.device?.type == "UNKNOWN") {
            summary[model]?.unknown(data.id!!)
        } else {
            summary[model]?.known(data.device?.name!!)
        }
    }

}