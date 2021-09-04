package zoneddatetime

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.ZonedDateTime

class ZonedDateTimeTest {

    @Test
    fun `given date day month & year, when converted to date, then should match attributes`() {
        // given
        val day = 7
        val month = 6
        val year = 2021

        // when
        val dateFormed: ZonedDateTime = ZonedDateTimeUtil.new(
            year = year,
            month = month,
            day = day
        )

        // then
        assertEquals(day, dateFormed.dayOfMonth)
        assertEquals(month, dateFormed.month.value)
        assertEquals(year, dateFormed.year)
    }

    @Test
    fun `given date day month year & time, when converted to date, then should match attributes`() {
        // given
        val day = 7
        val month = 6
        val year = 2021
        val hour = 7
        val minute = 35
        val second = 45

        // when
        val dateFormed: ZonedDateTime = ZonedDateTimeUtil.new(
            year = year,
            month = month,
            day = day,
            hourIn24 = hour,
            minute = minute,
            second = second
        )

        // then
        assertEquals(day, dateFormed.dayOfMonth)
        assertEquals(month, dateFormed.month.value)
        assertEquals(year, dateFormed.year)
        assertEquals(hour, dateFormed.hour)
        assertEquals(minute, dateFormed.minute)
        assertEquals(second, dateFormed.second)
        assertEquals(0, dateFormed.nano)
    }

}