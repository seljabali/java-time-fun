package zoneddatetime

import javatimefun.ZoneIds
import javatimefun.calendar.extensions.toZonedDateTime
import javatimefun.zoneddatetime.ZonedDateTimeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javatimefun.zoneddatetime.extensions.getMonthBaseZero
import java.time.ZonedDateTime
import java.util.Calendar
import java.util.Calendar.HOUR
import java.util.Calendar.DAY_OF_MONTH
import java.util.Calendar.MILLISECOND
import java.util.Calendar.MINUTE
import java.util.Calendar.MONTH
import java.util.Calendar.SECOND
import java.util.Calendar.YEAR
import java.util.Date
import java.util.GregorianCalendar
import java.util.TimeZone

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

    @Test
    fun `given date day month year & time in AM, when converted to date, then should match attributes`() {
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

    @Test
    fun `given date day month year & time in PM, when converted to date, then should match attributes`() {
        // given
        val day = 7
        val month = 6
        val year = 2021
        val hour = 19
        val minute = 35
        val second = 45

        // when
        val dateFormed: ZonedDateTime = ZonedDateTimeUtil.new(
            year = year,
            month = month,
            day = day,
            hourIn24 = hour,
            minute = minute,
            second = second,
            zoneId = ZoneIds.UTC
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

    @Test
    fun `given date day month year & time with calendar, when converted to zonedDateTime, then should match attributes`() {
        // given
        val day = 7
        val month = 6
        val year = 2021
        val hour = 7
        val minute = 35
        val second = 45
        val timeZoneId = "GMT"

        // when
        val calendar = Calendar.getInstance().apply {
            timeZone = TimeZone.getTimeZone(timeZoneId)
            set(year, month, day, hour, minute, second)
        }
        val zonedDateTime = calendar.toZonedDateTime()

        // then
        assertEquals(calendar.timeZone.id, zonedDateTime.zone.id)
        assertEquals(calendar[YEAR], zonedDateTime.year)
        assertEquals(calendar[MONTH], zonedDateTime.getMonthBaseZero())
        assertEquals(calendar[DAY_OF_MONTH], zonedDateTime.dayOfMonth)
        assertEquals(calendar[HOUR], zonedDateTime.hour)
        assertEquals(calendar[MINUTE], zonedDateTime.minute)
        assertEquals(calendar[SECOND], zonedDateTime.second)
        assertEquals(calendar[MILLISECOND], zonedDateTime.toLocalTime().nano/1000000)
    }

    @Test
    fun `given date epoch millisecond of Date, when converted to zonedDateTime, then should match attributes`() {
        // given
        val epoch = 1325134800000

        // when
        val date = Date(epoch)
        val zonedDateTime = ZonedDateTimeUtil.new(epoch)

        // then
        assertEquals(date.time, zonedDateTime.toInstant().toEpochMilli())
    }

    @Test
    fun `given date epoch millisecond of Date & UTC timezone, when converted to zonedDateTime, then should match attributes`() {
        // given
        val epoch = 1325134800000
        val defaultTimeZoneId = "UTC"

        // when
        val date = Date(epoch)
        val zonedDateTime = ZonedDateTimeUtil.new(epoch, ZoneIds.UTC)
        val calendar = GregorianCalendar().apply {
            timeZone = TimeZone.getTimeZone(defaultTimeZoneId)
            time = date
        }

        // then
        assertEquals(date.time, zonedDateTime.toInstant().toEpochMilli())
        assertEquals(calendar[YEAR], zonedDateTime.year)
        assertEquals(calendar[MONTH], zonedDateTime.getMonthBaseZero())
        assertEquals(calendar[DAY_OF_MONTH], zonedDateTime.dayOfMonth)
        assertEquals(calendar[HOUR], zonedDateTime.hour)
        assertEquals(calendar[MINUTE], zonedDateTime.minute)
        assertEquals(calendar[SECOND], zonedDateTime.second)
        assertEquals(calendar[MILLISECOND], zonedDateTime.toLocalTime().nano/1000000)
    }

}