package localdatetime

import javatimefun.localdatetime.extensions.print
import javatimefun.localdatetime.extensions.toLocalDateTime
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.lang.RuntimeException
import java.time.LocalDateTime

class LocalDateTimeParsingExtensionsTest {

    companion object {
        private const val ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss'Z'"
        private const val ISO_8601_S = "yyyy-MM-dd'T'HH:mm:ss.S'Z'"
        private const val ISO_8601_SS = "yyyy-MM-dd'T'HH:mm:ss.SS'Z'"
        private const val ISO_8601_SSS = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        private const val ISO_8601_SSSS = "yyyy-MM-dd'T'HH:mm:ss.SSSS'Z'"
        private const val ISO_8601_SSSSSS = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'"
    }
    
    @Test
    fun `given date in ISO_8601, when parsed without format & converted to date, then should match when printed back to text`() {
        // given
        val dateInText = "2023-07-26T12:34:56Z"

        // when
        val dateParsed: LocalDateTime = dateInText.toLocalDateTime() ?: throw RuntimeException("Failed to parse")

        // then
        assertEquals(dateInText, dateParsed.print(ISO_8601))
        assertEquals("2023-07-26T12:34:56.000000Z", dateParsed.print(ISO_8601_SSSSSS))
    }

    @Test
    fun `given date in ISO_8601_S, when parsed without format & converted to date, then should match when printed back to text`() {
        // given
        val dateInText = "2023-07-26T12:34:56.1Z"

        // when
        val dateParsed: LocalDateTime = dateInText.toLocalDateTime() ?: throw RuntimeException("Failed to parse")

        // then
        assertEquals(dateInText, dateParsed.print(ISO_8601_S))
        assertEquals("2023-07-26T12:34:56.100000Z", dateParsed.print(ISO_8601_SSSSSS))
    }

    @Test
    fun `given date in ISO_8601_SS, when parsed without format & converted to date, then should match when printed back to text`() {
        // given
        val dateInText = "2023-07-26T12:34:56.12Z"

        // when
        val dateParsed: LocalDateTime = dateInText.toLocalDateTime() ?: throw RuntimeException("Failed to parse")

        // then
        assertEquals(dateInText, dateParsed.print(ISO_8601_SS))
        assertEquals("2023-07-26T12:34:56.120000Z", dateParsed.print(ISO_8601_SSSSSS))
    }

    @Test
    fun `given date in ISO_8601_SSS, when parsed without format & converted to date, then should match when printed back to text`() {
        // given
        val dateInText = "2023-07-26T12:34:56.123Z"

        // when
        val dateParsed: LocalDateTime = dateInText.toLocalDateTime() ?: throw RuntimeException("Failed to parse")

        // then
        assertEquals(dateInText, dateParsed.print(ISO_8601_SSS))
        assertEquals("2023-07-26T12:34:56.123000Z", dateParsed.print(ISO_8601_SSSSSS))
    }

    @Test
    fun `given date in ISO_8601_SSSS, when parsed without format & converted to date, then should match when printed back to text`() {
        // given
        val dateInText = "2023-07-26T12:34:56.1234Z"

        // when
        val dateParsed: LocalDateTime = dateInText.toLocalDateTime() ?: throw RuntimeException("Failed to parse")

        // then
        assertEquals(dateInText, dateParsed.print(ISO_8601_SSSS))
        assertEquals("2023-07-26T12:34:56.123400Z", dateParsed.print(ISO_8601_SSSSSS))
    }

    @Test
    fun `given date in ISO_8601_SSSSSS, when parsed without format & converted to date, then should match when printed back to text`() {
        // given
        val dateInText = "2023-07-26T12:34:56.123456Z"

        // when
        val dateParsed: LocalDateTime = dateInText.toLocalDateTime() ?: throw RuntimeException("Failed to parse")

        // then
        assertEquals(dateInText, dateParsed.print(ISO_8601_SSSSSS))
        assertEquals("2023-07-26T12:34:56.123456Z", dateParsed.print(ISO_8601_SSSSSS))
    }

}