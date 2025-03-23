package javatimefun.localtime

import javatimefun.localdatetime.LocalDateTimeFactory
import java.time.LocalTime
import java.time.ZoneId

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

    fun new(epochMilliseconds: Long, zoneId: ZoneId = ZoneId.systemDefault()): LocalTime =
        LocalDateTimeFactory.new(epochMilliseconds, zoneId).toLocalTime()
}