package javatimefun.zoneddatetime

import java.time.*

/**
 * Contains helper functions that only serve to create new ZonedDateTimes.
 * Creation methods do not include parsing methods.
 */
object ZonedDateTimeUtil {

    private val UTC get() = ZoneOffset.UTC

    /**
     * @param year  Year, ie, 2020.
     * @param month  Month with range 1-12, i.e. 1 for January.
     * @param day  Day of the month with range 1-31.
     * @param hourIn24  Hour of the day with range 0-23.
     * @param minute  Minute of the hour with range 0-59.
     * @param second  Second of the minute with range 0-59.
     * @param nano  Nano-of-second to represent, from 0 to 999,999,999.
     * @param useSystemTimeZone  If true, sets the time zone of the device, else UTC.
     * @return  ZonedDateTime.
     */
    fun new(
        year: Int,
        month: Int,
        day: Int,
        hourIn24: Int = 0,
        minute: Int = 0,
        second: Int = 0,
        nano: Int = 0,
        useSystemTimeZone: Boolean = true
    ): ZonedDateTime {
        val localDateTime = LocalDateTime.of(year, Month.of(month), day, hourIn24, minute, second, nano)
        return ZonedDateTime.of(localDateTime, if (useSystemTimeZone) ZoneId.systemDefault() else UTC)
    }

    /**
     * @param year  Year, ie, 2020.
     * @param month  Month with range 1-12, i.e. 1 for January.
     * @param day  Day of the month with range 1-31.
     * @param hour  Hour of the day with range 1-12.
     * @param minute  Minute of the hour with range 0-59.
     * @param second  Second of the minute with range 0-59.
     * @param nano  Nano-of-second to represent, from 0 to 999,999,999.
     * @param isAm  If true, sets assumes hour is in the AM, else PM.
     * @param useSystemTimeZone  If true, sets the time zone of the device, else UTC.
     * @return  ZonedDateTime.
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
        useSystemTimeZone: Boolean = true
    ): ZonedDateTime = new(year, month, day, if (isAm) hour else hour + 12, minute, second, nano, useSystemTimeZone)

    /**
     * @param epochMilliseconds  Epoch time, aka Unix time, are seconds elapsed since January 1st 1970 at 00:00:00 UTC.
     * @param useSystemTimeZone  If true, converts to time zone of the device, else leaves as UTC.
     * @return  ZonedDateTime.
     */
    fun new(epochMilliseconds: Long, useSystemTimeZone: Boolean = true): ZonedDateTime =
        ZonedDateTime.ofInstant(
            Instant.ofEpochMilli(epochMilliseconds),
            if (useSystemTimeZone) ZoneId.systemDefault() else UTC
        )
}