package javatimefun.zoneddatetime.extensions

import javatimefun.localdatetime.extensions.toLocalDateTime
import javatimefun.zoneddatetime.ZonedDateTimeUtil
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

/**
 * Works off of String representations of (zoned)date(time) and parses through the following attempts in order when
 * no format is present:
 * <p><ul>
 * <li>First, if the date is identified as MsftDate, then it'll attempt to parse & return value.
 * <li>Second, try to parse as ZonedDateTime, if successful returns value & converts to systemTimeZone if param value is set.
 * <li>Third, try to parse as LocalDateTime, if successful returns value & converts to systemTimeZone if param value is set.
 * <li>Lastly, try to parse as LocalDate, if successful returns value & adds start of daytime, & converts to systemTimeZone if param value is set, else returns null.
 * </ul><p>
 * When a format is present however, it'll try parsing using that format alone, & return null if it fails.
 *
 * @param this  String representation of either MsftDate, LocalDate, LocalDateTime, or ZonedDateTime.
 * @param format  String representing format that should solely be used when parsing the date.
 * @param useSystemTimeZone  If true, converts parsed date to system default timezone, else keeps original time zone.
 * @return ZonedDateTime? Null means couldn't parse, else parsed ZonedDateTime.
 */
fun String.toZonedDateTime(
    format: String? = null,
    useSystemTimeZone: Boolean = true
): ZonedDateTime? {
    val zonedDateTime = parseZonedDateTimeHelper(this, format)
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

private fun parseZonedDateTimeHelper(dateText: String, format: String?): ZonedDateTime? =
    if (format.isNullOrEmpty()) {
        try {
            if (dateText.isMsftDate()) {
                dateText.parseMsftDate()
            }
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

private fun String.isMsftDate(): Boolean = this.contains("/Date(")

private fun String.parseMsftDate(): ZonedDateTime {
//    "\/Date(1325134800000)\/"
    val longString = this.substring(this.indexOf("(") + 1, this.indexOf(")"))
    return ZonedDateTimeUtil.new(longString.toLong())
}