package zoneddatetime.extensions

import java.time.DayOfWeek
import java.time.LocalTime
import java.time.ZonedDateTime

fun ZonedDateTime.atStartOfDay(): ZonedDateTime = this.withLocalTime(LocalTime.MIN)

fun ZonedDateTime.atEndOfDay(): ZonedDateTime = this.withLocalTime(LocalTime.MAX)

fun ZonedDateTime.withLocalTime(localTime: LocalTime): ZonedDateTime {
    val withHour = this.withHour(localTime.hour)
    val withMinute = withHour.withMinute(localTime.minute)
    val withSecond = withMinute.withSecond(localTime.second)
    return withSecond.withNano(localTime.nano)
}

fun ZonedDateTime.withTimeZoneOf(zonedDateTime: ZonedDateTime): ZonedDateTime {
    if (this.zone != zonedDateTime.zone) {
        return this.withZoneSameInstant(zonedDateTime.zone)
    }
    return this
}

fun ZonedDateTime.getLast(dayOfWeek: DayOfWeek, countingInThisDay: Boolean = false): ZonedDateTime {
    if (countingInThisDay && this.dayOfWeek == dayOfWeek) {
        return this
    }
    var mostRecentDay = this
    if (mostRecentDay.dayOfWeek == dayOfWeek) {
        mostRecentDay = mostRecentDay.minusDays(1)
    }
    while (mostRecentDay.dayOfWeek != dayOfWeek) {
        mostRecentDay = mostRecentDay.minusDays(1)
    }
    return mostRecentDay
}

fun ZonedDateTime.getNext(dayOfWeek: DayOfWeek, countingInThisDay: Boolean = false): ZonedDateTime {
    if (countingInThisDay && this.dayOfWeek == dayOfWeek) {
        return this
    }
    var nextZonedDate = this
    if (nextZonedDate.dayOfWeek == dayOfWeek) {
        nextZonedDate = nextZonedDate.plusDays(1)
    }
    while (nextZonedDate.dayOfWeek != dayOfWeek) {
        nextZonedDate = nextZonedDate.plusDays(1)
    }
    return nextZonedDate
}