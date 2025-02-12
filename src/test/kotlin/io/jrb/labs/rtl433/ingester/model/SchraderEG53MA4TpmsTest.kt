package io.jrb.labs.rtl433.ingester.model

import io.jrb.labs.commons.test.BeanPropertyMap
import io.jrb.labs.commons.test.BeanTestUtils
import kotlin.test.Test

class SchraderEG53MA4TpmsTest : BeanTestUtils {

    private val schraderEG53MA4TpmsMap : BeanPropertyMap = createBeanMapForTest(SchraderEG53MA4Tpms::class)
    private val schraderEG53MA4Tpms : SchraderEG53MA4Tpms = createBeanFromMap(SchraderEG53MA4Tpms::class, schraderEG53MA4TpmsMap)

    @Test
    fun shouldCreateBean() {
        validateBean(schraderEG53MA4Tpms, schraderEG53MA4TpmsMap)
    }

}