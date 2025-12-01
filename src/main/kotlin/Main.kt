package cc.hubisoft

import cc.hubisoft.utils.readFile
import cc.hubisoft.y2025.d01.SecretEntrance

fun main() {
    val input = readFile(2025, "day01")
    val day = SecretEntrance(input)

    println(day.solvePartI())
    println(day.solvePartII())
}