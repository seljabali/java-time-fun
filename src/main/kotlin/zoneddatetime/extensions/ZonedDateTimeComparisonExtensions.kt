package zoneddatetime.extensions

import java.time.Duration
import java.time.ZonedDateTime
import kotlin.math.roundToInt

// region Day Comparisons
fun ZonedDateTime.compareDay(toDate: ZonedDateTime): Int {
    val dayDifferentFromDate = getDayDifference(toDate)
    return when {
        dayDifferentFromDate > 0 -> -1
        dayDifferentFromDate < 0 -> 1
        else -> 0
    }
}

fun ZonedDateTime.isEqualDay(b: ZonedDateTime): Boolean = compareDay(b) == 0

fun ZonedDateTime.isBeforeDay(b: ZonedDateTime): Boolean = compareDay(b) < 0

fun ZonedDateTime.isBeforeEqualDay(b: ZonedDateTime): Boolean = compareDay(b) <= 0

fun ZonedDateTime.isAfterDay(b: ZonedDateTime): Boolean = compareDay(b) > 0

fun ZonedDateTime.isAfterEqualDay(b: ZonedDateTime): Boolean = compareDay(b) >= 0
// endregion

// region Month Comparisons
fun ZonedDateTime.compareMonth(zonedDateTimeB: ZonedDateTime): Int =
    when {
        isBeforeMonth(zonedDateTimeB) -> -1
        isEqualMonth(zonedDateTimeB) -> 0
        else -> 1
    }

fun ZonedDateTime.isBeforeMonth(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    if (this.year > otherZonedDateTime.year) return false
    if (this.year < otherZonedDateTime.year) return true
    return this.month < otherZonedDateTime.month
}

fun ZonedDateTime.isBeforeEqualMonth(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    if (this.year > otherZonedDateTime.year) return false
    if (this.year < otherZonedDateTime.year) return true
    return this.month <= otherZonedDateTime.month
}

fun ZonedDateTime.isEqualMonth(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return this.year == otherZonedDateTime.year && this.month == otherZonedDateTime.month
}

fun ZonedDateTime.isAfterEqualMonth(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    if (this.year > otherZonedDateTime.year) return true
    if (this.year < otherZonedDateTime.year) return false
    return this.month >= otherZonedDateTime.month
}

fun ZonedDateTime.isAfterMonth(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    if (this.year > otherZonedDateTime.year) return true
    if (this.year < otherZonedDateTime.year) return false
    return this.month > otherZonedDateTime.month
}
// endregion

// region Year Comparisons
fun ZonedDateTime.compareYear(zonedDateTimeB: ZonedDateTime): Int =
    this.year.compareTo(zonedDateTimeB.withTimeZoneOf(this).year)

fun ZonedDateTime.isBeforeYear(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return this.year < otherZonedDateTime.year
}

fun ZonedDateTime.isBeforeEqualYear(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return this.year <= otherZonedDateTime.year
}

fun ZonedDateTime.isEqualYear(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return this.year == otherZonedDateTime.year
}

fun ZonedDateTime.isAfterEqualYear(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return this.year >= otherZonedDateTime.year
}

fun ZonedDateTime.isAfterYear(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return this.year > otherZonedDateTime.year
}
// endregion

// region Time Comparisons
fun ZonedDateTime.compareTime(toDate: ZonedDateTime): Int =
    when {
        isEqualTime(toDate) -> 0
        isBeforeThanTime(toDate) -> -1
        else -> 1
    }

fun ZonedDateTime.isEqualTime(b: ZonedDateTime): Boolean = isEqual(b)

fun ZonedDateTime.isBeforeThanTime(b: ZonedDateTime): Boolean = this.isBefore(b)

fun ZonedDateTime.isBeforeThanEqualTime(b: ZonedDateTime): Boolean = compareTime(b) <= 0

fun ZonedDateTime.isAfterThanTime(b: ZonedDateTime): Boolean = compareTime(b) > 0

fun ZonedDateTime.isAfterThanEqualTime(b: ZonedDateTime): Boolean = compareTime(b) >= 0
// endregion

fun ZonedDateTime.getMinuteDifference(zonedDateTimeB: ZonedDateTime): Int {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return Duration.between(this, otherZonedDateTime).toMinutes().toInt()
}

fun ZonedDateTime.getHourDifference(zonedDateTimeB: ZonedDateTime): Int {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return (this.getMinuteDifference(otherZonedDateTime) / 60f).roundToInt()
}

fun ZonedDateTime.getDayDifference(zonedDateTimeB: ZonedDateTime): Int {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return Duration.between(this.atStartOfDay(), otherZonedDateTime.atStartOfDay()).toDays().toInt()
}

fun ZonedDateTime.getMonthDifference(zonedDateTimeB: ZonedDateTime): Int {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    val yearDif = (otherZonedDateTime.year - this.year) * 12
    return yearDif + (otherZonedDateTime.month.value - this.month.value)
}