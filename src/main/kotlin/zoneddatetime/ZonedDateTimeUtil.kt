package zoneddatetime

import java.time.Instant
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.Calendar
import java.util.Date

object ZonedDateTimeUtil {

    private val UTC get() = ZoneId.of("UTC")

    fun new(
        year: Int,
        month: Int,
        day: Int,
        hourIn24: Int = 0,
        minute: Int = 0,
        second: Int = 0,
        nano: Int = 0,
        useSystemTimeZone: Boolean = true
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
        return ZonedDateTime.of(
            localDateTime,
            if (useSystemTimeZone) ZoneId.systemDefault() else UTC
        )
    }

    fun new(
        year: Int,
        month: Int,
        day: Int,
        hour: Int = 0,
        minute: Int = 0,
        second: Int = 0,
        nano: Int = 0,
        isAm: Boolean,
        useSystemTimeZone: Boolean = true
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
        return ZonedDateTime.of(
            localDateTime,
            if (useSystemTimeZone) ZoneId.systemDefault() else UTC
        )
    }

    fun new(millis: Long, useSystemTimeZone: Boolean = true): ZonedDateTime =
        getZonedDateTimeFromInstant(Instant.ofEpochMilli(millis), useSystemTimeZone)

    fun new(date: Date, useSystemTimeZone: Boolean = true): ZonedDateTime =
        getZonedDateTimeFromInstant(date.toInstant(), useSystemTimeZone)

    fun new(calendar: Calendar, useSystemTimeZone: Boolean = true): ZonedDateTime {
        if (useSystemTimeZone) {
            return getZonedDateTimeFromInstant(calendar.toInstant(), true)
        }
        return ZonedDateTime.ofInstant(calendar.toInstant(), ZoneId.of(calendar.timeZone.id))
    }

    private fun getZonedDateTimeFromInstant(instant: Instant, useSystemTimeZone: Boolean): ZonedDateTime =
        ZonedDateTime.ofInstant(
            instant,
            if (useSystemTimeZone) ZoneId.systemDefault() else UTC
        )
}