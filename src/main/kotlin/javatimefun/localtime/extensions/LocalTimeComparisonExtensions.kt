package javatimefun.localtime.extensions

import java.time.Duration
import java.time.LocalTime

// region Time Comparisons
fun LocalTime.compareTime(toDate: LocalTime): Int =
    when {
        isEqualTime(toDate) -> 0
        isBeforeTime(toDate) -> -1
        else -> 1
    }

fun LocalTime.isEqualTime(b: LocalTime): Boolean = this == b

fun LocalTime.isBeforeTime(b: LocalTime): Boolean = this.isBefore(b)

fun LocalTime.isBeforeEqualTime(b: LocalTime): Boolean = compareTime(b) <= 0

fun LocalTime.isAfterTime(b: LocalTime): Boolean = compareTime(b) > 0

fun LocalTime.isAfterEqualTime(b: LocalTime): Boolean = compareTime(b) >= 0
// endregion

fun LocalTime.getSecondDifference(localTimeB: LocalTime): Int = Duration.between(this, localTimeB).seconds.toInt()

fun LocalTime.getMinuteDifference(localTimeB: LocalTime): Int = Duration.between(this, localTimeB).toMinutes().toInt()

fun LocalTime.getHourDifference(localTimeB: LocalTime): Int = Duration.between(this, localTimeB).toHours().toInt()