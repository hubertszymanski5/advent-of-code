package cc.hubisoft.runner

import kotlin.time.measureTime

object SolutionRunner {

    fun run(year: Int, day: Int, printTime: Boolean = false) {
        val day = SolutionProvider.findDay(year, day)?: throw NoSuchElementException("Day $day solution not found in year $year")

        measureTime {
            println("partI:\t${day.solvePartI()}")
            println("partII:\t${day.solvePartII()}")
        }.also { if (printTime) println("Solution took $it") }
    }
}