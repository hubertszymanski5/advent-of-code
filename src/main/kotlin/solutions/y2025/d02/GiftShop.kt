package cc.hubisoft.solutions.y2025.d02

import cc.hubisoft.runner.DaySolution

data class GiftShop(private val input: String): DaySolution {

    private val ranges: List<LongRange> = input
        .split(",")
        .map { it.toRange() }

    override fun solvePartI() = ranges.flatMap { it.toList() }
        .filter { it.isInvalid() }
        .sum()

    override fun solvePartII() = ranges.flatMap { it.toList() }
        .filter { it.isInvalidByMultipleRepetitions() }
        .sum()

    private fun String.toRange() =
        this.split("-")
            .let { (a, b) -> a.toLong()..b.toLong() }

    private fun Long.isInvalid(): Boolean {
        val id = this.toString()
        if (id.length % 2 != 0) return false
        return id.take(id.length / 2) == id.substring(id.length / 2)
    }

    private fun Long.isInvalidByMultipleRepetitions(): Boolean {
        val id = this.toString()
        return isRepetitive(id.first().toString(), id.substring(1))
    }

    private fun isRepetitive(rep: String, rest: String): Boolean {
        if (rest.isEmpty()) return false
        if ("($rep)+".toRegex().matches(rest)) return true
        return isRepetitive(rep + rest.first(), rest.substring(1))
    }
}