package javatimefun.localdate

import java.time.Instant
import java.time.LocalDate
import java.time.Month
import java.time.ZoneId

/**
 * Contains helper functions that only serve to create new LocalDates.
 * Creation methods do not include parsing methods.
 */
object LocalDateUtil {

    /**
     * @param year  Year, ie, 2020.
     * @param month  Month with range 1-12, i.e. 1 for January.
     * @param day  Day of the month with range 1-31.
     * @return  LocalDate.
     */
    fun new(year: Int, month: Int, day: Int): LocalDate =
        LocalDate.of(year, Month.of(month), day)

    /**
     * @param epochMilliseconds  Epoch time, aka Unix time, are seconds elapsed since January 1st 1970 at 00:00:00 UTC.
     * @return  LocalDate.
     */
    fun new(epochMilliseconds: Long, zoneId: ZoneId = ZoneId.systemDefault()): LocalDate =
        LocalDate.ofInstant(Instant.ofEpochMilli(epochMilliseconds), zoneId)
}