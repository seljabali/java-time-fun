package javatimefun.localdate

import javatimefun.localdate.extensions.getLast
import javatimefun.localdate.extensions.getNext
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

object LocalDates {
    fun now(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = LocalDateTime.now(zoneId).toLocalDate()
    fun today(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = now(zoneId)
    fun yesterday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().minusDays(1)
    fun tomorrow(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().plusDays(1)

    fun lastMonday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().getLast(DayOfWeek.MONDAY)
    fun lastTuesday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().getLast(DayOfWeek.TUESDAY)
    fun lastWednesday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().getLast(DayOfWeek.WEDNESDAY)
    fun lastThursday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().getLast(DayOfWeek.THURSDAY)
    fun lastFriday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().getLast(DayOfWeek.FRIDAY)
    fun lastSaturday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().getLast(DayOfWeek.SATURDAY)
    fun lastSunday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().getLast(DayOfWeek.SUNDAY)

    fun nextMonday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().getNext(DayOfWeek.MONDAY)
    fun nextTuesday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().getNext(DayOfWeek.TUESDAY)
    fun nextWednesday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().getNext(DayOfWeek.WEDNESDAY)
    fun nextThursday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().getNext(DayOfWeek.THURSDAY)
    fun nextFriday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().getNext(DayOfWeek.FRIDAY)
    fun nextSaturday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().getNext(DayOfWeek.SATURDAY)
    fun nextSunday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = today().getNext(DayOfWeek.SUNDAY)

    fun firstDayOfTheYear(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate =
        LocalDateUtil.new(today(zoneId).year, 1, 1)
    fun lastDayOfTheYear(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate =
        LocalDateUtil.new(today(zoneId).year, 12, 31)
}