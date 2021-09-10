
object YearUtil {
    fun isLeapYear(year: Int): Boolean =
        when {
            year % 4 != 0 -> false
            year % 400 == 0 -> true
            year % 100 == 0 -> false
            else -> true
        }
}