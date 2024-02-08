package javatimefun.localdatetime.extensions

import java.time.Duration
import java.time.LocalDateTime

// region Day Comparisons
fun LocalDateTime.compareDay(toDate: LocalDateTime): Int {
    val dayDifference = this.getDayDifference(toDate)
    return when {
        dayDifference > 0 -> -1
        dayDifference < 0 -> 1
        else -> 0
    }
}

fun LocalDateTime.isEqualDay(b: LocalDateTime): Boolean = this.compareDay(b) == 0

fun LocalDateTime.isBeforeDay(b: LocalDateTime): Boolean = this.compareDay(b) < 0

fun LocalDateTime.isBeforeEqualDay(b: LocalDateTime): Boolean = this.compareDay(b) <= 0

fun LocalDateTime.isAfterDay(b: LocalDateTime): Boolean = this.compareDay(b) > 0

fun LocalDateTime.isAfterEqualDay(b: LocalDateTime): Boolean = this.compareDay(b) >= 0
// endregion

// region Month Comparisons
fun LocalDateTime.compareMonth(localDateTimeB: LocalDateTime): Int =
    when {
        this.isBeforeMonth(localDateTimeB) -> -1
        this.isEqualMonth(localDateTimeB) -> 0
        else -> 1
    }

fun LocalDateTime.isBeforeMonth(localDateTimeB: LocalDateTime): Boolean {
    if (this.year > localDateTimeB.year) return false
    if (this.year < localDateTimeB.year) return true
    return this.month < localDateTimeB.month
}

fun LocalDateTime.isBeforeEqualMonth(localDateTimeB: LocalDateTime): Boolean {
    if (this.year > localDateTimeB.year) return false
    if (this.year < localDateTimeB.year) return true
    return this.month <= localDateTimeB.month
}

fun LocalDateTime.isEqualMonth(localDateTimeB: LocalDateTime): Boolean =
    this.year == localDateTimeB.year && this.month == localDateTimeB.month

fun LocalDateTime.isAfterEqualMonth(localDateTimeB: LocalDateTime): Boolean {
    if (this.year > localDateTimeB.year) return true
    if (this.year < localDateTimeB.year) return false
    return this.month >= localDateTimeB.month
}

fun LocalDateTime.isAfterMonth(localDateTimeB: LocalDateTime): Boolean {
    if (this.year > localDateTimeB.year) return true
    if (this.year < localDateTimeB.year) return false
    return this.month > localDateTimeB.month
}
// endregion

// region Year Comparisons
fun LocalDateTime.compareYear(localDateTimeB: LocalDateTime): Int = this.year.compareTo(localDateTimeB.year)

fun LocalDateTime.isBeforeYear(localDateTimeB: LocalDateTime): Boolean = this.year < localDateTimeB.year

fun LocalDateTime.isBeforeEqualYear(localDateTimeB: LocalDateTime): Boolean = this.year <= localDateTimeB.year

fun LocalDateTime.isEqualYear(localDateTimeB: LocalDateTime): Boolean = this.year == localDateTimeB.year

fun LocalDateTime.isAfterEqualYear(localDateTimeB: LocalDateTime): Boolean = this.year >= localDateTimeB.year

fun LocalDateTime.isAfterYear(localDateTimeB: LocalDateTime): Boolean = this.year > localDateTimeB.year
// endregion

// region Time Comparisons
fun LocalDateTime.compareTime(toDate: LocalDateTime): Int =
    when {
        this.isEqualTime(toDate) -> 0
        this.isBeforeTime(toDate) -> -1
        else -> 1
    }

fun LocalDateTime.isEqualTime(b: LocalDateTime): Boolean = this.isEqual(b)

fun LocalDateTime.isBeforeTime(b: LocalDateTime): Boolean = this.isBefore(b)

fun LocalDateTime.isBeforeEqualTime(b: LocalDateTime): Boolean = this.compareTime(b) <= 0

fun LocalDateTime.isAfterTime(b: LocalDateTime): Boolean = this.compareTime(b) > 0

fun LocalDateTime.isAfterEqualTime(b: LocalDateTime): Boolean = this.compareTime(b) >= 0
// endregion

fun LocalDateTime.getMinuteDifference(localDateTimeB: LocalDateTime): Long =
    Duration.between(this, localDateTimeB).toMinutes()

fun LocalDateTime.getHourDifference(localDateTimeB: LocalDateTime): Long =
    Duration.between(this, localDateTimeB).toHours()

fun LocalDateTime.getDayDifference(localDateTimeB: LocalDateTime): Long =
    Duration.between(this.atStartOfDay(), localDateTimeB.atStartOfDay()).toDays()

fun LocalDateTime.getMonthDifference(localDateTimeB: LocalDateTime): Int {
    val yearDif = (localDateTimeB.year - this.year) * 12
    return yearDif + (localDateTimeB.month.value - this.month.value)
}