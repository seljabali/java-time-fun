package localdate.extensions

import zoneddatetime.ZonedDateTimeUtil
import java.time.LocalDate

fun LocalDate.isInLeapYear(): Boolean = ZonedDateTimeUtil.isLeapYear(this.year)

fun LocalDate.getMonthBaseZero(): Int = this.monthValue - 1

fun LocalDate.getDaysInMonth(): Int = this.month.length(isInLeapYear())