package cc.hubisoft

import cc.hubisoft.utils.readFile
import cc.hubisoft.solutions.y2025.d02.GiftShop

fun main() {
    val input = readFile(2025, "day02")
    val day = GiftShop(input.joinToString(""))

    println(day.solvePartI())
    println(day.solvePartII())
}