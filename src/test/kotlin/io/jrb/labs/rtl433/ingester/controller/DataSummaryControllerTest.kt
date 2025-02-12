package io.jrb.labs.rtl433.ingester.controller

import io.jrb.labs.commons.logging.LoggerDelegate
import io.jrb.labs.commons.test.TestUtils
import io.jrb.labs.rtl433.ingester.model.Device
import io.jrb.labs.rtl433.ingester.model.DscSecurity
import io.jrb.labs.rtl433.ingester.service.aggregator.DataAggregatorService
import io.jrb.labs.rtl433.ingester.service.aggregator.DataSummary
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.web.reactive.server.WebTestClient
import kotlin.test.Test

@ExtendWith(MockKExtension::class)
class DataSummaryControllerTest : TestUtils {

    private val log by LoggerDelegate()

    private lateinit var dataAggregatorService: DataAggregatorService

    private lateinit var dataSummaryController: DataSummaryController
    private lateinit var webTestClient: WebTestClient

    private lateinit var mockSummary: DataSummary

    private lateinit var data1: DscSecurity
    private lateinit var data2: DscSecurity

    @BeforeEach
    fun setup() {
        dataAggregatorService = mockk()
        dataSummaryController = DataSummaryController(dataAggregatorService)

        webTestClient = WebTestClient.bindToController(dataSummaryController).build()

        mockSummary = DataSummary()
        data1 = DscSecurity(id = randomString())
        mockSummary.aggregate(data1)
        data2 = DscSecurity(id = randomString(), device = Device("A", "TYPE", "AREA"))
        mockSummary.aggregate(data2)

        every { dataAggregatorService.getDataSummary() } returns mockSummary
    }

    @Test
    fun testGetDataSummary_SUCCESS() {
        webTestClient.get().uri("/summary")
            .exchange()
            .expectAll(
                { spec -> spec.expectStatus().isOk },
                { spec -> spec.expectBody(DataSummary::class.java).consumeWith { response -> log.info("{}", response )} },
                { spec -> spec.expectBody()
                    .jsonPath("$.summary['DSC-Security'].unknown").isEqualTo(mapOf(data1.id to 1))
                    .jsonPath("$.summary['DSC-Security'].known").isEqualTo(mapOf(data2.device?.name to 1))
                }
            )
    }

}