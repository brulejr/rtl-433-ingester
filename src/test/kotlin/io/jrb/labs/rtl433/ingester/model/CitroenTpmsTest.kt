package io.jrb.labs.rtl433.ingester.model

import io.jrb.labs.commons.test.BeanPropertyMap
import io.jrb.labs.commons.test.BeanTestUtils
import kotlin.test.Test

class CitroenTpmsTest : BeanTestUtils {

    private val citroenTpmsMap : BeanPropertyMap = createBeanMapForTest(CitroenTpms::class)
    private val citroenTpms : CitroenTpms = createBeanFromMap(CitroenTpms::class, citroenTpmsMap)

    @Test
    fun shouldCreateBean() {
        validateBean(citroenTpms, citroenTpmsMap)
    }

}