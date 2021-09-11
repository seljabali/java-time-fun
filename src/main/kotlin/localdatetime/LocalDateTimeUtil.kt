package localdatetime

import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneId
import java.util.Calendar
import java.util.Date

/**
 * Contains helper functions that only serve to create new LocalDateTimes.
 * Creation methods do not include parsing methods.
 */
object LocalDateTimeUtil {

    /**
     * @param year  Year, ie, 2020.
     * @param month  Month with range 1-12, i.e. 1 for January.
     * @param day  Day of the month with range 1-31.
     * @param hourIn24  Hour of the day with range 0-23.
     * @param minute  Minute of the hour with range 0-59.
     * @param second  Second of the minute with range 0-59.
     * @param nano  Nano-of-second to represent, from 0 to 999,999,999.
     * @return  LocalDateTime.
     */
    fun new(
        year: Int,
        month: Int,
        day: Int,
        hourIn24: Int = 0,
        minute: Int = 0,
        second: Int = 0,
        nano: Int = 0
    ): LocalDateTime =
        LocalDateTime.of(
            year,
            Month.of(month),
            day,
            hourIn24,
            minute,
            second,
            nano
        )

    /**
     * @param year  Year, ie, 2020.
     * @param month  Month with range 1-12, i.e. 1 for January.
     * @param day  Day of the month with range 1-31.
     * @param hour  Hour of the day with range 1-12.
     * @param minute  Minute of the hour with range 0-59.
     * @param second  Second of the minute with range 0-59.
     * @param nano  Nano-of-second to represent, from 0 to 999,999,999.
     * @param isAm  If true, sets assumes hour is in the AM, else PM.
     * @return  LocalDateTime.
     */
    fun new(
        year: Int,
        month: Int,
        day: Int,
        hour: Int = 0,
        minute: Int = 0,
        second: Int = 0,
        nano: Int = 0,
        isAm: Boolean,
    ): LocalDateTime =
        new(
            year, month, day, if (isAm) hour else hour + 12, minute, second, nano
        )

    /**
     * @param epochMilliseconds  Epoch time, aka Unix time, are seconds elapsed since January 1st 1970 at 00:00:00 UTC.
     * @return  LocalDateTime.
     */
    fun new(epochMilliseconds: Long): LocalDateTime = new(Date(epochMilliseconds))

    /**
     * @param date  A wrapper of Epoch time in UTC.
     * @return  LocalDateTime.
     */
    fun new(date: Date): LocalDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC"))

    /**
     * @param calendar  Calendar, a date time variable that supports time zones.
     * @return  LocalDateTime.
     */
    fun new(calendar: Calendar, useSystemTimeZone: Boolean = true): LocalDateTime =
        LocalDateTime.ofInstant(
            calendar.toInstant(),
            if (useSystemTimeZone) ZoneId.systemDefault() else ZoneId.of("UTC")
        )
}