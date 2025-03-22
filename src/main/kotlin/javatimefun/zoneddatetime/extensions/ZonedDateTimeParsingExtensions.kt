package javatimefun.zoneddatetime.extensions

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

/**
 * Works off of String representations of ZonedDateTime:
 * When a format is present however, it'll try parsing using that format alone, & return null if it fails.
 *
 * @param this  String representation of ZonedDateTime.
 * @param format  String representing format that should solely be used when parsing the date.
 * @return ZonedDateTime? Null means couldn't parse, else parsed ZonedDateTime.
 */
fun String.toZonedDateTime(format: String? = null): ZonedDateTime? {
    val zonedDateTime = parseZonedDateTimeOrNull(this, format)
    if (zonedDateTime != null) return zonedDateTime
    return null
}

private fun parseZonedDateTimeOrNull(dateText: String, format: String?): ZonedDateTime? =
    if (format.isNullOrEmpty()) {
        try {
            ZonedDateTime.parse(dateText)
        } catch (e: DateTimeParseException) {
            null
        } catch (e: IllegalArgumentException) {
            null
        }
    } else {
        try {
            ZonedDateTime.parse(dateText, DateTimeFormatter.ofPattern(format))
        } catch (e: DateTimeParseException) {
            null
        } catch (e: IllegalArgumentException) {
            null
        }
    }
