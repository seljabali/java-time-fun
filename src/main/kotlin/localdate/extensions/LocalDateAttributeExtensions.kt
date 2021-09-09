package localdate.extensions

import java.time.LocalDate

fun LocalDate.isInLeapYear(): Boolean = YearUtil.isLeapYear(this.year)

fun LocalDate.getMonthBaseZero(): Int = this.monthValue - 1

fun LocalDate.getDaysInMonth(): Int = this.month.length(isInLeapYear())