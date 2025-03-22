package javatimefun.calendar.extensions

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.Calendar

fun Calendar.toZonedDateTime(): ZonedDateTime =
    ZonedDateTime.ofInstant(this.toInstant(), ZoneId.of(this.timeZone.id))

fun Calendar.toLocalDateTime(): LocalDateTime =
    LocalDateTime.ofInstant(this.toInstant(), ZoneId.of(this.timeZone.id))

fun Calendar.toLocalDate(): LocalDate =
    LocalDate.ofInstant(this.toInstant(), ZoneId.of(this.timeZone.id))

fun Calendar.toLocalTime(): LocalTime =
    this.toLocalDateTime().toLocalTime()
