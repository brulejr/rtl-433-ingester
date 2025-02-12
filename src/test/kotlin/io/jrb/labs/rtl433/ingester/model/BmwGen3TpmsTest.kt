package io.jrb.labs.rtl433.ingester.model

import io.jrb.labs.commons.test.BeanPropertyMap
import io.jrb.labs.commons.test.BeanTestUtils
import kotlin.test.Test

class BmwGen3TpmsTest : BeanTestUtils {

    private val bmwGen3TpmsMap : BeanPropertyMap = createBeanMapForTest(BmwGen3Tpms::class)
    private val bmwGen3Tpms : BmwGen3Tpms = createBeanFromMap(BmwGen3Tpms::class, bmwGen3TpmsMap)

    @Test
    fun shouldCreateBean() {
        validateBean(bmwGen3Tpms, bmwGen3TpmsMap)
    }

}