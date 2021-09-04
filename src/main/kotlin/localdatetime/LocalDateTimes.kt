package localdatetime

import localdatetime.extensions.atStartOfDay
import localdatetime.extensions.getLast
import localdatetime.extensions.getNext
import java.time.DayOfWeek
import java.time.LocalDateTime

object LocalDateTimes {
    val now: LocalDateTime get() = LocalDateTime.now()
    val today: LocalDateTime get() = now.atStartOfDay()
    val yesterday: LocalDateTime get() = today.minusDays(1)
    val tomorrow: LocalDateTime get() = today.plusDays(1)

    val lastMonday: LocalDateTime get() = today.getLast(DayOfWeek.MONDAY)
    val lastTuesday: LocalDateTime get() = today.getLast(DayOfWeek.TUESDAY)
    val lastWednesday: LocalDateTime get() = today.getLast(DayOfWeek.WEDNESDAY)
    val lastThursday: LocalDateTime get() = today.getLast(DayOfWeek.THURSDAY)
    val lastFriday: LocalDateTime get() = today.getLast(DayOfWeek.FRIDAY)
    val lastSaturday: LocalDateTime get() = today.getLast(DayOfWeek.SATURDAY)
    val lastSunday: LocalDateTime get() = today.getLast(DayOfWeek.SUNDAY)

    val nextMonday: LocalDateTime get() = today.getNext(DayOfWeek.MONDAY)
    val nextTuesday: LocalDateTime get() = today.getNext(DayOfWeek.TUESDAY)
    val nextWednesday: LocalDateTime get() = today.getNext(DayOfWeek.WEDNESDAY)
    val nextThursday: LocalDateTime get() = today.getNext(DayOfWeek.THURSDAY)
    val nextFriday: LocalDateTime get() = today.getNext(DayOfWeek.FRIDAY)
    val nextSaturday: LocalDateTime get() = today.getNext(DayOfWeek.SATURDAY)
    val nextSunday: LocalDateTime get() = today.getNext(DayOfWeek.SUNDAY)

    val firstDayOfThisYear: LocalDateTime get() = LocalDateTimeUtil.new(today.year, 1, 1)
    val lastDayOfThisYear: LocalDateTime get() = LocalDateTimeUtil.new(today.year, 12, 31)
}