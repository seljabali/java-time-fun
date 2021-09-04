package localdate

import localdate.extensions.getLast
import localdate.extensions.getNext
import java.time.DayOfWeek
import java.time.LocalDate

object LocalDates {
    val today: LocalDate get() = LocalDate.now()
    val yesterday: LocalDate get() = today.minusDays(1)
    val tomorrow: LocalDate get() = today.plusDays(1)

    val lastMonday: LocalDate get() = today.getLast(DayOfWeek.MONDAY)
    val lastTuesday: LocalDate get() = today.getLast(DayOfWeek.TUESDAY)
    val lastWednesday: LocalDate get() = today.getLast(DayOfWeek.WEDNESDAY)
    val lastThursday: LocalDate get() = today.getLast(DayOfWeek.THURSDAY)
    val lastFriday: LocalDate get() = today.getLast(DayOfWeek.FRIDAY)
    val lastSaturday: LocalDate get() = today.getLast(DayOfWeek.SATURDAY)
    val lastSunday: LocalDate get() = today.getLast(DayOfWeek.SUNDAY)

    val nextMonday: LocalDate get() = today.getNext(DayOfWeek.MONDAY)
    val nextTuesday: LocalDate get() = today.getNext(DayOfWeek.TUESDAY)
    val nextWednesday: LocalDate get() = today.getNext(DayOfWeek.WEDNESDAY)
    val nextThursday: LocalDate get() = today.getNext(DayOfWeek.THURSDAY)
    val nextFriday: LocalDate get() = today.getNext(DayOfWeek.FRIDAY)
    val nextSaturday: LocalDate get() = today.getNext(DayOfWeek.SATURDAY)
    val nextSunday: LocalDate get() = today.getNext(DayOfWeek.SUNDAY)

    val firstDayOfThisYear: LocalDate get() = LocalDateUtil.new(today.year, 1, 1)
    val lastDayOfThisYear: LocalDate get() = LocalDateUtil.new(today.year, 12, 31)
}