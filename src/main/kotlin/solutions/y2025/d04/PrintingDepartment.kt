package cc.hubisoft.solutions.y2025.d04

import cc.hubisoft.runner.DaySolution
import cc.hubisoft.utils.Direction.Companion.allDirections
import cc.hubisoft.utils.Map2D

data class PrintingDepartment(private val input: List<String>): DaySolution {

    private val map = Map2D(input.map { it.toList() })

    override fun solvePartI() = map.copy().runCleanupInteration()

    override fun solvePartII() = map.copy()
        .let { mapCopy ->
            do {
                val cleanedRolls = mapCopy.runCleanupInteration()
            } while (cleanedRolls > 0)
            mapCopy.values().count { it == 'x' }
        }

    private fun Map2D<Char>.runCleanupInteration(): Int = allCoordinates()
        .filter { this.get(it) == '@' }
        .filter { paperPoint ->
            allDirections()
                .map { it.asVector() + paperPoint }
                .map { this.get(it) }
                .count { it == '@' } < 4
        }
        .map { paperPoint -> paperPoint.also { this.replace(paperPoint, 'x') } }
        .count()
}