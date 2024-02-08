package javatimefun.zoneddatetime

import javatimefun.zoneddatetime.extensions.atStartOfDay
import javatimefun.zoneddatetime.extensions.getLast
import javatimefun.zoneddatetime.extensions.getNext
import java.time.DayOfWeek.FRIDAY
import java.time.DayOfWeek.MONDAY
import java.time.DayOfWeek.SATURDAY
import java.time.DayOfWeek.SUNDAY
import java.time.DayOfWeek.THURSDAY
import java.time.DayOfWeek.TUESDAY
import java.time.DayOfWeek.WEDNESDAY
import java.time.ZoneId
import java.time.ZonedDateTime

object ZonedDateTimes {
    val now: ZonedDateTime get() = ZonedDateTime.now(ZoneId.systemDefault())
    val today: ZonedDateTime get() = now.atStartOfDay()
    val yesterday: ZonedDateTime get() = today.minusDays(1)
    val tomorrow: ZonedDateTime get() = today.plusDays(1)

    val lastMonday: ZonedDateTime get() = today.getLast(MONDAY)
    val lastTuesday: ZonedDateTime get() = today.getLast(TUESDAY)
    val lastWednesday: ZonedDateTime get() = today.getLast(WEDNESDAY)
    val lastThursday: ZonedDateTime get() = today.getLast(THURSDAY)
    val lastFriday: ZonedDateTime get() = today.getLast(FRIDAY)
    val lastSaturday: ZonedDateTime get() = today.getLast(SATURDAY)
    val lastSunday: ZonedDateTime get() = today.getLast(SUNDAY)

    val nextMonday: ZonedDateTime get() = today.getNext(MONDAY)
    val nextTuesday: ZonedDateTime get() = today.getNext(TUESDAY)
    val nextWednesday: ZonedDateTime get() = today.getNext(WEDNESDAY)
    val nextThursday: ZonedDateTime get() = today.getNext(THURSDAY)
    val nextFriday: ZonedDateTime get() = today.getNext(FRIDAY)
    val nextSaturday: ZonedDateTime get() = today.getNext(SATURDAY)
    val nextSunday: ZonedDateTime get() = today.getNext(SUNDAY)

    val firstDayOfThisYear: ZonedDateTime get() = ZonedDateTimeUtil.new(today.year, 1, 1)
    val lastDayOfThisYear: ZonedDateTime get() = ZonedDateTimeUtil.new(today.year, 12, 31)
}