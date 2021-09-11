package localdatetime

import java.time.LocalDateTime
import java.time.Month

object LocalDateTimeUtil {

    fun new(
        year: Int,
        month: Int,
        day: Int,
        hourIn24: Int = 0,
        minute: Int = 0,
        second: Int = 0,
        nano: Int = 0
    ): LocalDateTime =
        LocalDateTime.of(
            year,
            Month.of(month),
            day,
            hourIn24,
            minute,
            second,
            nano
        )

    fun new(
        year: Int,
        month: Int,
        day: Int,
        hour: Int = 0,
        isAm: Boolean,
        minute: Int = 0,
        second: Int = 0,
        nano: Int = 0
    ): LocalDateTime =
        new(
            year, month, day, if (isAm) hour else hour + 12, minute, second, nano
        )
}