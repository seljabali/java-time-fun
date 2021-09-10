package zoneddatetime.extensions

import java.time.ZonedDateTime

fun ZonedDateTime.isInLeapYear(): Boolean = YearUtil.isLeapYear(this.year)

fun ZonedDateTime.isAtStartOfDay(): Boolean = this.isEqualTime(this.atStartOfDay())

fun ZonedDateTime.isAtEndOfDay(): Boolean = this.isEqualTime(this.atEndOfDay())

fun ZonedDateTime.getMonthBaseZero(): Int = this.monthValue - 1

fun ZonedDateTime.getDaysInMonth(): Int = this.month.length(isInLeapYear())