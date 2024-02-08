package javatimefun.localtime.extensions

import java.time.LocalTime

fun LocalTime.isAtStartOfDay(): Boolean = this == LocalTime.MIN

fun LocalTime.isAtEndOfDay(): Boolean = this == LocalTime.MAX

fun LocalTime.isInAm(): Boolean = this.isBeforeTime(LocalTime.NOON)

fun LocalTime.isInPm(): Boolean = this.isAfterEqualTime(LocalTime.NOON)