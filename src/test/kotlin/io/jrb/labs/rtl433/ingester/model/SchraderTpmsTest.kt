package io.jrb.labs.rtl433.ingester.model

import io.jrb.labs.commons.test.BeanPropertyMap
import io.jrb.labs.commons.test.BeanTestUtils
import kotlin.test.Test

class SchraderTpmsTest : BeanTestUtils {

    private val schraderTpmsMap : BeanPropertyMap = createBeanMapForTest(SchraderTpms::class)
    private val schraderTpms : SchraderTpms = createBeanFromMap(SchraderTpms::class, schraderTpmsMap)

    @Test
    fun shouldCreateBean() {
        validateBean(schraderTpms, schraderTpmsMap)
    }

}