package javatimefun.localtime.extensions

import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun String.parseLocalTime(format: String? = null): LocalTime? =
    if (format == null || format.isEmpty()) {
        try {
            LocalTime.parse(this)
        } catch (e: DateTimeParseException) {
            null
        } catch (e: IllegalArgumentException) {
            null
        }
    } else {
        try {
            LocalTime.parse(this, DateTimeFormatter.ofPattern(format))
        } catch (e: DateTimeParseException) {
            null
        } catch (e: IllegalArgumentException) {
            null
        }
    }