package javatimefun.localdatetime.extensions

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

private const val flexibleIso8601Format = "yyyy-MM-dd'T'HH:mm:ss[.SSSSSS][.SSSSS][.SSSS][.SSS][.SS][.S]['Z']"

/**
 * Works off of String representations of dateTime and parses through the following attempts in order when
 * no format is present:
 * <p><ul>
 * <li>First, tries parsing as LocalDateTime with format if provided,
 * <li>Lastly, if fails, tries parsing using a more flexible ISO 8601 format
 * </ul><p>
 *
 * @param this String representation of LocalDateTime.
 * @param format String representing format that should solely be used when parsing the date.
 * @return LocalDateTime? Null means couldn't parse, else parsed LocalDateTime.
 */
fun String.toLocalDateTime(format: String? = null): LocalDateTime? =
    parseLocalDateTimeOrNull(this, format) ?: parseLocalDateTimeOrNull(this, flexibleIso8601Format)

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