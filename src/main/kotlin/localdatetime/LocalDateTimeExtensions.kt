package localdatetime

import localdate.parseLocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.format.DateTimeParseException
import java.util.Locale

fun String.parseLocalDateTime(format: String? = null): LocalDateTime? {
    val localDateTime = parseLocalDateTimeHelper(this, format)
    if (localDateTime != null) {
        return localDateTime
    }
    val localDate = this.parseLocalDate(format)
    if (localDate != null) {
        return LocalDateTime.of(localDate, LocalTime.MIN)
    }
    return null
}

private fun parseLocalDateTimeHelper(dateText: String, format: String?): LocalDateTime? =
    if (format == null || format.isEmpty())
        try {
            LocalDateTime.parse(dateText)
        } catch (e: DateTimeParseException) {
            null
        }
    else {
        try {
            LocalDateTime.parse(dateText, DateTimeFormatter.ofPattern(format))
        } catch (e: DateTimeParseException) {
            null
        }
    }

fun LocalDateTime.print(format: String, locale: Locale = Locale.US): String =
    this.format(DateTimeFormatterBuilder().appendPattern(format).toFormatter(locale))