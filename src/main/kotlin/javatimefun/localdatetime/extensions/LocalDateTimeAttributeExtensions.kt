package javatimefun.localdatetime.extensions

import java.time.LocalDateTime
import java.time.Year

fun LocalDateTime.isInLeapYear(): Boolean = Year.of(year).isLeap

fun LocalDateTime.isAtStartOfDay(): Boolean = this.isEqualTime(this.atStartOfDay())

fun LocalDateTime.isAtEndOfDay(): Boolean = this.isEqualTime(this.atEndOfDay())

fun LocalDateTime.getMonthBaseZero(): Int = this.monthValue - 1

fun LocalDateTime.getDaysInMonth(): Int = this.month.length(isInLeapYear())