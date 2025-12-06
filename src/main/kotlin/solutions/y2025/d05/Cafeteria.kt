package cc.hubisoft.solutions.y2025.day05

import cc.hubisoft.runner.DaySolution
import kotlin.ranges.LongRange.Companion.EMPTY

data class Cafeteria(private val input: List<String>) : DaySolution {

    private val ranges: List<LongRange>
    private val ids: Set<Long>

    init {
        input.filter { it.isNotBlank() }
            .partition { it.contains("-") }
            .let { (rawRanges, rawIds) ->
                ranges = rawRanges.map {
                    it.split("-")
                        .map(String::toLong)
                        .let { (start, end) -> start..end }
                }
                ids = rawIds.map(String::toLong).toSet()
            }
    }

    override fun solvePartI() =
        ids.count { id -> ranges.any { it.contains(id) } }

    override fun solvePartII() = ranges.sortedBy { it.first }
        .fold(FoldingAccumulator()) { acc, range ->
            if (acc.latestRange intersects range) {
                acc.copy(latestRange = acc.latestRange + range)
            } else {
                acc.copy(count = acc.count + acc.latestRange.count(), latestRange = range)
            }
        }
        .let { it.count + it.latestRange.count() }

    private data class FoldingAccumulator(val count: Long = 0, val latestRange: LongRange = EMPTY)

    private infix fun LongRange.intersects(other: LongRange) =
        other.first <= this.last // for asc sorted ranges only

    private operator fun LongRange.plus(other: LongRange) =
        this.first..maxOf(this.last, other.last) // for asc sorted ranges only

    private fun LongRange.count() = last - first + 1 // God bless Kotlin for allowing that
}