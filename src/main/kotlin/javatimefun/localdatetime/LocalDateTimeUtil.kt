package javatimefun.localdatetime

import java.time.Instant
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneId

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
    ): LocalDateTime = LocalDateTime.of(year, Month.of(month), day, hourIn24, minute, second, nano)


    /**
     * @param epochMilliseconds  Epoch time, aka Unix time, are seconds elapsed since January 1st 1970 at 00:00:00 UTC.
     * @return  LocalDateTime.
     */
    fun new(epochMilliseconds: Long, zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime =
        LocalDateTime.ofInstant(
            Instant.ofEpochMilli(epochMilliseconds),
            zoneId
        )
}