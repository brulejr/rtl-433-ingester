package io.jrb.labs.rtl433.ingester

import io.jrb.labs.rtl433.ingester.datafill.MapperDatafill
import io.jrb.labs.rtl433.ingester.datafill.MqttDatafill
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(MapperDatafill::class, MqttDatafill::class)
class Rtl433IngesterApplication

fun main(args: Array<String>) {
	runApplication<Rtl433IngesterApplication>(*args)
}
