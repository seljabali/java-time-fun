
object YearUtil {
    fun isLeapYear(year: Int): Boolean =
        when {
            year % 4 != 0 -> false
            year % 100 == 0 -> year % 400 == 0
            else -> true
        }
}