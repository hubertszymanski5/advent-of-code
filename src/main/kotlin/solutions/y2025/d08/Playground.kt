package cc.hubisoft.solutions.y2025.d08

import cc.hubisoft.runner.DaySolution
import cc.hubisoft.utils.IntVector3

class Playground(input: List<String>, private val cables: Int = 1000) : DaySolution {

    private val boxesPositions = input.map { it.split(",").map(String::toInt) }
        .map { IntVector3(it[0], it[1], it[2]) }
    private val distances: Map<Pair<IntVector3, IntVector3>, Double> =
        boxesPositions.flatMapIndexed { firstIndex, first ->
            boxesPositions.drop(firstIndex + 1)
                .filter { it != first }
                .map { second -> first to second }
        }.associate { (it.first to it.second) to (it.first - it.second).length() }

    override fun solvePartI(): Number {
        val circuits: MutableList<MutableSet<IntVector3>> = mutableListOf()
        val orderedConnections = distances.entries
            .sortedBy { it.value }
            .map { it.key }
        var connections = 0
        do {
            addConnection(orderedConnections[connections++], circuits)
        } while (connections < cables)

        return circuits
            .map { it.size }
            .sortedDescending()
            .take(3)
            .reduce(Int::times)
    }

    override fun solvePartII(): Number {
        val circuits = boxesPositions.map { mutableSetOf(it) }.toMutableList()
        val orderedConnections = distances.entries
            .sortedBy { it.value }
            .map { it.key }
        var connections = 0
        while (circuits.size != 1) {
            addConnection(orderedConnections[connections++], circuits)
        }

        return orderedConnections[--connections].let { (first, second) -> first.x.toLong() * second.x.toLong() }
    }

    private fun addConnection(connection: Pair<IntVector3, IntVector3>, circuits: MutableList<MutableSet<IntVector3>>) {
        val (first, second) = connection
        val firstCircuit = circuits.find { it.contains(first) }
        val secondCircuit = circuits.find { it.contains(second) }
        if (firstCircuit != null && secondCircuit != null) {
            if (firstCircuit != secondCircuit) {
                firstCircuit.addAll(secondCircuit)
                circuits.remove(secondCircuit)
            }
        } else if (firstCircuit != null) {
            firstCircuit.add(second)
        } else if (secondCircuit != null) {
            secondCircuit.add(first)
        } else {
            circuits.add(mutableSetOf(first, second))
        }
    }
}