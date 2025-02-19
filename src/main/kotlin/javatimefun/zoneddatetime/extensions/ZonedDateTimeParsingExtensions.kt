package javatimefun.zoneddatetime.extensions

import javatimefun.localdatetime.extensions.toLocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

/**
 * Works off of String representations of (zoned)date(time) and parses through the following attempts in order when
 * no format is present:
 * <p><ul>
 * <li>First, try to parse as ZonedDateTime, if successful returns value & converts to systemTimeZone if param value is set.
 * <li>Second, try to parse as LocalDateTime, if successful returns value & converts to systemTimeZone if param value is set.
 * <li>Lastly, try to parse as LocalDate, if successful returns value & adds start of daytime, & converts to systemTimeZone if param value is set, else returns null.
 * </ul><p>
 * When a format is present however, it'll try parsing using that format alone, & return null if it fails.
 *
 * @param this  String representation of either LocalDate, LocalDateTime, or ZonedDateTime.
 * @param format  String representing format that should solely be used when parsing the date.
 * @param useSystemTimeZone  If true, converts parsed date to system default timezone, else keeps original time zone.
 * @return ZonedDateTime? Null means couldn't parse, else parsed ZonedDateTime.
 */
fun String.toZonedDateTime(
    format: String? = null,
    useSystemTimeZone: Boolean = true
): ZonedDateTime? {
    val zonedDateTime = parseZonedDateTimeOrNull(this, format)
    if (zonedDateTime != null) {
        if (useSystemTimeZone) {
            return zonedDateTime.withZoneSameInstant(ZoneId.systemDefault())
        }
        return zonedDateTime
    }
    val localDateTime = this.toLocalDateTime(format)
    if (localDateTime != null) {
        return ZonedDateTime.of(localDateTime, ZoneId.systemDefault())
    }
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
