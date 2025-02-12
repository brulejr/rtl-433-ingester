package io.jrb.labs.commons.test

import org.apache.commons.lang3.RandomUtils
import org.assertj.core.api.Assertions.assertThat
import org.mockito.Mockito.mock
import java.util.UUID
import java.util.regex.Pattern
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.primaryConstructor

typealias BeanPropertyMap = Map<String, Any>
typealias BeanPropertyMapOverrides = Map<String, (map: BeanPropertyMap) -> Any?>

interface BeanTestUtils : TestUtils {

    fun createBeanMapForTest(
        klass: KClass<*>,
        propsToIgnore: List<String> = listOf(),
        overrides: BeanPropertyMapOverrides = mapOf()
    ): BeanPropertyMap {
        val map: BeanPropertyMap = klass.declaredMemberProperties.filter { !propsToIgnore.contains(it.name) }.associate {
            it.name to randomTypeOrMock(it.returnType)
        }
        return map.entries.associate {
            val key = it.key
            val value = if (overrides.containsKey(key)) overrides[key]?.let { x -> x(map) } else it.value
            key to value!!
        }
    }

    fun <T : Any > createBeanFromMap(klass: KClass<T>, map: BeanPropertyMap): T {
        val cons = klass.primaryConstructor!!
        return cons.callBy(cons.parameters.associateBy({ it }, { map[it.name] }))
    }

    fun randomTypeOrMock(type: KType): Any {
        return when (val typeString = type.toString().dropLastWhile { it == '?' }) {
            "kotlin.Boolean" -> randomBoolean()
            "kotlin.Double" -> randomDouble()
            "kotlin.Int" -> randomInt()
            "kotlin.Long" -> randomLong()
            "kotlin.String" -> randomString()
            "java.time.Instant" -> randomTimestamp()
            "java.util.UUID" -> UUID.randomUUID()
            "java.util.regex.Pattern" -> Pattern.compile(randomString())
            else -> {
                val typeClass : Class<*> = Class.forName(typeString)
                if (typeClass.isEnum) {
                    val pos = RandomUtils.nextInt(0, typeClass.enumConstants.size - 1)
                    typeClass.enumConstants[pos]
                } else {
                    mock(typeClass)
                }
            }
        }
    }

    fun <T> validateBean(bean: T, map: BeanPropertyMap) {
        val beanProps = bean!!::class.declaredMemberProperties
        map.keys.forEach {
            val beanProp = beanProps.stream().filter { x -> x.name == it }.findFirst().get()
            assertThat(beanProp.getter.call(bean)).isEqualTo(map[it])
        }
    }

}