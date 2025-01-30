package io.jrb.labs.rtl433.ingester.service.aggregator

import com.fasterxml.jackson.annotation.JsonProperty

class CollectionSummary {

    @JsonProperty("known")
    val knownMap = mutableMapOf<String, Int>()

    @JsonProperty("unknown")
    val unknownMap = mutableMapOf<String, Int>()

    fun known(key: String) {
        knownMap[key] = knownMap.getOrPut(key) { 0 }.inc()
    }

    fun unknown(key: String) {
        unknownMap[key] = unknownMap.getOrPut(key) { 0 }.inc()
    }

}