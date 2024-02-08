package javatimefun.calendar.extensions

import javatimefun.localdate.LocalDateUtil
import javatimefun.localdatetime.LocalDateTimeUtil
import javatimefun.localtime.LocalTimeUtil
import javatimefun.zoneddatetime.ZonedDateTimeUtil
import java.time.ZonedDateTime
import java.time.LocalDateTime
import java.time.LocalDate
import java.time.LocalTime
import java.util.Calendar

/**
 * @param useSystemTimeZone  If true, converts to time zone of the device, else leaves as is on calendar.
 * @return  ZonedDateTime.
 */
fun Calendar.toZonedDateTime(useSystemTimeZone: Boolean = true): ZonedDateTime =
    ZonedDateTimeUtil.new(
        this.toInstant().toEpochMilli(),
        useSystemTimeZone
    )

fun Calendar.toLocalDateTime(): LocalDateTime =
    LocalDateTimeUtil.new(this.toInstant().toEpochMilli())

fun Calendar.toLocalDate(): LocalDate =
    LocalDateUtil.new(this.toInstant().toEpochMilli())

fun Calendar.toLocalTime(): LocalTime =
    LocalTimeUtil.new(this.toInstant().toEpochMilli())
