package zoneddatetime

import javatimefun.zoneddatetime.ZonedDateTimeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import javatimefun.zoneddatetime.extensions.*

class ZonedDateTimeComparisonExtensionsTest {

    @Test
    fun `given date A & B, when A is before B, then should properly have compare results as such`() {
        // given
        val dateA = ZonedDateTimeUtil.new(2020, 3, 20)
        val dateB = ZonedDateTimeUtil.new(2020, 3, 25)

        // when
        val isDateABeforeDayB =
            dateA.isBeforeDay(dateB) && dateA.isBeforeEqualDay(dateB) && dateA.compareDay(dateB) == -1
        val isDateBAfterDayA =
            dateB.isAfterDay(dateA) && dateB.isAfterEqualDay(dateA) && dateB.compareDay(dateA) == 1

        val isDateABeforeDayTimeB =
            dateA.isBeforeTime(dateB) && dateA.isBeforeEqualTime(dateB) && dateA.compareTime(dateB) == -1
        val isDateBAfterDayTimeA =
            dateB.isAfterTime(dateA) && dateB.isAfterEqualTime(dateA) && dateB.compareTime(dateA) == 1

        val isDateANotEqualDayDateB = !dateA.isEqualDay(dateB) && !dateB.isEqualDay(dateA)
        val isDateANotEqualDayTimeDateB = !dateA.isEqualTime(dateB) && !dateB.isEqualTime(dateA)

        // then
        assertTrue(isDateABeforeDayB)
        assertTrue(isDateBAfterDayA)
        assertTrue(isDateABeforeDayTimeB)
        assertTrue(isDateBAfterDayTimeA)
        assertTrue(isDateANotEqualDayDateB)
        assertTrue(isDateANotEqualDayTimeDateB)
    }

    @Test
    fun `given date A & B, when A is before B, then should properly have day & month compare results as such`() {
        // given
        val dateA = ZonedDateTimeUtil.new(2020, 3, 20)
        val dateB = ZonedDateTimeUtil.new(2020, 3, 25)

        // when
        val monthDifferenceOfAAndB = dateA.getMonthDifference(dateB)
        val monthDifferenceOfAAndBAreTheSame = dateA.getMonthDifference(dateB) == dateB.getMonthDifference(dateA)

        val dateAAndBAreInSameYear = dateA.isEqualYear(dateB) and dateB.isEqualYear(dateA)
        val dateAAndBAreInSameMonth = dateA.isEqualMonth(dateB) and dateB.isEqualMonth(dateA)

        val dateAAndBDayDifference = dateA.getDayDifference(dateB)

        // then
        assertEquals(monthDifferenceOfAAndB, 0)
        assertTrue(monthDifferenceOfAAndBAreTheSame)

        assertTrue(dateAAndBAreInSameYear)
        assertTrue(dateAAndBAreInSameMonth)

        assertEquals(dateAAndBDayDifference, 5)
    }

    @Test
    fun `given date A & B, when A is same day as B but not same time, then should properly have matching day comparisons`() {
        // given
        val dateA = ZonedDateTimeUtil.new(2020, 3, 20)
        val dateB = ZonedDateTimeUtil.new(2020, 3, 20, 12, 12, 0, 0)

        // when
        val isDateABeforeDayB = dateA.isBeforeDay(dateB) && dateA.compareDay(dateB) == -1
        val isDateAEqualDayB =
            dateA.isBeforeEqualDay(dateB) && dateA.isEqualDay(dateB) && dateA.compareDay(dateB) == 0
        val isDateBAfterDayA = dateB.isAfterDay(dateA) && dateB.compareDay(dateA) == 1
        val isDateBAfterEqualDayA = dateB.isAfterEqualDay(dateA)
        val isDateAEqualDayDateB = dateA.isEqualDay(dateB) && dateB.isEqualDay(dateA)

        // then
        assertFalse(isDateABeforeDayB)
        assertTrue(isDateAEqualDayB)
        assertTrue(isDateBAfterEqualDayA)
        assertFalse(isDateBAfterDayA)
        assertTrue(isDateAEqualDayDateB)
    }

    @Test
    fun `given date A & B, when A is same day as B but not same time, then should properly have matching time comparisons`() {
        // given
        val dateA = ZonedDateTimeUtil.new(2020, 3, 20)
        val dateB = ZonedDateTimeUtil.new(2020, 3, 20, 12, 12, 0, 0)

        // when
        val isDateABeforeDayTimeB =
            dateA.isBeforeTime(dateB) && dateA.isBeforeEqualTime(dateB) && dateA.compareTime(dateB) == -1
        val isDateBAfterDayTimeA =
            dateB.isAfterTime(dateA) && dateB.isAfterEqualTime(dateA) && dateB.compareTime(dateA) == 1
        val isDateAEqualTimeDateB = dateA.isEqualTime(dateB) && dateB.isEqualTime(dateA)

        // then
        assertTrue(isDateABeforeDayTimeB)
        assertTrue(isDateBAfterDayTimeA)
        assertFalse(isDateAEqualTimeDateB)
    }

    @Test
    fun `given 2 dateTimes 2 and half hrs apart, then should see such differences in comparing`() {
        // given
        // 2021-06-08 3:30 PM
        val dateA = ZonedDateTimeUtil.new(
            year = 2021,
            month = 6,
            day = 8,
            hourIn24 = 15,
            minute = 30,
            second = 0,
            nano = 0
        )

        // 2021-06-08 4:40 PM
        val dateB = ZonedDateTimeUtil.new(
            year = 2021,
            month = 6,
            day = 8,
            hourIn24 = 16,
            minute = 40,
            second = 0,
            nano = 0
        )

        // when
        val expectedDayDifference = dateA.getDayDifference(dateB)
        val expectedHourDifference = dateA.getHourDifference(dateB)
        val expectedMinuteDifference = dateA.getMinuteDifference(dateB)

        // then
        assertEquals(expectedDayDifference, 0)
        assertEquals(expectedHourDifference, 1)
        assertEquals(expectedMinuteDifference, 70)
    }
}