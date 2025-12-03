package cc.hubisoft.solutions.y2025.d03

import kotlin.math.pow

data class Lobby(private val input: List<String>) {

    private val batteries: List<List<Int>> = input.map {
        it.map { it.digitToInt() }
    }

    fun solvePartI() = batteries
        .sumOf { it.getMaxJoltage(2) }

    fun solvePartII(): Long = batteries
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