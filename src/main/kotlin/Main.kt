package cc.hubisoft

import cc.hubisoft.utils.readFile
import cc.hubisoft.solutions.y2025.d03.Lobby

fun main() {
    val input = readFile(2025, "day03")
    val day = Lobby(input)

    println(day.solvePartI())
    println(day.solvePartII())
}