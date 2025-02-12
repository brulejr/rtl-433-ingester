package io.jrb.labs.rtl433.ingester.model

import io.jrb.labs.commons.test.BeanPropertyMap
import io.jrb.labs.commons.test.BeanTestUtils
import kotlin.test.Test

class FordTpmsTest : BeanTestUtils {

    private val fordTpmsMap : BeanPropertyMap = createBeanMapForTest(FordTpms::class)
    private val fordTpms : FordTpms = createBeanFromMap(FordTpms::class, fordTpmsMap)

    @Test
    fun shouldCreateBean() {
        validateBean(fordTpms, fordTpmsMap)
    }

}