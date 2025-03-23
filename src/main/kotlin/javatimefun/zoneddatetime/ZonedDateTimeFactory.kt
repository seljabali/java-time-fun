package javatimefun.zoneddatetime

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

/**
 * Contains helper functions that only serve to create new ZonedDateTimes.
 * Creation methods do not include parsing methods.
 */
object ZonedDateTimeFactory {

    /**
     * @param year  Year, ie, 2020.
     * @param month  Month with range 1-12, i.e. 1 for January.
     * @param day  Day of the month with range 1-31.
     * @param hourIn24  Hour of the day with range 0-23.
     * @param minute  Minute of the hour with range 0-59.
     * @param second  Second of the minute with range 0-59.
     * @param nano  Nano-of-second to represent, from 0 to 999,999,999.
     * @param zoneId Defaulted to time zone of the device.
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
        zoneId: ZoneId = ZoneId.systemDefault()
    ): ZonedDateTime 
        = ZonedDateTime.of(
            year,
            month,
            day,
            hourIn24,
            minute,
            second,
            nano,
            zoneId
        )

    /**
     * @param epochMilliseconds  Epoch time, aka Unix time, are seconds elapsed since January 1st 1970 at 00:00:00 UTC.
     * @param zoneId Defaulted to time zone of the device.
     * @return  ZonedDateTime.
     */
    fun new(
        epochMilliseconds: Long,
        zoneId: ZoneId = ZoneId.systemDefault()
    ): ZonedDateTime =
        ZonedDateTime.ofInstant(
            Instant.ofEpochMilli(epochMilliseconds),
            zoneId
        )
}