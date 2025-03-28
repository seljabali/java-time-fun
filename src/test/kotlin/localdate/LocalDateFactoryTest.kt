package localdate

import javatimefun.calendar.extensions.toLocalDate
import javatimefun.date.extensions.toLocalDate
import javatimefun.localdate.extensions.getMonthBaseZero
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Date
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.TimeZone

class LocalDateFactoryTest {

    @Test
    fun `given date epoch millisecond, when converted to localDateTime, then should match attributes`() {
        // given
        val epoch = 1325134800000

        // when
        val localDate = javatimefun.localdate.LocalDateFactory.new(epoch)

        // then
        assertEquals(2011, localDate.year)
        assertEquals(12, localDate.monthValue)
        assertEquals(29, localDate.dayOfMonth)
    }

    @Test
    fun `given date epoch millisecond of Date, when converted to localDateTime, then should match attributes`() {
        // given
        val epoch = 1325134800000

        // when
        val date = Date(epoch)
        val localDate = date.toLocalDate()

        // then
        assertEquals(2011, localDate.year)
        assertEquals(12, localDate.monthValue)
        assertEquals(29, localDate.dayOfMonth)
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
        val localDate = calendar.toLocalDate()

        // then
        assertEquals(calendar[Calendar.YEAR], localDate.year)
        assertEquals(calendar[Calendar.MONTH], localDate.getMonthBaseZero())
        assertEquals(calendar[Calendar.DAY_OF_MONTH], localDate.dayOfMonth)
        assertEquals(2011, localDate.year)
        assertEquals(12, localDate.monthValue)
        assertEquals(29, localDate.dayOfMonth)
    }
}