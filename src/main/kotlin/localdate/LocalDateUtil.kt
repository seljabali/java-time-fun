package localdate

import java.time.LocalDate
import java.time.Month

object LocalDateUtil {
    fun new(
        year: Int,
        month: Int,
        day: Int,
    ): LocalDate =
        LocalDate.of(
            year,
            Month.of(month),
            day
        )
}