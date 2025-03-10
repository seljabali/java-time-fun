package javatimefun.localdatetime.extensions

import javatimefun.localdate.extensions.toLocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

private const val flexibleIso8601Format = "yyyy-MM-dd'T'HH:mm:ss[.SSSSSS][.SSSSS][.SSSS][.SSS][.SS][.S]['Z']"

/**
 * Works off of String representations of date(time) and parses through the following attempts in order when
 * no format is present:
 * <p><ul>
 * <li>First, tries parsing as LocalDateTime, if successful, uses systemTimeZone.
 * <li>Lastly, tries parsing as LocalDate, if successful, adds start of daytime, & systemTimeZone.
 * </ul><p>
 * When a format is present, tries parsing using that format alone, & return null if it fails.
 *
 * @param this String representation of either LocalDate, or LocalDateTime.
 * @param format String representing format that should solely be used when parsing the date.
 * @return LocalDateTime? Null means couldn't parse, else parsed LocalDateTime.
 */
fun String.toLocalDateTime(format: String? = null): LocalDateTime? {
    var localDateTime = parseLocalDateTimeOrNull(this, format)
    if (localDateTime != null) return localDateTime

    localDateTime = parseLocalDateTimeOrNull(this, flexibleIso8601Format)
    if (localDateTime != null) return localDateTime

    val localDate = this.toLocalDate(format)
    if (localDate != null) return LocalDateTime.of(localDate, LocalTime.MIN)

    return null
}

private fun parseLocalDateTimeOrNull(dateText: String, format: String?): LocalDateTime? =
    if (format.isNullOrEmpty())
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