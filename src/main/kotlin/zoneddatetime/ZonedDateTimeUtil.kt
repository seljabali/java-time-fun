package zoneddatetime

import java.time.Instant
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneId
import java.time.ZonedDateTime

object ZonedDateTimeUtil {

    fun new(
        year: Int,
        month: Int,
        day: Int,
        hourIn24: Int = 0,
        minute: Int = 0,
        second: Int = 0,
        nano: Int = 0
    ): ZonedDateTime {
        val localDateTime = LocalDateTime.of(
            year,
            Month.of(month),
            day,
            hourIn24,
            minute,
            second,
            nano
        )
        return ZonedDateTime.of(localDateTime, ZoneId.systemDefault())
    }

    fun new(
        year: Int,
        month: Int,
        day: Int,
        hour: Int = 0,
        minute: Int = 0,
        second: Int = 0,
        nano: Int = 0,
        isAm: Boolean
    ): ZonedDateTime {
        val localDateTime = LocalDateTime.of(
            year,
            Month.of(month),
            day,
            if (isAm) hour else hour + 12,
            minute,
            second,
            nano
        )
        return ZonedDateTime.of(localDateTime, ZoneId.systemDefault())
    }

    fun new(millis: Long): ZonedDateTime = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault())

    fun isLeapYear(year: Int): Boolean =
        when {
            year % 4 != 0 -> false
            year % 400 == 0 -> true
            year % 100 == 0 -> false
            else -> true
        }
}