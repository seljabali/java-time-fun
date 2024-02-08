package localtime

import javatimefun.localtime.LocalTimeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Date
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.TimeZone

class LocalTimeUtilTest {

    @Test
    fun `given date epoch millisecond, when converted to localDateTime, then should match attributes`() {
        // given
        val epoch = 1325134800000

        // when
        val localTime = LocalTimeUtil.new(epoch)

        // then
        assertEquals(5, localTime.hour)
        assertEquals(0, localTime.minute)
        assertEquals(0, localTime.second)
    }

    @Test
    fun `given date epoch millisecond of Date, when converted to localDateTime, then should match attributes`() {
        // given
        val epoch = 1325134800000

        // when
        val date = Date(epoch)
        val localTime = LocalTimeUtil.new(date)

        // then
        assertEquals(5, localTime.hour)
        assertEquals(0, localTime.minute)
        assertEquals(0, localTime.second)
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
        val localTime = LocalTimeUtil.new(calendar)

        // then
        assertEquals(5, localTime.hour)
        assertEquals(0, localTime.minute)
        assertEquals(0, localTime.second)
        assertEquals(calendar[Calendar.HOUR], localTime.hour)
        assertEquals(calendar[Calendar.MINUTE], localTime.minute)
        assertEquals(calendar[Calendar.SECOND], localTime.second)
        assertEquals(calendar[Calendar.MILLISECOND], localTime.nano / 1000000)
    }
    
}