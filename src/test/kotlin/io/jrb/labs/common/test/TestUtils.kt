package io.jrb.labs.common.test

import org.apache.commons.lang3.RandomStringUtils
import java.time.Instant
import java.util.UUID
import java.util.concurrent.ThreadLocalRandom

class TestUtils {

    fun randomBoolean() = ThreadLocalRandom.current().nextBoolean()

    fun <E : Enum<E>> randomEnum(enumClass: Class<E>): E {
        val pos = ThreadLocalRandom.current().nextInt(0, enumClass.enumConstants.size - 1)
        return enumClass.enumConstants[pos]
    }

    fun randomGuid(): UUID = UUID.randomUUID()

    fun randomInt(upperLimit: Int = 1000) = ThreadLocalRandom.current().nextInt(1, upperLimit)

    fun <T> randomList(maxSize: Int = 3, supplier: () -> T): List<T> {
        val size = ThreadLocalRandom.current().nextInt(1, maxSize)
        return (1..size).map { supplier.invoke() }
    }

    fun randomLong(upperLimit: Long = 1000L): Long = ThreadLocalRandom.current().nextLong(0, upperLimit)

    fun <K, V> randomMap(maxSize: Int = 3, keySupplier: () -> K, valueSupplier: () -> V): Map<K, V> {
        val size = ThreadLocalRandom.current().nextInt(1, maxSize)
        return (1..size).associate { keySupplier.invoke() to valueSupplier.invoke() }
    }

    fun <T> randomSet(maxSize: Int = 3, supplier: () -> T): Set<T> {
        val size = ThreadLocalRandom.current().nextInt(1, maxSize)
        return (1..size).map { supplier.invoke() }.toSet()
    }

    fun randomString(): String = RandomStringUtils.randomAlphabetic(10)

    fun randomTimestamp(): Instant = Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt().toLong())

}