package cc.hubisoft

import cc.hubisoft.utils.readFile
import cc.hubisoft.solutions.y2025.d04.PrintingDepartment

fun main() {
    val input = readFile(2025, "day04")
    val day = PrintingDepartment(input)

    println(day.solvePartI())
    println(day.solvePartII())
}