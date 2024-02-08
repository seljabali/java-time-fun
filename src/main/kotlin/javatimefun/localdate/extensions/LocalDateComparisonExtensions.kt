package javatimefun.localdate.extensions

import java.time.Duration
import java.time.LocalDate

// region Day Comparisons
fun LocalDate.compareDay(toDate: LocalDate): Int {
    val dayDifference = this.getDayDifference(toDate)
    return when {
        dayDifference > 0 -> -1
        dayDifference < 0 -> 1
        else -> 0
    }
}

fun LocalDate.isEqualDay(b: LocalDate): Boolean = compareDay(b) == 0

fun LocalDate.isBeforeDay(b: LocalDate): Boolean = compareDay(b) < 0

fun LocalDate.isBeforeEqualDay(b: LocalDate): Boolean = compareDay(b) <= 0

fun LocalDate.isAfterDay(b: LocalDate): Boolean = compareDay(b) > 0

fun LocalDate.isAfterEqualDay(b: LocalDate): Boolean = compareDay(b) >= 0
// endregion

// region Month Comparisons
fun LocalDate.compareMonth(localDateB: LocalDate): Int =
    when {
        isBeforeMonth(localDateB) -> -1
        isEqualMonth(localDateB) -> 0
        else -> 1
    }

fun LocalDate.isBeforeMonth(localDateB: LocalDate): Boolean {
    if (this.year > localDateB.year) return false
    if (this.year < localDateB.year) return true
    return this.month < localDateB.month
}

fun LocalDate.isBeforeEqualMonth(localDateB: LocalDate): Boolean {
    if (this.year > localDateB.year) return false
    if (this.year < localDateB.year) return true
    return this.month <= localDateB.month
}

fun LocalDate.isEqualMonth(localDateB: LocalDate): Boolean =
    this.year == localDateB.year && this.month == localDateB.month

fun LocalDate.isAfterEqualMonth(localDateB: LocalDate): Boolean {
    if (this.year > localDateB.year) return true
    if (this.year < localDateB.year) return false
    return this.month >= localDateB.month
}

fun LocalDate.isAfterMonth(localDateB: LocalDate): Boolean {
    if (this.year > localDateB.year) return true
    if (this.year < localDateB.year) return false
    return this.month > localDateB.month
}
// endregion

// region Year Comparisons
fun LocalDate.compareYear(localDateB: LocalDate): Int = this.year.compareTo(localDateB.year)

fun LocalDate.isBeforeYear(localDateB: LocalDate): Boolean = this.year < localDateB.year

fun LocalDate.isBeforeEqualYear(localDateB: LocalDate): Boolean = this.year <= localDateB.year

fun LocalDate.isEqualYear(localDateB: LocalDate): Boolean = this.year == localDateB.year

fun LocalDate.isAfterEqualYear(localDateB: LocalDate): Boolean = this.year >= localDateB.year

fun LocalDate.isAfterYear(localDateB: LocalDate): Boolean = this.year > localDateB.year
// endregion

fun LocalDate.getMinuteDifference(localDateB: LocalDate): Long = Duration.between(this, localDateB).toMinutes()

fun LocalDate.getHourDifference(localDateB: LocalDate): Long = Duration.between(this, localDateB).toHours()

fun LocalDate.getDayDifference(localDateB: LocalDate): Long = Duration.between(this.atStartOfDay(), localDateB.atStartOfDay()).toDays()

fun LocalDate.getMonthDifference(localDateB: LocalDate): Int {
    val yearDif = (localDateB.year - this.year) * 12
    return yearDif + (localDateB.month.value - this.month.value)
}