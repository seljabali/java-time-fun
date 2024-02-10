package javatimefun.localdate

import javatimefun.localdate.extensions.getLast
import javatimefun.localdate.extensions.getNext
import java.time.DayOfWeek
import java.time.LocalDate

object LocalDates {
    val today: LocalDate get() = LocalDate.now()
    val yesterday: LocalDate get() = javatimefun.localdate.LocalDates.today.minusDays(1)
    val tomorrow: LocalDate get() = javatimefun.localdate.LocalDates.today.plusDays(1)

    val lastMonday: LocalDate get() = javatimefun.localdate.LocalDates.today.getLast(DayOfWeek.MONDAY)
    val lastTuesday: LocalDate get() = javatimefun.localdate.LocalDates.today.getLast(DayOfWeek.TUESDAY)
    val lastWednesday: LocalDate get() = javatimefun.localdate.LocalDates.today.getLast(DayOfWeek.WEDNESDAY)
    val lastThursday: LocalDate get() = javatimefun.localdate.LocalDates.today.getLast(DayOfWeek.THURSDAY)
    val lastFriday: LocalDate get() = javatimefun.localdate.LocalDates.today.getLast(DayOfWeek.FRIDAY)
    val lastSaturday: LocalDate get() = javatimefun.localdate.LocalDates.today.getLast(DayOfWeek.SATURDAY)
    val lastSunday: LocalDate get() = javatimefun.localdate.LocalDates.today.getLast(DayOfWeek.SUNDAY)

    val nextMonday: LocalDate get() = javatimefun.localdate.LocalDates.today.getNext(DayOfWeek.MONDAY)
    val nextTuesday: LocalDate get() = javatimefun.localdate.LocalDates.today.getNext(DayOfWeek.TUESDAY)
    val nextWednesday: LocalDate get() = javatimefun.localdate.LocalDates.today.getNext(DayOfWeek.WEDNESDAY)
    val nextThursday: LocalDate get() = javatimefun.localdate.LocalDates.today.getNext(DayOfWeek.THURSDAY)
    val nextFriday: LocalDate get() = javatimefun.localdate.LocalDates.today.getNext(DayOfWeek.FRIDAY)
    val nextSaturday: LocalDate get() = javatimefun.localdate.LocalDates.today.getNext(DayOfWeek.SATURDAY)
    val nextSunday: LocalDate get() = javatimefun.localdate.LocalDates.today.getNext(DayOfWeek.SUNDAY)

    val firstDayOfThisYear: LocalDate
        get() = javatimefun.localdate.LocalDateUtil.new(
            javatimefun.localdate.LocalDates.today.year,
            1,
            1
        )
    val lastDayOfThisYear: LocalDate
        get() = javatimefun.localdate.LocalDateUtil.new(
            javatimefun.localdate.LocalDates.today.year,
            12,
            31
        )
}