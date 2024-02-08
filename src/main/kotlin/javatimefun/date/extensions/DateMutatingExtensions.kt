package javatimefun.date.extensions

import javatimefun.localdate.LocalDateUtil
import javatimefun.localdatetime.LocalDateTimeUtil
import javatimefun.localtime.LocalTimeUtil
import javatimefun.zoneddatetime.ZonedDateTimeUtil
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZonedDateTime
import java.util.Date

/**
 * @param useSystemTimeZone  If true, converts to time zone of the device, else leaves as UTC.
 * @return  ZonedDateTime.
 */
fun Date.toZonedDateTime(useSystemTimeZone: Boolean = true): ZonedDateTime =
    ZonedDateTimeUtil.new(this.toInstant().toEpochMilli(), useSystemTimeZone)

/**
 * @return  LocalDateTime.
 */
fun Date.toLocalDateTime(): LocalDateTime =
    LocalDateTimeUtil.new(this.toInstant().toEpochMilli())

/**
 * @return  LocalDate.
 */
fun Date.toLocalDate(): LocalDate =
    LocalDateUtil.new(this.toInstant().toEpochMilli())

/**
 * @return  LocalTime.
 */
fun Date.toLocalTime(): LocalTime =
    LocalTimeUtil.new(this.toInstant().toEpochMilli())
