package cc.hubisoft.solutions.y2025.d09

import cc.hubisoft.runner.DaySolution
import cc.hubisoft.solutions.y2025.d09.Rectangle.Companion.rectangle
import cc.hubisoft.utils.IntVector
import kotlin.math.abs

class MovieTheater(input: List<String>) : DaySolution {

    private val points = input.map { it.split(',') }
        .map { IntVector(it[0].toInt(), it[1].toInt()) }

    override fun solvePartI() = points.flatMapIndexed { index, first ->
        points.drop(index + 1).map { second -> first.area(second) }
    }.maxOf { it }

    override fun solvePartII(): Number {
        val edges = (points + points.last()).windowed(2, 1).map { it.first() to it.last() }

        return points.flatMapIndexed { index, first ->
            points.drop(index + 1).map { second -> first to second }
        }.map { rectangle(it.first, it.second) }
            .filter { !it.intersects(edges) } // TODO - it should also check if other two vertices are inside polygon - cause of example test failure
            .sortedByDescending { it.area() }
            .take(1)
            .also { println(it) }
            .map { it.area() }
            .first()
    }

    private fun IntVector.area(other: IntVector) = abs(1 + x - other.x).toLong() * abs(1 + y - other.y).toLong()
}