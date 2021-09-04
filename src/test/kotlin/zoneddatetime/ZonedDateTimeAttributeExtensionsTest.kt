package zoneddatetime

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import zoneddatetime.extensions.getDaysInMonth
import zoneddatetime.extensions.getMonthBaseZero
import zoneddatetime.extensions.isInLeapYear

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
}