package localdate

import javatimefun.localdate.LocalDateUtil
import javatimefun.localdate.extensions.getDayDifference
import javatimefun.localdate.extensions.getHourDifference
import javatimefun.localdate.extensions.getMinuteDifference
import javatimefun.localdate.extensions.getMonthDifference
import javatimefun.localdate.extensions.getSecondDifference
import javatimefun.localdate.extensions.getYearDifference
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LocalDateComparisonExtensionsTest {

    @Test
    fun `given 2 dateTimes 2 and half hrs apart, then should see such differences in comparing`() {
        // given
        // 2021-06-08 3:30 PM
        val dateA = LocalDateUtil.new(
            year = 2021,
            month = 6,
            day = 8,
        )

        // 2021-06-08 4:40 PM
        val dateB = LocalDateUtil.new(
            year = 2021,
            month = 6,
            day = 8,
        )

        // when
        val actualYearsDifference = dateA.getYearDifference(dateB)
        val actualMonthDifference = dateA.getMonthDifference(dateB)
        val actualDayDifference = dateA.getDayDifference(dateB)
        val actualHourDifference = dateA.getHourDifference(dateB)
        val actualMinuteDifference = dateA.getMinuteDifference(dateB)
        val actualSecondDifference = dateA.getSecondDifference(dateB)

        // then
        assertEquals(0, actualYearsDifference)
        assertEquals(0, actualMonthDifference)
        assertEquals(0, actualDayDifference)
        assertEquals(1, actualHourDifference)
        assertEquals(70, actualMinuteDifference)
        assertEquals(4200, actualSecondDifference)
    }

    @Test
    fun `given 2 dateTimes 2 years apart, then should see such differences in comparing`() {
        // given
        // 2021-06-08 3:30 PM
        val dateA = LocalDateUtil.new(
            year = 2021,
            month = 6,
            day = 8,
        )

        // 2024-06-08 3:30 PM
        val dateB = LocalDateUtil.new(
            year = 2024,
            month = 6,
            day = 8,
        )

        // when
        val actualYearsDifference = dateA.getYearDifference(dateB)
        val actualMonthDifference = dateA.getMonthDifference(dateB)
        val actualDayDifference = dateA.getDayDifference(dateB)
        val actualHourDifference = dateA.getHourDifference(dateB)
        val actualMinuteDifference = dateA.getMinuteDifference(dateB)
        val actualSecondDifference = dateA.getSecondDifference(dateB)

        // then
        assertEquals(3, actualYearsDifference)
        assertEquals(36, actualMonthDifference)
        assertEquals(1096, actualDayDifference)
        assertEquals(26304, actualHourDifference)
        assertEquals(1578240, actualMinuteDifference)
        assertEquals(94694400, actualSecondDifference)
    }    
}