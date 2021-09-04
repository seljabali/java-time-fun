package zoneddatetime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import zoneddatetime.extensions.parseZonedDateTime
import zoneddatetime.extensions.print
import java.lang.RuntimeException
import java.time.ZonedDateTime

class ZonedDateTimeParsingExtensionsTest {

    companion object {
        private const val YYYY_MM_DD_DASH = "yyyy-MM-dd"
        private const val MM_DD_YYYY_SLASH = "MM/dd/yyyy"
    }

    @Test
    fun `given date in YYYY-MM-DD, when parsed without format & converted to date, then should match when printed back to text`() {
        // given
        val dateInText = "2021-06-07"

        // when
        val dateParsed: ZonedDateTime = dateInText.parseZonedDateTime() ?: throw RuntimeException("Failed to parse")

        // then
        assertEquals(dateInText, dateParsed.print(YYYY_MM_DD_DASH))
    }

    @Test
    fun `given date in YYYY-MM-DD, when parsed with format & converted to date, then should match when printed back to text`() {
        // given
        val dateInText = "2021-06-07"

        // when
        val dateParsed: ZonedDateTime = dateInText.parseZonedDateTime(format = YYYY_MM_DD_DASH)
            ?: throw RuntimeException("Failed to parse")

        // then
        assertEquals(dateInText, dateParsed.print(YYYY_MM_DD_DASH))
    }

    @Test
    fun `given date in MM-DD-YYYY, when parsed with format & converted to date, then should match when printed back to text`() {
        // given
        val dateInText = "06/07/2021"

        // when
        val dateParsed: ZonedDateTime = dateInText.parseZonedDateTime(format = MM_DD_YYYY_SLASH) ?: throw RuntimeException("Failed to parse")

        // then
        assertEquals(dateInText, dateParsed.print(MM_DD_YYYY_SLASH))
    }

}