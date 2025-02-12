package io.jrb.labs.rtl433.ingester.model

import io.jrb.labs.commons.test.BeanPropertyMap
import io.jrb.labs.commons.test.BeanTestUtils
import kotlin.test.Test

class HyundaiTpmsTest : BeanTestUtils {

    private val hyundaiTpmsMap : BeanPropertyMap = createBeanMapForTest(HyundaiTpms::class)
    private val hyundaiTpms : HyundaiTpms = createBeanFromMap(HyundaiTpms::class, hyundaiTpmsMap)

    @Test
    fun shouldCreateBean() {
        validateBean(hyundaiTpms, hyundaiTpmsMap)
    }

}