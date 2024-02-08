package javatimefun.localdatetime.extensions

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime

fun LocalDateTime.atStartOfDay(): LocalDateTime = this.withLocalTime(LocalTime.MIN)

fun LocalDateTime.atEndOfDay(): LocalDateTime = this.withLocalTime(LocalTime.MAX)

fun LocalDateTime.withLocalTime(localTime: LocalTime): LocalDateTime {
    val withHour = this.withHour(localTime.hour)
    val withMinute = withHour.withMinute(localTime.minute)
    val withSecond = withMinute.withSecond(localTime.second)
    return withSecond.withNano(localTime.nano)
}

fun LocalDateTime.getLast(dayOfWeek: DayOfWeek, countingInThisDay: Boolean = false): LocalDateTime {
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

fun LocalDateTime.getNext(dayOfWeek: DayOfWeek, countingInThisDay: Boolean = false): LocalDateTime {
    if (countingInThisDay && this.dayOfWeek == dayOfWeek) {
        return this
    }
    var nextLocalDate = this
    if (nextLocalDate.dayOfWeek == dayOfWeek) {
        nextLocalDate = nextLocalDate.plusDays(1)
    }
    while (nextLocalDate.dayOfWeek != dayOfWeek) {
        nextLocalDate = nextLocalDate.plusDays(1)
    }
    return nextLocalDate
}