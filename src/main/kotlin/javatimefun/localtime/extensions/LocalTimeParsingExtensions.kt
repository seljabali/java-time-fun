package javatimefun.localtime.extensions

import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun String.toLocalTime(format: String? = null): LocalTime? =
    if (format.isNullOrEmpty()) {
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