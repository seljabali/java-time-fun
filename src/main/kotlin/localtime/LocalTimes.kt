package localtime

import java.time.LocalTime

object LocalTimes {
    val startOfDay: LocalTime get() = LocalTime.MIN
    val endOfDay: LocalTime get() = LocalTime.MAX
}