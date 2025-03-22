package javatimefun.localtime

import java.time.LocalTime

object LocalTimes {
    fun startOfDay(): LocalTime = LocalTime.MIN
    fun noon(): LocalTime = LocalTime.NOON
    fun endOfDay(): LocalTime = LocalTime.MAX
}