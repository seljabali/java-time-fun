package javatimefun.calendar.extensions

import javatimefun.localdate.LocalDateUtil
import javatimefun.localdatetime.LocalDateTimeUtil
import javatimefun.localtime.LocalTimeUtil
import java.time.*
import java.util.Calendar

/**
 * @param useSystemTimeZone  If true, converts to time zone of the device, else leaves as is on calendar.
 * @return  ZonedDateTime.
 */
fun Calendar.toZonedDateTime(): ZonedDateTime =
    ZonedDateTime.ofInstant(this.toInstant(), ZoneId.of(this.timeZone.id))

fun Calendar.toLocalDateTime(): LocalDateTime =
    LocalDateTimeUtil.new(this.toInstant().toEpochMilli())

fun Calendar.toLocalDate(): LocalDate =
    LocalDateUtil.new(this.toInstant().toEpochMilli())

fun Calendar.toLocalTime(): LocalTime =
    LocalTimeUtil.new(this.toInstant().toEpochMilli())
