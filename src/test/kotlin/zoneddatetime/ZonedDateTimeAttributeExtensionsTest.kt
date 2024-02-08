package zoneddatetime

import javatimefun.zoneddatetime.ZonedDateTimeUtil
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import javatimefun.zoneddatetime.extensions.*

class ZonedDateTimeAttributeExtensionsTest {

    @Test
    fun `given leap years, then should properly mark them as such`() {
        // given
        val leapYearList = arrayOf(1980, 1984, 1988, 1992, 1996, 2000, 2004, 2008, 2012, 2016, 2020, 2024, 2028, 2032)
        var areAllLeapYears = true

        // when
        leapYearList.forEach { year ->
            val date = ZonedDateTimeUtil.new(year, 1, 1)
            areAllLeapYears = areAllLeapYears and date.isInLeapYear()
        }

        // then
        Assertions.assertTrue(areAllLeapYears)
    }

    @Test
    fun `given non-leap years, then should properly mark them as such`() {
        // given
        val nonLeapYearList =
            arrayOf(1981, 1983, 1989, 1991, 1995, 2001, 2005, 2009, 2013, 2017, 2021, 2022, 2029, 2031)
        var areAnyLeapYears = false

        // when
        nonLeapYearList.forEach { year ->
            val date = ZonedDateTimeUtil.new(year, 1, 1)
            areAnyLeapYears = areAnyLeapYears or date.isInLeapYear()
        }

        // then
        Assertions.assertFalse(areAnyLeapYears)
    }

    @Test
    fun `given date A, then should properly describe its attributes`() {
        // given
        val dateA = ZonedDateTimeUtil.new(2020, 6, 20)

        // when
        val monthBase0 = dateA.getMonthBaseZero()
        val getDaysInMonth = dateA.getDaysInMonth()

        // then
        assertEquals(monthBase0, 5)
        assertEquals(getDaysInMonth, 30)
    }

    @Test
    fun `given date A at start of day, then should properly describe it as such`() {
        // given
        val dateA = ZonedDateTimeUtil.new(
            2020,
            6,
            20,
            0,
            0,
            0,
            0,
            false
        )

        // when
        val startOfDay = dateA.isAtStartOfDay()

        // then
        assertTrue(startOfDay)
    }

    @Test
    fun `given date A at end of day, then should properly describe it as such`() {
        // given
        val dateA = ZonedDateTimeUtil.new(
            2020,
            6,
            20,
            23,
            59,
            59,
            999999999,
            false
        )

        // when
        val startOfDay = dateA.isAtEndOfDay()

        // then
        assertTrue(startOfDay)
    }
}