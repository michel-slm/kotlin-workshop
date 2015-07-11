package ii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val yearCmp = year.compareTo(other.year)
        if (yearCmp != 0) return yearCmp;
        val monthCmp = month.compareTo(other.month);
        if (monthCmp != 0) return monthCmp;
        return dayOfMonth.compareTo(other.dayOfMonth)
    }

}

fun MyDate.rangeTo(end: MyDate): DateRange = DateRange(this, end)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override public val start: MyDate, override public val end: MyDate) : Iterable<MyDate>, Range<MyDate> {
    override fun contains(item: MyDate): Boolean {
        return start < item && item < end
    }

    override fun iterator(): Iterator<MyDate> =
            object : Iterator<MyDate> {
                var current = start
                override fun hasNext(): Boolean = current.compareTo(end) <= 0
                override fun next(): MyDate {
                    val saved = current
                    current = current.nextDay()
                    return saved
                }
            }
}
