package javatimefun.localtime

import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset

/**
 * Contains helper functions that only serve to create new LocalTimes.
 * Creation methods do not include parsing methods.
 */
object LocalTimeUtil {

    /**
     * @param hourIn24  Hour of the day with range 0-23.
     * @param minute  Minute of the hour with range 0-59.
     * @param second  Second of the minute with range 0-59.
     * @param nanoOfSecond  Nano-of-second to represent, from 0 to 999,999,999.
     * @return  LocalTime.
     */
    fun new(
        hourIn24: Int,
        minute: Int = 0,
        second: Int = 0,
        nanoOfSecond: Int = 0,
    ): LocalTime =
        LocalTime.of(hourIn24, minute, second, nanoOfSecond)


    /**
     * @param hour  Hour of the day with range 0-23.
     * @param minute  Minute of the hour with range 0-59.
     * @param second  Second of the minute with range 0-59.
     * @param nanoOfSecond  Nano-of-second to represent, from 0 to 999,999,999.
     * @param isAm  If true, sets assumes hour is in the AM, else PM.
     * @return  LocalTime.
     */
    fun new(
        hour: Int,
        minute: Int = 0,
        second: Int = 0,
        nanoOfSecond: Int = 0,
        isAm: Boolean
    ): LocalTime =
        LocalTime.of(if (isAm) hour else hour + 12, minute, second, nanoOfSecond)

    /**
     * @param epochMilliseconds  Epoch time, aka Unix time, are seconds elapsed since January 1st 1970 at 00:00:00 UTC.
     * @return  LocalTime.
     */
    fun new(epochMilliseconds: Long): LocalTime =
        LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilliseconds), ZoneOffset.UTC)
            .toLocalTime()
}