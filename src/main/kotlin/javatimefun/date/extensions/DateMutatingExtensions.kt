package javatimefun.date.extensions

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.Date

fun Date.toZonedDateTime(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime =
    ZonedDateTime.ofInstant(this.toInstant(), zoneId)

/**
 * @return  LocalDateTime.
 */
fun Date.toLocalDateTime(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime =
    LocalDateTime.ofInstant(this.toInstant(), zoneId)

/**
 * @return  LocalDate.
 */
fun Date.toLocalDate(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate =
    LocalDate.ofInstant(this.toInstant(), zoneId)

/**
 * @return  LocalTime.
 */
fun Date.toLocalTime(zoneId: ZoneId = ZoneId.systemDefault()): LocalTime =
    this.toLocalDateTime(zoneId).toLocalTime()
