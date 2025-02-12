package io.jrb.labs.rtl433.ingester.model

import io.jrb.labs.commons.test.BeanPropertyMap
import io.jrb.labs.commons.test.BeanTestUtils
import kotlin.test.Test

class RenaultTpmsTest : BeanTestUtils {

    private val renaultTpmsMap : BeanPropertyMap = createBeanMapForTest(RenaultTpms::class)
    private val renaultTpms : RenaultTpms = createBeanFromMap(RenaultTpms::class, renaultTpmsMap)

    @Test
    fun shouldCreateBean() {
        validateBean(renaultTpms, renaultTpmsMap)
    }

}