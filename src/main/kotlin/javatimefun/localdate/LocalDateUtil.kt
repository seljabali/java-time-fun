package javatimefun.localdate

import java.time.LocalDate
import java.time.Month
import java.util.Date
import java.util.Calendar

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
    fun new(year: Int, month: Int, day: Int): LocalDate = LocalDate.of(year, Month.of(month), day)

    /**
     * @param epochMilliseconds  Epoch time, aka Unix time, are seconds elapsed since January 1st 1970 at 00:00:00 UTC.
     * @return  LocalDate.
     */
    fun new(epochMilliseconds: Long): LocalDate = LocalDate.ofEpochDay(epochMilliseconds / 1000 / 60 / 60 / 24)

    /**
     * @param date  A wrapper of Epoch time in UTC.
     * @return  LocalDate.
     */
    fun new(date: Date): LocalDate =
        javatimefun.localdate.LocalDateUtil.new(date.toInstant().toEpochMilli())

    /**
     * @param calendar  Calendar, a date time variable that supports time zones.
     * @return  LocalDate.
     */
    fun new(calendar: Calendar): LocalDate =
        javatimefun.localdate.LocalDateUtil.new(calendar.toInstant().toEpochMilli())
}