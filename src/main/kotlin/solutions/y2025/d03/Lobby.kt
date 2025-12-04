package cc.hubisoft.solutions.y2025.d03

import cc.hubisoft.runner.DaySolution
import kotlin.math.pow

data class Lobby(private val input: List<String>): DaySolution {

    private val batteries: List<List<Int>> = input.map {
        it.map { it.digitToInt() }
    }

    override fun solvePartI() = batteries
        .sumOf { it.getMaxJoltage(2) }

    override fun solvePartII(): Long = batteries
        .sumOf { it.getMaxJoltage(12) }

    private fun List<Int>.getMaxJoltage(n: Int): Long =
        if (n == 0) 0
        else windowed(n, 1)
            .maxOf { it[0] }
            .let { maxNth ->
                indexOf(maxNth)
                    .let { maxNth * 10.0.pow((n - 1).toDouble()).toLong() + subList(it + 1, size).getMaxJoltage(n - 1) }
            }
}