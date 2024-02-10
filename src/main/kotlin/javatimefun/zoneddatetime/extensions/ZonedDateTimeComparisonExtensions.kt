package javatimefun.zoneddatetime.extensions

import java.time.Duration
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

// region Year Comparisons
/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's year to.
 * @return  Int, where 0 means they're the same, -1 context's is less then, 1 context's is more than param's.
 */
fun ZonedDateTime.compareYear(zonedDateTimeB: ZonedDateTime): Int =
    this.year.compareTo(zonedDateTimeB.withTimeZoneOf(this).year)

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's year to.
 * @return  True if context's is less than param's year, false otherwise.
 */
fun ZonedDateTime.isBeforeYear(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return this.year < otherZonedDateTime.year
}

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's year to.
 * @return  True if context's is less than equal param's year, false otherwise.
 */
fun ZonedDateTime.isBeforeEqualYear(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return this.year <= otherZonedDateTime.year
}

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's year to.
 * @return  True if context's equals param's year, false otherwise.
 */
fun ZonedDateTime.isEqualYear(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return this.year == otherZonedDateTime.year
}

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's year to.
 * @return  True if context's after or equals param's year, false otherwise.
 */
fun ZonedDateTime.isAfterEqualYear(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return this.year >= otherZonedDateTime.year
}

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's year to.
 * @return  True if context's after param's year, false otherwise.
 */
fun ZonedDateTime.isAfterYear(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return this.year > otherZonedDateTime.year
}
// endregion

// region Month Comparisons
/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's month to.
 * @return  0 when they're matching months, -1 when context's is less than, 1 when context's is more than param's.
 */
fun ZonedDateTime.compareMonth(zonedDateTimeB: ZonedDateTime): Int =
    when {
        isBeforeMonth(zonedDateTimeB) -> -1
        isEqualMonth(zonedDateTimeB) -> 0
        else -> 1
    }

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's month to.
 * @return  True if context's before param's month, false otherwise.
 */
fun ZonedDateTime.isBeforeMonth(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    if (this.year > otherZonedDateTime.year) return false
    if (this.year < otherZonedDateTime.year) return true
    return this.month < otherZonedDateTime.month
}

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's month to.
 * @return  True if context's before or equals param's month, false otherwise.
 */
fun ZonedDateTime.isBeforeEqualMonth(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    if (this.year > otherZonedDateTime.year) return false
    if (this.year < otherZonedDateTime.year) return true
    return this.month <= otherZonedDateTime.month
}

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's month to.
 * @return  True if context's equals param's month, false otherwise.
 */
fun ZonedDateTime.isEqualMonth(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return this.year == otherZonedDateTime.year && this.month == otherZonedDateTime.month
}

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's month to.
 * @return  True if context's after or equals param's month, false otherwise.
 */
fun ZonedDateTime.isAfterEqualMonth(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    if (this.year > otherZonedDateTime.year) return true
    if (this.year < otherZonedDateTime.year) return false
    return this.month >= otherZonedDateTime.month
}

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's month to.
 * @return  True if context's after param's month, false otherwise.
 */
fun ZonedDateTime.isAfterMonth(zonedDateTimeB: ZonedDateTime): Boolean {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    if (this.year > otherZonedDateTime.year) return true
    if (this.year < otherZonedDateTime.year) return false
    return this.month > otherZonedDateTime.month
}
// endregion

// region Day Comparisons
/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's day to.
 * @return  0 when they're matching days, -1 when context's is less than, 1 when context's is more than param's.
 */
fun ZonedDateTime.compareDay(zonedDateTimeB: ZonedDateTime): Int {
    val dayDifference = this.getDayDifference(zonedDateTimeB)
    return when {
        dayDifference > 0 -> -1
        dayDifference < 0 -> 1
        else -> 0
    }
}

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's day to.
 * @return  True if context's equals param's day, false otherwise.
 */
fun ZonedDateTime.isEqualDay(zonedDateTimeB: ZonedDateTime): Boolean = this.compareDay(zonedDateTimeB) == 0

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's day to.
 * @return  True if context is before param's day, false otherwise.
 */
fun ZonedDateTime.isBeforeDay(zonedDateTimeB: ZonedDateTime): Boolean = this.compareDay(zonedDateTimeB) < 0

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's day to.
 * @return  True if context is before or equal param's day, false otherwise.
 */
