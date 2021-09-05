package zoneddatetime.extensions

import localdatetime.extensions.parseLocalDateTime
import zoneddatetime.ZonedDateTimeUtil
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun String.parseZonedDateTime(
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
    val localDateTime = this.parseLocalDateTime(format)
    if (localDateTime != null) {
        return ZonedDateTime.of(localDateTime, ZoneId.systemDefault())
    }
    return null
}

private fun parseZonedDateTimeHelper(dateText: String, format: String?): ZonedDateTime? =
    if (format == null || format.isEmpty()) {
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