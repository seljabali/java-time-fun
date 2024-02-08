package javatimefun.zoneddatetime.extensions

import java.time.Year
import java.time.ZonedDateTime

/**
 * Works off of ZonedDateTime context.
 * @return  True if context's year is a leap year.
 */
fun ZonedDateTime.isInLeapYear(): Boolean = Year.of(year).isLeap

/**
 * Works off of ZonedDateTime context.
 * @return  True if zoned date time's is at very start of day.
 */
fun ZonedDateTime.isAtStartOfDay(): Boolean = this.isEqualTime(this.atStartOfDay())

/**
 * Works off of ZonedDateTime context.
 * @return  True if zoned date time's is at very last moment of day.
 */
fun ZonedDateTime.isAtEndOfDay(): Boolean = this.isEqualTime(this.atEndOfDay())

/**
 * Works off of ZonedDateTime context.
 * @return  Month value of ZonedDateTime base 0, with range 0-11, where 0 is January.
 */
fun ZonedDateTime.getMonthBaseZero(): Int = this.monthValue - 1

/**
 * Works off of ZonedDateTime context.
 * @return  Number of days found in the particular month of ZonedDateTime, with range 28-31.
 */
fun ZonedDateTime.getDaysInMonth(): Int = this.month.length(isInLeapYear())