package localdatetime.extensions

import localdate.extensions.parseLocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

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
        } catch (e: IllegalArgumentException) {
            null
        }
    else {
        try {
            LocalDateTime.parse(dateText, DateTimeFormatter.ofPattern(format))
        } catch (e: DateTimeParseException) {
            null
        } catch (e: IllegalArgumentException) {
            null
        }
    }