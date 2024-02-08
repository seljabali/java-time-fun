package localdatetime

import javatimefun.calendar.extensions.toLocalDateTime
import javatimefun.date.extensions.toLocalDateTime
import javatimefun.localdatetime.LocalDateTimeUtil
import javatimefun.localdatetime.extensions.getMonthBaseZero
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar
import java.util.TimeZone

class LocalDateTimeUtilTest {

    @Test
    fun `given date epoch millisecond, when converted to localDateTime, then should match attributes`() {
        // given
        val epoch = 1325134800000

        // when
        val localDateTime = LocalDateTimeUtil.new(epoch)

        // then
        assertEquals(2011, localDateTime.year)
        assertEquals(12, localDateTime.monthValue)
        assertEquals(29, localDateTime.dayOfMonth)
        assertEquals(5, localDateTime.hour)
        assertEquals(0, localDateTime.minute)
        assertEquals(0, localDateTime.second)
    }

    @Test
    fun `given date epoch millisecond of Date, when converted to localDateTime, then should match attributes`() {
        // given
        val epoch = 1325134800000

        // when
        val date = Date(epoch)
        val localDateTime = date.toLocalDateTime()

        // then
        assertEquals(2011, localDateTime.year)
        assertEquals(12, localDateTime.monthValue)
        assertEquals(29, localDateTime.dayOfMonth)
        assertEquals(5, localDateTime.hour)
        assertEquals(0, localDateTime.minute)
        assertEquals(0, localDateTime.second)
    }

    @Test
    fun `given date epoch millisecond of Date & UTC timezone, when converted to localDateTime, then should match attributes`() {
        // given
        val epoch = 1325134800000

        // when
        val date = Date(epoch)
        val calendar = GregorianCalendar().apply {
            timeZone = TimeZone.getTimeZone("UTC")
            time = date
        }
        val localDateTime = calendar.toLocalDateTime()

        // then
        assertEquals(2011, localDateTime.year)
        assertEquals(12, localDateTime.monthValue)
        assertEquals(29, localDateTime.dayOfMonth)
        assertEquals(5, localDateTime.hour)
        assertEquals(0, localDateTime.minute)
        assertEquals(0, localDateTime.second)
        assertEquals(calendar[Calendar.YEAR], localDateTime.year)
        assertEquals(calendar[Calendar.MONTH], localDateTime.getMonthBaseZero())
        assertEquals(calendar[Calendar.DAY_OF_MONTH], localDateTime.dayOfMonth)
        assertEquals(calendar[Calendar.HOUR], localDateTime.hour)
        assertEquals(calendar[Calendar.MINUTE], localDateTime.minute)
        assertEquals(calendar[Calendar.SECOND], localDateTime.second)
        assertEquals(calendar[Calendar.MILLISECOND], localDateTime.toLocalTime().nano / 1000000)
    }
}