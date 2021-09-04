package localtime

import java.time.LocalTime

object LocalTimeUtil {
    fun new(
        hourIn24: Int,
        minute: Int = 0,
        second: Int = 0,
        nanoOfSecond: Int = 0,
    ): LocalTime =
        LocalTime.of(hourIn24, minute, second, nanoOfSecond)

    fun new(
        hour: Int,
        minute: Int = 0,
        second: Int = 0,
        nanoOfSecond: Int = 0,
        isAm: Boolean
    ): LocalTime =
        LocalTime.of(if (isAm) hour else hour + 12, minute, second, nanoOfSecond)
}