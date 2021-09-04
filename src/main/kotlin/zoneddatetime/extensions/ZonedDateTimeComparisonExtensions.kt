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

fun ZonedDateTime.isBeforeThanDay(b: ZonedDateTime): Boolean = compareDay(b) < 0

fun ZonedDateTime.isBeforeThanEqualDay(b: ZonedDateTime): Boolean = compareDay(b) <= 0

fun ZonedDateTime.isAfterThanDay(b: ZonedDateTime): Boolean = compareDay(b) > 0

fun ZonedDateTime.isAfterThanEqualDay(b: ZonedDateTime): Boolean = compareDay(b) >= 0
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

fun ZonedDateTime.getMinuteDifference(zonedDateTimeB: ZonedDateTime): Int =
    Duration.between(this, zonedDateTimeB).toMinutes().toInt()

fun ZonedDateTime.getHourDifference(zonedDateTimeB: ZonedDateTime): Int =
    (this.getMinuteDifference(zonedDateTimeB) / 60f).roundToInt()

fun ZonedDateTime.getDayDifference(zonedDateTimeB: ZonedDateTime): Int =
    Duration.between(this.atStartOfDay(), zonedDateTimeB.atStartOfDay()).toDays().toInt()

fun ZonedDateTime.getMonthDifference(zonedDateTimeB: ZonedDateTime): Int {
    val yearDif = (zonedDateTimeB.year - this.year) * 12
    return yearDif + (zonedDateTimeB.month.value - this.month.value)
}

fun ZonedDateTime.areInSameMonth(zonedDateTimeB: ZonedDateTime): Boolean =
    year == zonedDateTimeB.year && month == zonedDateTimeB.month

fun ZonedDateTime.areInSameYear(zonedDateTimeB: ZonedDateTime): Boolean =
    this.year == zonedDateTimeB.year