fun ZonedDateTime.isBeforeEqualDay(zonedDateTimeB: ZonedDateTime): Boolean = this.compareDay(zonedDateTimeB) <= 0

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's day to.
 * @return  True if context is after param's day, false otherwise.
 */
fun ZonedDateTime.isAfterDay(zonedDateTimeB: ZonedDateTime): Boolean = this.compareDay(zonedDateTimeB) > 0

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's day to.
 * @return  True if context is after or equal param's day, false otherwise.
 */
fun ZonedDateTime.isAfterEqualDay(zonedDateTimeB: ZonedDateTime): Boolean = this.compareDay(zonedDateTimeB) >= 0
// endregion

// region Time Comparisons
/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's day & time to.
 * @return  0 when they're matching day & time, -1 when context's is less than, 1 when context's is more than param's.
 */
fun ZonedDateTime.compareTime(zonedDateTimeB: ZonedDateTime): Int =
    when {
        this.isEqualTime(zonedDateTimeB) -> 0
        this.isBeforeTime(zonedDateTimeB) -> -1
        else -> 1
    }

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's day & time to.
 * @return  True if context's equals param's day & time, false otherwise.
 */
fun ZonedDateTime.isEqualTime(zonedDateTimeB: ZonedDateTime): Boolean = this.isEqual(zonedDateTimeB)

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's day & time to.
 * @return  True if context is before param's day & time, false otherwise.
 */
fun ZonedDateTime.isBeforeTime(zonedDateTimeB: ZonedDateTime): Boolean = this.isBefore(zonedDateTimeB)

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's day & time to.
 * @return  True if context is before or equal param's day & time, false otherwise.
 */
fun ZonedDateTime.isBeforeEqualTime(zonedDateTimeB: ZonedDateTime): Boolean = this.compareTime(zonedDateTimeB) <= 0

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's day & time to.
 * @return  True if context is after param's day & time, false otherwise.
 */
fun ZonedDateTime.isAfterTime(zonedDateTimeB: ZonedDateTime): Boolean = this.compareTime(zonedDateTimeB) > 0

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's day & time to.
 * @return  True if context is after or equal param's day & time, false otherwise.
 */
fun ZonedDateTime.isAfterEqualTime(zonedDateTimeB: ZonedDateTime): Boolean = this.compareTime(zonedDateTimeB) >= 0
// endregion

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's second difference from.
 * @return  Seconds away from param be it positive or negative.
 */
fun ZonedDateTime.getSecondDifference(zonedDateTimeB: ZonedDateTime): Long {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return Duration.between(this, otherZonedDateTime).toSeconds()
}

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's minute difference from.
 * @return  Minutes away from param be it positive or negative.
 */
fun ZonedDateTime.getMinuteDifference(zonedDateTimeB: ZonedDateTime): Long {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return Duration.between(this, otherZonedDateTime).toMinutes()
}

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's hour difference from.
 * @return  Hours away from param be it positive or negative.
 */
fun ZonedDateTime.getHourDifference(zonedDateTimeB: ZonedDateTime): Long {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return Duration.between(this, otherZonedDateTime).toHours()
}

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's day difference from.
 * @return  Days away from param be it positive or negative.
 */
fun ZonedDateTime.getDayDifference(zonedDateTimeB: ZonedDateTime): Long {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return Duration.between(this.atStartOfDay(), otherZonedDateTime.atStartOfDay()).toDays()
}

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's months difference from.
 * @return  Months away from param be it positive or negative.
 */
fun ZonedDateTime.getMonthDifference(zonedDateTimeB: ZonedDateTime): Long {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return ChronoUnit.MONTHS.between(this, otherZonedDateTime)
}

/**
 * Works off of ZonedDateTime context.
 * @param zonedDateTimeB  ZonedDateTime of which we want to compare context's years difference from.
 * @return  Years away from param be it positive or negative.
 */
fun ZonedDateTime.getYearDifference(zonedDateTimeB: ZonedDateTime): Long {
    val otherZonedDateTime = zonedDateTimeB.withTimeZoneOf(this)
    return ChronoUnit.YEARS.between(this, otherZonedDateTime)
}