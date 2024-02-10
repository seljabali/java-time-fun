package localtime

import javatimefun.localtime.LocalTimeUtil
import javatimefun.localtime.extensions.getHourDifference
import javatimefun.localtime.extensions.getMilliSecondDifference
import javatimefun.localtime.extensions.getMinuteDifference
import javatimefun.localtime.extensions.getSecondDifference
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LocalTimeComparisonExtensionsTest {

    @Test
    fun `given 2 times 1hr and 10m apart, then should see such differences in comparing`() {
        // given
        // 3:30 PM
        val dateA = LocalTimeUtil.new(
            hourIn24 = 15,
            minute = 30,
            second = 0,
        )

        // 4:40 PM
        val dateB = LocalTimeUtil.new(
            hourIn24 = 16,
            minute = 40,
            second = 0,
        )

        // when
        val actualHourDifference = dateA.getHourDifference(dateB)
        val actualMinuteDifference = dateA.getMinuteDifference(dateB)
        val actualSecondDifference = dateA.getSecondDifference(dateB)
        val actualMilliDifference = dateA.getMilliSecondDifference(dateB)

        // then
        assertEquals(1, actualHourDifference)
        assertEquals(70, actualMinuteDifference)
        assertEquals(4200, actualSecondDifference)
        assertEquals(4200000, actualMilliDifference)
    }

    @Test
    fun `given 2 times and no time apart, then should see such differences in comparing`() {
        // given
        // 3:30 PM
        val dateA = LocalTimeUtil.new(
            hourIn24 = 15,
            minute = 30,
            second = 0,
        )

        // 3:30 PM
        val dateB = LocalTimeUtil.new(
            hourIn24 = 15,
            minute = 30,
            second = 0,
        )

        // when
        val actualHourDifference = dateA.getHourDifference(dateB)
        val actualMinuteDifference = dateA.getMinuteDifference(dateB)
        val actualSecondDifference = dateA.getSecondDifference(dateB)
        val actualMilliSecondDifference = dateA.getMilliSecondDifference(dateB)

        // then
        assertEquals(0, actualHourDifference)
        assertEquals(0, actualMinuteDifference)
        assertEquals(0, actualSecondDifference)
        assertEquals(0, actualMilliSecondDifference)
    }
}