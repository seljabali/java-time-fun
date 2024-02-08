package javatimefun.zoneddatetime.extensions

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatterBuilder
import java.util.Locale

fun ZonedDateTime.print(format: String, locale: Locale = Locale.US): String =
    this.format(DateTimeFormatterBuilder().appendPattern(format).toFormatter(locale))