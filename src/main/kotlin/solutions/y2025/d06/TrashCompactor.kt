package cc.hubisoft.solutions.y2025.d06

import cc.hubisoft.runner.DaySolution
import cc.hubisoft.solutions.y2025.d06.TrashCompactor.Operator.Companion.operator
import cc.hubisoft.utils.Map2D

data class TrashCompactor(private val input: List<String>) : DaySolution {

    override fun solvePartI() = Map2D(input.map { it.split(" ").filter(String::isNotBlank) })
        .columns()
        .map { MathProblem(operator(it.last()), it.take(it.size - 1).map(String::toLong)) }
        .sumOf { it.solve() }

    override fun solvePartII() = Map2D(input.map { it.padEnd(input.maxOf(String::length), ' ').map { it } })
        .columns()
        .joinToString("|") {
            it.filter { it != ' ' }
                .joinToString("")
                .replace("[+*]".toRegex(), "")
        }
        .split("||")
        .zip(
            input.last()
                .split(" ")
                .filter { it.isNotBlank() }
                .map { Operator.operator(it) })
        .map { (line, operator) -> MathProblem(operator, line.split("|").map(String::toLong)) }
        .sumOf { it.solve() }

    enum class Operator {
        ADD({ a, b -> a + b }),
        MULTIPLY({ a, b -> a * b });

        val operation: (Long, Long) -> Long

        constructor(operation: (Long, Long) -> Long) {
            this.operation = operation
        }

        companion object {
            fun operator(str: String) = when (str) {
                "+" -> ADD
                "*" -> MULTIPLY
                else -> throw IllegalArgumentException("Invalid operator: $str")
            }
        }
    }

    data class MathProblem(val operator: Operator, val num: List<Long>) {
        fun solve() = num.reduce(operator.operation)
    }
}