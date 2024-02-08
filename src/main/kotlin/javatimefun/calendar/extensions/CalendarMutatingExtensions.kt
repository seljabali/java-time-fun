package javatimefun.calendar.extensions

import javatimefun.localdate.LocalDateUtil
import javatimefun.zoneddatetime.ZonedDateTimeUtil
import java.time.*
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

fun Calendar.toLocalDateTime(useSystemTimeZone: Boolean = true): LocalDateTime =
    LocalDateTime.ofInstant(
        this.toInstant(),
        if (useSystemTimeZone) ZoneId.systemDefault() else ZoneOffset.UTC
    )

fun Calendar.toLocalDate(): LocalDate =
    LocalDateUtil.new(this.toInstant().toEpochMilli())

fun Calendar.toLocalTime(useSystemTimeZone: Boolean = false): LocalTime =
    this.toLocalDateTime(useSystemTimeZone).toLocalTime()
