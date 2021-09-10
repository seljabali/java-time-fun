package localdatetime.extensions

import java.time.LocalDateTime

fun LocalDateTime.isInLeapYear(): Boolean = YearUtil.isLeapYear(this.year)

fun LocalDateTime.isAtStartOfDay(): Boolean = this.isEqualTime(this.atStartOfDay())

fun LocalDateTime.isAtEndOfDay(): Boolean = this.isEqualTime(this.atEndOfDay())

fun LocalDateTime.getMonthBaseZero(): Int = this.monthValue - 1

fun LocalDateTime.getDaysInMonth(): Int = this.month.length(isInLeapYear())