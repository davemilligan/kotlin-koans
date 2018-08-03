package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int =
        when {
            this.year != other.year -> year - other.year
            this.month != other.month -> month - other.month
            else -> dayOfMonth - other.dayOfMonth
        }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)
operator fun MyDate.plus(interval: TimeInterval): MyDate = this.addTimeIntervals(interval, 1)
operator fun MyDate.plus(intervals: RepeatedTimeInterval): MyDate = this.addTimeIntervals(intervals.interval, intervals.times)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}
operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)
class DateRange(val start: MyDate, val endInclusive: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> = DateRangeIterator(start, endInclusive)
}

class DateRangeIterator(val start: MyDate, val end:MyDate): Iterator<MyDate> {
    var currentDate: MyDate = start
    override fun hasNext(): Boolean = currentDate <= end

    override fun next(): MyDate {
        var tmp = currentDate
        currentDate = currentDate.nextDay()
        return tmp
    }
}

operator fun DateRange.contains(date: MyDate): Boolean = this.start.compareTo(date) <= 0 && this.endInclusive.compareTo(date) >= 0
