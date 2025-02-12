package io.jrb.labs.rtl433.ingester.model

import io.jrb.labs.commons.test.BeanPropertyMap
import io.jrb.labs.commons.test.BeanTestUtils
import kotlin.test.Test

class RegencyRemoteTest : BeanTestUtils {

    private val regencyRemoteMap : BeanPropertyMap = createBeanMapForTest(RegencyRemote::class)
    private val regencyRemote : RegencyRemote = createBeanFromMap(RegencyRemote::class, regencyRemoteMap)

    @Test
    fun shouldCreateBean() {
        validateBean(regencyRemote, regencyRemoteMap)
    }

}