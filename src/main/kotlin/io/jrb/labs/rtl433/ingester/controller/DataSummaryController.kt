package io.jrb.labs.rtl433.ingester.controller

import io.jrb.labs.rtl433.ingester.service.aggregator.DataAggregatorService
import io.jrb.labs.rtl433.ingester.service.aggregator.DataSummary
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DataSummaryController(
    private val dataAggregatorService: DataAggregatorService
) {

    @GetMapping("/summary")
    fun getDataSummary(): DataSummary {
        return dataAggregatorService.getDataSummary()
    }

}