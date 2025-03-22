package javatimefun.localdatetime

import javatimefun.localdatetime.extensions.atStartOfDay
import javatimefun.localdatetime.extensions.getLast
import javatimefun.localdatetime.extensions.getNext
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.ZoneId

object LocalDateTimes {
    fun now(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = LocalDateTime.now(zoneId)
    fun today(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = now(zoneId).atStartOfDay()
    fun yesterday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).minusDays(1)
    fun tomorrow(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).plusDays(1)

    fun lastMonday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).getLast(DayOfWeek.MONDAY)
    fun lastTuesday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).getLast(DayOfWeek.TUESDAY)
    fun lastWednesday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).getLast(DayOfWeek.WEDNESDAY)
    fun lastThursday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).getLast(DayOfWeek.THURSDAY)
    fun lastFriday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).getLast(DayOfWeek.FRIDAY)
    fun lastSaturday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).getLast(DayOfWeek.SATURDAY)
    fun lastSunday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).getLast(DayOfWeek.SUNDAY)

    fun nextMonday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).getNext(DayOfWeek.MONDAY)
    fun nextTuesday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).getNext(DayOfWeek.TUESDAY)
    fun nextWednesday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).getNext(DayOfWeek.WEDNESDAY)
    fun nextThursday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).getNext(DayOfWeek.THURSDAY)
    fun nextFriday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).getNext(DayOfWeek.FRIDAY)
    fun nextSaturday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).getNext(DayOfWeek.SATURDAY)
    fun nextSunday(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime = today(zoneId).getNext(DayOfWeek.SUNDAY)

    fun firstDayOfTheYear(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime =
        LocalDateTimeUtil.new(today(zoneId).year, 1, 1)
    fun lastDayOfTheYear(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime =
        LocalDateTimeUtil.new(today(zoneId).year, 12, 31)
}