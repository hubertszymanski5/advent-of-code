package cc.hubisoft.solutions.y2025.d09

import cc.hubisoft.runner.DaySolution
import cc.hubisoft.utils.IntVector
import cc.hubisoft.utils.Map2D
import kotlin.math.abs

class MovieTheater(input: List<String>) : DaySolution {

    private val points = input.map { it.split(',') }
        .map { IntVector(it[0].toInt(), it[1].toInt()) }

    override fun solvePartI() = points.flatMapIndexed { index, first ->
        points.drop(index + 1).map { second -> first.area(second) }
    }.maxOf { it }

    override fun solvePartII(): Number {
        // TODO
//        val res = points.flatMapIndexed { index, first ->
//            points.drop(index + 1).map { second -> first.area(second) }
//        }
//        println(res)
//        val maxX = points.maxOf { it.x } + 1
//        val maxY = points.maxOf { it.y } + 1
//        val map = Map2D((0..maxY).map { (0..maxX).map { '.' } })
//        (points + points.first()).windowed(2, 1)
//            .forEach { line ->
//                if (line.first().x == line.last().x) {
//                    (line.minOf { it.y }..line.maxOf { it.y }).forEach {
//                        map.replace(
//                            IntVector(line.first().x, it),
//                            'x'
//                        )
//                    }
//                } else if (line.first().y == line.last().y) {
//                    (line.minOf { it.x }..line.maxOf { it.x }).forEach {
//                        map.replace(
//                            IntVector(it, line.first().y),
//                            'x'
//                        )
//                    }
//                } else {
//                    throw IllegalArgumentException("points $line form diagonal line!")
//                }
//            }
//        points.forEach { map.replace(it, '#') }
//        println(map)
        return -1
    }

    private fun IntVector.area(other: IntVector) = abs(1 + x - other.x).toLong() * abs(1 + y - other.y).toLong()
}