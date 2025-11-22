package localdate

import javatimefun.localdate.extensions.atEndOfMonth
import javatimefun.localdate.extensions.atStartOfMonth
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

class LocalDateMutatingTest {
    @Test
    fun `test atStartOfMonth should return first day of month`() {
        val date = LocalDate.of(2025, 11, 22)
        val startOfMonth = date.atStartOfMonth()
        assertEquals(2025, startOfMonth.year)
        assertEquals(11, startOfMonth.monthValue)
        assertEquals(1, startOfMonth.dayOfMonth)
    }

    @Test
    fun `test atEndOfMonth should return last day of month`() {
        val date = LocalDate.of(2025, 11, 22)
        val endOfMonth = date.atEndOfMonth()
        assertEquals(2025, endOfMonth.year)
        assertEquals(11, endOfMonth.monthValue)
        assertEquals(30, endOfMonth.dayOfMonth)
    }
}