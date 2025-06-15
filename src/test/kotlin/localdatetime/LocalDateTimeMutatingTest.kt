package localdatetime

import javatimefun.ZoneIds
import javatimefun.localdatetime.extensions.fromUtcToZone
import javatimefun.localdatetime.extensions.fromZoneToUtc
import javatimefun.localdatetime.extensions.fromZoneToZone
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class LocalDateTimeMutatingTest {

    @Test
    fun `fromZoneToZone returns same time if zones are identical`() {
        val time = LocalDateTime.of(2025, 6, 15, 12, 0)
        val zone = ZoneIds.AFRICA_CAIRO

        val converted = time.fromZoneToZone(zone, zone)
        assertEquals(time, converted, "When fromZoneId and toZoneId are the same, time should not change")
    }

    @Test
    fun `fromZoneToZone converts correctly between different zones`() {
        val timeInTokyo = LocalDateTime.of(2025, 6, 15, 12, 0) // Noon in Tokyo
        val fromZone = ZoneIds.AFRICA_CAIRO
        val toZone = ZoneIds.AMERICA_ARGENTINA_Catamarca

        val converted = timeInTokyo.fromZoneToZone(fromZone, toZone)

        // Convert via ZonedDateTime for expected result
        val expected = timeInTokyo.atZone(fromZone)
            .withZoneSameInstant(toZone)
            .toLocalDateTime()

        assertEquals(expected, converted)
    }

    @Test
    fun `fromUtcToZone converts correctly`() {
        val timeUtc = LocalDateTime.of(2025, 6, 15, 12, 0)
        val toZone = ZoneIds.AFRICA_CAIRO

        val converted = timeUtc.fromUtcToZone(toZone)
        val expected = timeUtc.atZone(ZoneIds.UTC)
            .withZoneSameInstant(toZone)
            .toLocalDateTime()

        assertEquals(expected, converted)
    }

    @Test
    fun `fromZoneToUtc converts correctly`() {
        val timeInTokyo = LocalDateTime.of(2025, 6, 15, 12, 0)
        val fromZone = ZoneIds.AFRICA_CAIRO

        val converted = timeInTokyo.fromZoneToUtc(fromZone)
        val expected = timeInTokyo.atZone(fromZone)
            .withZoneSameInstant(ZoneIds.UTC)
            .toLocalDateTime()

        assertEquals(expected, converted)
    }

    @Test
    fun `conversion handles DST transition correctly`() {
        // Example: US Eastern DST ends on Nov 2, 2014 at 2:00 am
        val fromZone = ZoneIds.AMERICA_NEW_YORK
        val toZone = ZoneIds.EUROPE_LONDON

        // 1:30 AM EDT (before DST ends)
        val timeBeforeDSTEnd = LocalDateTime.of(2014, 11, 2, 1, 30)

        val convertedBefore = timeBeforeDSTEnd.fromZoneToZone(fromZone, toZone)

        val expectedBefore = timeBeforeDSTEnd.atZone(fromZone)
            .withZoneSameInstant(toZone)
            .toLocalDateTime()

        assertEquals(expectedBefore, convertedBefore)

        // 2:30 AM EST (after DST ends - clocks moved back 1 hour)
        val timeAfterDSTEnd = LocalDateTime.of(2014, 11, 2, 2, 30)

        val convertedAfter = timeAfterDSTEnd.fromZoneToZone(fromZone, toZone)

        val expectedAfter = timeAfterDSTEnd.atZone(fromZone)
            .withZoneSameInstant(toZone)
            .toLocalDateTime()

        assertEquals(expectedAfter, convertedAfter)
    }
}