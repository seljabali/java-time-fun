package javatimefun.zoneddatetime

import javatimefun.zoneddatetime.extensions.atEndOfDay
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
    fun now(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = ZonedDateTime.now(zoneId)
    fun today(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = now(zoneId).atStartOfDay()
    fun yesterday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).minusDays(1)
    fun tomorrow(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).plusDays(1)

    fun lastMonday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).getLast(MONDAY)
    fun lastTuesday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).getLast(TUESDAY)
    fun lastWednesday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).getLast(WEDNESDAY)
    fun lastThursday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).getLast(THURSDAY)
    fun lastFriday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).getLast(FRIDAY)
    fun lastSaturday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).getLast(SATURDAY)
    fun lastSunday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).getLast(SUNDAY)

    fun nextMonday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).getNext(MONDAY)
    fun nextTuesday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).getNext(TUESDAY)
    fun nextWednesday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).getNext(WEDNESDAY)
    fun nextThursday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).getNext(THURSDAY)
    fun nextFriday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).getNext(FRIDAY)
    fun nextSaturday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).getNext(SATURDAY)
    fun nextSunday(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime = today(zoneId).getNext(SUNDAY)

    fun startOfYear(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime =
        ZonedDateTimeFactory.new(today(zoneId).year, 1, 1)
    fun endOfYear(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime =
        ZonedDateTimeFactory.new(today(zoneId).year, 12, 31)
            .atEndOfDay()
}