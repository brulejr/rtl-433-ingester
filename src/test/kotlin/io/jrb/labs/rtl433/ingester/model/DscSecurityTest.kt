package io.jrb.labs.rtl433.ingester.model

import io.jrb.labs.commons.test.BeanPropertyMap
import io.jrb.labs.commons.test.BeanTestUtils
import kotlin.test.Test

class DscSecurityTest : BeanTestUtils {

    private val dscSecurityMap : BeanPropertyMap = createBeanMapForTest(DscSecurity::class)
    private val dscSecurity : DscSecurity = createBeanFromMap(DscSecurity::class, dscSecurityMap)

    @Test
    fun shouldCreateBean() {
        validateBean(dscSecurity, dscSecurityMap)
    }

}