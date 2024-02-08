package zoneddatetime

import javatimefun.localtime.extensions.parseLocalTime
import javatimefun.localtime.extensions.print
import javatimefun.zoneddatetime.ZonedDateTimeUtil
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import javatimefun.zoneddatetime.extensions.getLast
import javatimefun.zoneddatetime.extensions.getNext
import javatimefun.zoneddatetime.extensions.isEqualDay
import javatimefun.zoneddatetime.extensions.withLocalTime
import java.time.DayOfWeek
import java.time.LocalTime

class ZonedDateTimeMutatingExtensionsTest {

    companion object {
        private const val HH_MM_SS_AM = "hh:mm:ss a"
    }

    @Test
    fun `given date is on a Monday, when looking for last Monday inclusive, then should return same date`() {
        // given
        val dateA = ZonedDateTimeUtil.new(2021, 6, 7)

        // when
        val resultLastMondayInclusive = dateA.getLast(DayOfWeek.MONDAY, countingInThisDay = true)

        // then
        assertTrue(dateA.isEqualDay(resultLastMondayInclusive))
    }

    @Test
    fun `given date is on a Monday, when looking for last Monday exclusive, then should return date minus 1 week`() {
        // given
        val dateA = ZonedDateTimeUtil.new(2021, 6, 14)
        val expectedDate = ZonedDateTimeUtil.new(2021, 6, 7)

        // when
        val resultLastMondayExclusive = dateA.getLast(DayOfWeek.MONDAY)

        // then
        assertTrue(expectedDate.isEqualDay(resultLastMondayExclusive))
    }

    @Test
    fun `given date is on a Monday, when looking for next Monday inclusive, then should return same date`() {
        // given
        val dateA = ZonedDateTimeUtil.new(2021, 6, 7)

        // when
        val resultNextMondayInclusive = dateA.getNext(DayOfWeek.MONDAY, countingInThisDay = true)

        // then
        assertTrue(dateA.isEqualDay(resultNextMondayInclusive))
    }

    @Test
    fun `given date is on a Monday, when looking for next Monday exclusive, then should return date plus 1 week`() {
        // given
        val dateA = ZonedDateTimeUtil.new(2021, 6, 7)
        val expectedDate = ZonedDateTimeUtil.new(2021, 6, 14)

        // when
        val resultNextMondayExclusive = dateA.getNext(DayOfWeek.MONDAY)

        // then
        assertTrue(expectedDate.isEqualDay(resultNextMondayExclusive))
    }

    @Test
    fun `given date A, when adjusted time, then should properly apply time`() {
        // given
        var dateA = ZonedDateTimeUtil.new(2020, 3, 20)
        val timeText = "07:35:11 AM"
        val time: LocalTime = timeText.parseLocalTime(HH_MM_SS_AM)  ?: throw RuntimeException("Failed to parse")

        // when
        dateA = dateA.withLocalTime(time)
        val resultTime = dateA.toLocalTime()
        val resultText = resultTime.print(HH_MM_SS_AM)

        // then
        Assertions.assertEquals(time, resultTime)
        Assertions.assertEquals(timeText, resultText)
    }

}