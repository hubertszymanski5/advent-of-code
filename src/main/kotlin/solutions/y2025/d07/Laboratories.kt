package cc.hubisoft.solutions.y2025.d07

import cc.hubisoft.runner.DaySolution
import cc.hubisoft.utils.IntVector
import cc.hubisoft.utils.Direction.S as DOWN
import cc.hubisoft.utils.Direction.E as RIGHT
import cc.hubisoft.utils.Direction.W as LEFT

import cc.hubisoft.utils.Map2D

class Laboratories(input: List<String>): DaySolution {

    private val map = Map2D(input.map { it.map { it }})

    override fun solvePartI(): Number {
        val mapCopy = map.copy()
        val toVisit = mutableListOf(start())
        var splits = 0
        while (toVisit.isNotEmpty()) {
            val current = toVisit.removeFirst()
            when (mapCopy.get(current)) {
                '.' -> mapCopy.replace(current, '|').also { toVisit.add(current + DOWN.asVector()) }
                '^' -> {
                    toVisit.add(current + RIGHT.asVector())
                    toVisit.add(current + LEFT.asVector())
                    splits++
                }
                '|' -> { } // do nothing - beams are already there
            }
        }
        return splits
    }

    override fun solvePartII() = timelines(start(), map.copy(), HashMap())

    private fun timelines(pos: IntVector, map: Map2D<Char>, memory: HashMap<IntVector, Long>): Long {
        if (pos in memory) return memory[pos]!!
        if (pos.y == map.ySize - 1) {
            memory[pos] = 1
        } else when (map.get(pos)) {
            '.' -> memory[pos] = timelines(pos + DOWN.asVector(), map, memory)
            '^' -> memory[pos] = timelines(pos + RIGHT.asVector(), map, memory) + timelines(pos + LEFT.asVector(), map, memory)
        }
        return memory[pos]!!
    }

    private fun start() = map.find('S')!!.asVector() + DOWN.asVector()

    private fun Pair<Int, Int>.asVector() = IntVector(first, second)
}