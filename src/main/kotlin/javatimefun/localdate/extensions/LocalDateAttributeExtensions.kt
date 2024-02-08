package javatimefun.localdate.extensions

import java.time.LocalDate
import java.time.Year

fun LocalDate.isInLeapYear(): Boolean = Year.of(year).isLeap

fun LocalDate.getMonthBaseZero(): Int = this.monthValue - 1

fun LocalDate.getDaysInMonth(): Int = this.month.length(isInLeapYear())