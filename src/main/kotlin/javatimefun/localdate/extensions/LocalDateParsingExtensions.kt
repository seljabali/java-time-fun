package javatimefun.localdate.extensions

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

/**
 * Works off of String representations of date, without time, nor time zone.
 * When a format is present, it'll try parsing using that format alone, & return null if it fails.
 *
 * @param this  String representation of LocalDate.
 * @param format  String representing format that should solely be used when parsing the date.
 * @return  LocalDate? Null means couldn't parse, else parsed LocalDate.
 */
fun String.parseLocalDate(format: String? = null): LocalDate? =
    if (format.isNullOrEmpty()) {
        try {
            LocalDate.parse(this)
        } catch (e: DateTimeParseException) {
            null
        } catch (e: IllegalArgumentException) {
            null
        }
    } else {
        try {
            LocalDate.parse(this, DateTimeFormatter.ofPattern(format))
        } catch (e: DateTimeParseException) {
            null
        } catch (e: IllegalArgumentException) {
            null
        }
    }